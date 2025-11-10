package org.example.couponeventproject.service

import org.assertj.core.api.Assertions.assertThat
import org.example.couponeventproject.adapter.CouponAdapter
import org.example.couponeventproject.adapter.CouponLogAdapter
import org.example.couponeventproject.testfixture.CouponFixture
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.TestConstructor
import java.util.UUID
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class EventServiceTest(

    private val eventFacade: EventFacade,
    private val jdbcTemplate: JdbcTemplate,
    private val couponAdapter: CouponAdapter,
    @Autowired private val couponLogAdapter: CouponLogAdapter,
    logAdapter: CouponLogAdapter,

    ) {

    private val couponId = UUID.randomUUID().toString()

    @BeforeEach
    fun setUp() {
        CouponFixture.insertCoupon(jdbcTemplate, couponId)
    }

    @Test
    fun `get coupon only one person`() {

        val coupon = eventFacade.getCoupon(couponId, "test-user-id")

        println("register coupon: $coupon")
        assertThat(coupon).isEqualTo(true)
    }


    @Test
    @DisplayName("get coupon multiple people")
    fun `get coupon multiple people apply`() {
        var threadCount = 100
        val executor = Executors.newFixedThreadPool(threadCount)
        val countDownLatch = CountDownLatch(threadCount)

        repeat(100) { i ->
            executor.submit {
                try {
                    println("Task $i is running on ${Thread.currentThread().name}")
                    eventFacade.getCoupon(couponId, "test-user-id-$i")
                } finally {
                    countDownLatch.countDown()
                }
            }
        }

        countDownLatch.await()
        executor.shutdown()
        executor.awaitTermination(10, TimeUnit.SECONDS)

        val couponSize = couponAdapter.getCouponSize(couponId)
        val couponLogSize = couponLogAdapter.getCount(couponId)
        println("All tasks finished.")

        Assertions.assertEquals(0, countDownLatch.count)
        Assertions.assertEquals(couponSize, couponSize)

    }

}
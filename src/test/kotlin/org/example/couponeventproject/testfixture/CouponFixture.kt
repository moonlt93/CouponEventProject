package org.example.couponeventproject.testfixture

object  CouponFixture {

    fun insertCoupon(jdbc: org.springframework.jdbc.core.JdbcTemplate, id: String, size: Int = 100) {
        jdbc.update(
            """
            INSERT INTO coupon.coupon_entity(coupon_id, coupon_type, created_at, expired_date, percent, size, title)
            VALUES (?, 'ALL',CURRENT_DATE() ,CURRENT_DATE() + 3, 40, ?,'test-title')
            """.trimIndent(),
            id, size
        )
    }


}
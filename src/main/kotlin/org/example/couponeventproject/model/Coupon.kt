package org.example.couponeventproject.model

import org.example.couponeventproject.enums.CouponType
import java.time.LocalDate
import java.time.LocalDateTime

class Coupon(
    val couponId: String?,
    val title: String,
    val couponType: CouponType,
    val percent: Int,
    var size: Int,
    val createdAt: LocalDate,
    val expiredDate: LocalDateTime?

) {

    companion object {

        fun createCoupon(couponType: CouponType, title: String, percent: Int, size: Int): Coupon {
            return Coupon(
                couponId = null,
                title = title,
                couponType = couponType,
                percent = percent,
                size = size,
                createdAt = LocalDate.now(),
                expiredDate = LocalDateTime.now().plusDays(3)
            )
        }

    }

    fun minusSize() {

        if (size <= 0) throw Exception("Size is 0")
        size -= 1

    }
}

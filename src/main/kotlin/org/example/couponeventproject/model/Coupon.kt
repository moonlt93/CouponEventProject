package org.example.couponeventproject.model

import org.example.couponeventproject.enums.CouponType
import java.time.LocalDate
import java.time.LocalDateTime

class Coupon(
    val couponId: String?,
    val title: String,
    val couponType: CouponType,
    val percent: Int,
    val size: Int,
    val createdAt: LocalDate,
    val updatedAt: LocalDateTime?

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
                updatedAt = null
            )
        }

    }

    fun minusSize(): Coupon {

        if (size <= 0) throw Exception("Size is 0")

        return Coupon(
            couponId = this.couponId,
            title = this.title,
            couponType = this.couponType,
            percent = this.percent,
            size = this.size - 1,
            createdAt = this.createdAt,
            updatedAt = LocalDateTime.now()
        )
    }
}
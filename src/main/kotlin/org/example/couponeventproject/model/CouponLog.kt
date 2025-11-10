package org.example.couponeventproject.model

import java.time.LocalDateTime

class CouponLog(
    val logId: Long?,
    val couponId: String,
    val userId: String,
    val createdAt: LocalDateTime,
) {

    companion object {
        fun createCouponLog(coupon: Coupon, userId: String): CouponLog {
            return CouponLog(0L, coupon.couponId.toString(), userId, LocalDateTime.now())
        }
    }
}
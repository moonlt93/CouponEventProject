package org.example.couponeventproject.model

import java.time.LocalDateTime

class CouponLog(
    val sequence: Int,
    val couponId: String,
    val userId: String,
    val createdAt: LocalDateTime,
) {
}
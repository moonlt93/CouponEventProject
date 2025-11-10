package org.example.couponeventproject.model.command

import org.example.couponeventproject.enums.CouponType
import org.example.couponeventproject.model.Coupon
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateCouponCommand(
    val title: String,
    val couponType: CouponType,
    val percent: Int,
    val size: Int,
) {
    companion object {
        fun createCouponCommand(couponType: String, title: String, percent: Int, size: Int): CreateCouponCommand {
            return CreateCouponCommand(title, CouponType.valueOf(couponType), percent, size)
        }
    }
}
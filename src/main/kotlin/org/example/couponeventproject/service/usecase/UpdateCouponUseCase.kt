package org.example.couponeventproject.service.usecase

import org.example.couponeventproject.model.Coupon

interface UpdateCouponUseCase {

    fun updateCoupon(couponId: String): Coupon

}
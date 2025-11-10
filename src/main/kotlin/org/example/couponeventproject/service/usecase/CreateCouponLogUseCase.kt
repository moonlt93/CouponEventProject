package org.example.couponeventproject.service.usecase

import org.example.couponeventproject.model.Coupon

interface CreateCouponLogUseCase {

    fun createCouponLog(updatedCoupon: Coupon, userId: String): Boolean

}
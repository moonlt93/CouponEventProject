package org.example.couponeventproject.service.usecase

interface EventJoinUseCase {

    fun getCoupon(couponId: String, userId: String): Boolean

}
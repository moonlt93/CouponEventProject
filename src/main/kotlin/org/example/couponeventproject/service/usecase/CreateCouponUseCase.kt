package org.example.couponeventproject.service.usecase

import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.model.command.CreateCouponCommand

interface CreateCouponUseCase {

    fun createCoupon(createCommand: CreateCouponCommand): Unit

}
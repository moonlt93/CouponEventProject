package org.example.couponeventproject.service.port

import org.example.couponeventproject.model.Coupon

interface CreateCouponPort {

    fun createCoupon(createCoupon: Coupon)

}
package org.example.couponeventproject.service.port

import org.example.couponeventproject.model.Coupon

interface LoadCouponInfoPort {

    fun findCouponById(couponId: String): Coupon

}

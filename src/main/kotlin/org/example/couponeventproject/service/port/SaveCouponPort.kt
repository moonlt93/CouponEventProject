package org.example.couponeventproject.service.port

import org.example.couponeventproject.model.Coupon

interface SaveCouponPort {

    fun updateCoupon(coupon: Coupon): Coupon

}

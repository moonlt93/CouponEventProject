package org.example.couponeventproject.service.port

import org.example.couponeventproject.model.CouponLog

interface SaveCouponLogPort {

    fun saveCoupon(createCouponLog: CouponLog): Boolean

}

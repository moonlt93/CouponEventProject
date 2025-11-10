package org.example.couponeventproject.service

import jakarta.transaction.Transactional
import org.example.couponeventproject.model.CouponLog
import org.example.couponeventproject.service.port.LoadCouponInfoPort
import org.example.couponeventproject.service.port.SaveCouponLogPort
import org.example.couponeventproject.service.port.SaveCouponPort
import org.example.couponeventproject.service.usecase.EventJoinUseCase
import org.springframework.stereotype.Service

@Service
class EventFacade(
    private val updateCouponService: UpdateCouponService,
    private val createCouponLogService: CreateCouponLogService

) : EventJoinUseCase {

    override fun getCoupon(couponId: String, userId: String): Boolean {


        val coupon = updateCouponService.updateCoupon(couponId)
        val createCouponLog = createCouponLogService.createCouponLog(coupon, userId)

        return createCouponLog
    }
}
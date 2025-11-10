package org.example.couponeventproject.service

import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.example.couponeventproject.model.CouponLog
import org.example.couponeventproject.service.port.LoadCouponInfoPort
import org.example.couponeventproject.service.port.SaveCouponLogPort
import org.example.couponeventproject.service.usecase.EventJoinUseCase
import org.springframework.stereotype.Service

@Service
class EventService(
    private val loadCouponInfoPort: LoadCouponInfoPort,
    private val saveCouponLogPort: SaveCouponLogPort
) : EventJoinUseCase {

    @Transactional
    override fun getCoupon(couponId: String, userId: String): Boolean {

        val coupon = loadCouponInfoPort.findCouponById(couponId)

        coupon.minusSize()

        val createCouponLog = CouponLog.createCouponLog(coupon, userId)

        return saveCouponLogPort.saveCoupon(createCouponLog)

    }
}
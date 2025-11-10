package org.example.couponeventproject.service

import jakarta.transaction.Transactional
import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.model.CouponLog
import org.example.couponeventproject.service.port.SaveCouponLogPort
import org.example.couponeventproject.service.usecase.CreateCouponLogUseCase
import org.springframework.stereotype.Service

@Service
class CreateCouponLogService(
    private val saveCouponLogPort: SaveCouponLogPort
) : CreateCouponLogUseCase {

    @Transactional
    override fun createCouponLog(updatedCoupon: Coupon, userId: String): Boolean {

        val createCouponLog = CouponLog.createCouponLog(updatedCoupon, userId)
        return saveCouponLogPort.saveCoupon(createCouponLog)

    }
}

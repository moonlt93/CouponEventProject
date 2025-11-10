package org.example.couponeventproject.service

import jakarta.transaction.Transactional
import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.service.port.LoadCouponInfoPort
import org.example.couponeventproject.service.port.SaveCouponPort
import org.example.couponeventproject.service.usecase.UpdateCouponUseCase
import org.springframework.stereotype.Service

@Service
class UpdateCouponService(
    private val LoadCouponInfoPort: LoadCouponInfoPort,
    private val saveCouponPort: SaveCouponPort
) : UpdateCouponUseCase {


    @Transactional
    override fun updateCoupon(couponId: String): Coupon {

        val coupon = LoadCouponInfoPort.findCouponById(couponId)
        coupon.minusSize()

        val updatedCoupon = saveCouponPort.updateCoupon(coupon)

        return updatedCoupon
    }

}
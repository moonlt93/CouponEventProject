package org.example.couponeventproject.service

import lombok.RequiredArgsConstructor
import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.model.command.CreateCouponCommand
import org.example.couponeventproject.service.port.CreateCouponPort
import org.example.couponeventproject.service.usecase.CreateCouponUseCase
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CreateCouponService(
    private val createCouponPort: CreateCouponPort
) : CreateCouponUseCase {


    override fun createCoupon(createCommand: CreateCouponCommand) {

        val createCoupon = Coupon.createCoupon(createCommand.couponType, createCommand.title, createCommand.percent, createCommand.size)
        createCouponPort.createCoupon(createCoupon)

    }
}
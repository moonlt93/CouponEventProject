package org.example.couponeventproject.mapper

import org.example.couponeventproject.enums.CouponType
import org.example.couponeventproject.model.command.CreateCouponCommand
import org.example.couponeventproject.model.dto.CreateCouponRequest
import org.springframework.stereotype.Component

@Component
class CouponWebMapper {

    fun mapToCommand(request: CreateCouponRequest) =
        CreateCouponCommand.createCouponCommand(request.couponType, request.title, request.percent, request.size)
}

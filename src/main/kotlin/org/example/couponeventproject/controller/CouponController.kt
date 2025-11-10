package org.example.couponeventproject.controller

import lombok.RequiredArgsConstructor
import org.example.couponeventproject.mapper.CouponWebMapper
import org.example.couponeventproject.model.dto.CreateCouponRequest
import org.example.couponeventproject.service.usecase.CreateCouponUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/coupons")
@RestController
@RequiredArgsConstructor
class CouponController(
    private val createCouponUseCase: CreateCouponUseCase,

    private val couponWebMapper: CouponWebMapper
) {


    @RequestMapping("/generate")
    fun createCoupon(@RequestBody request: CreateCouponRequest): ResponseEntity.BodyBuilder {

        val createCommand = couponWebMapper.mapToCommand(request)
        createCouponUseCase.createCoupon(createCommand)
        return ResponseEntity.created(URI("/coupons"));

    }


}
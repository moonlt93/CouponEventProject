package org.example.couponeventproject.controller

import org.example.couponeventproject.service.usecase.EventJoinUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/events")
class EventController(
    private val eventJoinUseCase: EventJoinUseCase
) {


    @PostMapping("/join")
    fun joinCouponEvents(
        @RequestParam("couponId") couponId: String,
        @RequestParam("userId") userId: String
    ): ResponseEntity<Any> {
        val coupon = eventJoinUseCase.getCoupon(couponId, userId)
        return ResponseEntity.status(200).body(coupon)
    }

}
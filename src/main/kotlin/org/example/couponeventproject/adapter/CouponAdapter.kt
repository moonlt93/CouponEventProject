package org.example.couponeventproject.adapter

import org.example.couponeventproject.mapper.CouponPersistenceMapper
import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.repository.CouponRepository
import org.example.couponeventproject.service.port.CreateCouponPort
import org.springframework.stereotype.Component

@Component
class CouponAdapter(
    private val couponRepository: CouponRepository,

    private val couponPersistenceMapper: CouponPersistenceMapper
) : CreateCouponPort {

    override fun createCoupon(createCoupon: Coupon) {

        val mapToCreateEntity = couponPersistenceMapper.mapToCreateEntity(createCoupon)
        couponRepository.save(mapToCreateEntity)

    }
}
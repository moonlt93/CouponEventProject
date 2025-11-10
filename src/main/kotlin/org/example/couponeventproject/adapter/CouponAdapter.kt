package org.example.couponeventproject.adapter

import org.example.couponeventproject.mapper.CouponPersistenceMapper
import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.repository.CouponRepository
import org.example.couponeventproject.service.port.CreateCouponPort
import org.example.couponeventproject.service.port.LoadCouponInfoPort
import org.example.couponeventproject.service.port.SaveCouponPort
import org.springframework.stereotype.Component

@Component
class CouponAdapter(
    private val couponRepository: CouponRepository,

    private val couponPersistenceMapper: CouponPersistenceMapper
) : CreateCouponPort, LoadCouponInfoPort, SaveCouponPort {

    override fun createCoupon(createCoupon: Coupon) {

        val mapToCreateEntity = couponPersistenceMapper.mapToCreateEntity(createCoupon)
        couponRepository.save(mapToCreateEntity)

    }

    override fun updateCoupon(coupon: Coupon): Coupon {

        val entity = couponPersistenceMapper.mapToEntity(coupon)

        couponRepository.save(entity)
        return couponPersistenceMapper.mapToDomain(entity)

    }

    override fun findCouponById(couponId: String): Coupon {

        val findCoupon = couponRepository.findByCouponId(couponId)
            .orElseThrow { IllegalArgumentException("Coupon not found $couponId") }

        return couponPersistenceMapper.mapToDomain(findCoupon)
    }


    fun getCouponSize(couponId: String): Int {

        val findCoupon = couponRepository.findById(couponId)
            .orElseThrow { IllegalArgumentException("Coupon not found $couponId") }

        return findCoupon.size

    }
}
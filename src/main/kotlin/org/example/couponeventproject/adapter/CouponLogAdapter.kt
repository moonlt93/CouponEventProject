package org.example.couponeventproject.adapter

import org.example.couponeventproject.mapper.CouponLogPersistenceMapper
import org.example.couponeventproject.model.CouponLog
import org.example.couponeventproject.repository.CouponLogRepository
import org.example.couponeventproject.service.port.SaveCouponLogPort
import org.springframework.stereotype.Component

@Component
class CouponLogAdapter(
    private val couponLogRepository: CouponLogRepository,

    private val couponLogPersistenceMapper: CouponLogPersistenceMapper
) : SaveCouponLogPort {

    override fun saveCoupon(createCouponLog: CouponLog): Boolean {

        val mapToCreateEntity = couponLogPersistenceMapper.mapToCreateEntity(createCouponLog)
        couponLogRepository.save(mapToCreateEntity)

        return true

    }

}
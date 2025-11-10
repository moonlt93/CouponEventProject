package org.example.couponeventproject.mapper

import org.example.couponeventproject.model.CouponLog
import org.example.couponeventproject.model.entity.CouponLogEntity
import org.springframework.stereotype.Component

@Component
class CouponLogPersistenceMapper {


    fun mapToCreateEntity(couponLog: CouponLog): CouponLogEntity {
        return CouponLogEntity(null, couponLog.couponId, couponLog.userId, couponLog.createdAt)
    }

    fun mapToEntity(couponLog: CouponLog) =
        CouponLogEntity(couponLog.logId, couponLog.couponId, couponLog.userId, couponLog.createdAt)

    fun mapToDomain(entity: CouponLogEntity) =
        CouponLog(entity.logId, entity.couponId, entity.userId, entity.createdAt)

}



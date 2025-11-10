package org.example.couponeventproject.mapper

import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.model.entity.CouponEntity
import org.springframework.stereotype.Component

@Component
class CouponPersistenceMapper {


    fun mapToCreateEntity(coupon: Coupon) =
        CouponEntity(coupon.couponId, coupon.title, coupon.couponType, coupon.percent, coupon.size, coupon.createdAt, coupon.expiredDate)

    fun mapToEntity(coupon: Coupon) =
        CouponEntity(coupon.couponId, coupon.title, coupon.couponType, coupon.percent, coupon.size, coupon.createdAt, coupon.expiredDate)

    fun mapToDomain(entity: CouponEntity) =
        Coupon(entity.couponId,entity.title,entity.couponType,entity.percent,entity.size,entity.createdAt,entity.expiredDate)
}

package org.example.couponeventproject.mapper

import org.example.couponeventproject.model.Coupon
import org.example.couponeventproject.model.command.CreateCouponCommand
import org.example.couponeventproject.model.entity.CouponEntity
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CouponPersistenceMapper {


    fun mapToCreateEntity(coupon: Coupon) =
        CouponEntity(coupon.couponId, coupon.title, coupon.couponType, coupon.percent, coupon.size, LocalDate.now(), null)

    fun mapToEntity(coupon: Coupon) =
        CouponEntity(coupon.couponId, coupon.title, coupon.couponType, coupon.percent, coupon.size, coupon.createdAt, coupon.updatedAt)

    fun mapToDomain(entity: CouponEntity) =
        Coupon(entity.couponId,entity.title,entity.couponType,entity.percent,entity.size,entity.createdAt,entity.updatedAt)
}

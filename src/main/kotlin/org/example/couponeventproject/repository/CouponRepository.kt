package org.example.couponeventproject.repository

import org.example.couponeventproject.model.entity.CouponEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface CouponRepository : JpaRepository<CouponEntity, String> {

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from CouponEntity as c  where c.couponId = :couponId")
    fun findByCouponId(couponId: String): Optional<CouponEntity>
}
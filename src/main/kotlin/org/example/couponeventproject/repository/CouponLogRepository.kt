package org.example.couponeventproject.repository

import org.example.couponeventproject.model.entity.CouponLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CouponLogRepository : JpaRepository<CouponLogEntity, Long> {

    @Query("SELECT c FROM CouponLogEntity c WHERE c.couponId = :couponId")
    fun findByCouponId(couponId: String) : List<CouponLogEntity>

}

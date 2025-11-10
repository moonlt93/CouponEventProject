package org.example.couponeventproject.repository

import org.example.couponeventproject.model.entity.CouponLogEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CouponLogRepository : JpaRepository<CouponLogEntity, Long> {

}

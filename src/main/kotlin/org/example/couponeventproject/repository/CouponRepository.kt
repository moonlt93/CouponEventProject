package org.example.couponeventproject.repository

import org.example.couponeventproject.model.entity.CouponEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CouponRepository : JpaRepository<CouponEntity, String> {
}
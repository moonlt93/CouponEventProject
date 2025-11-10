package org.example.couponeventproject.model.entity

import jakarta.persistence.*
import org.example.couponeventproject.enums.CouponType
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "coupon_entity")
class CouponEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val couponId: String?,
    val title: String,
    @Enumerated(EnumType.STRING)
    val couponType: CouponType,
    val percent: Int,
    val size: Int,
    val createdAt: LocalDate,
    val expiredDate: LocalDateTime? = null,

    ) {}
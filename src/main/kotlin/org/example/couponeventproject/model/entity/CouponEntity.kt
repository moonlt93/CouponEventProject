package org.example.couponeventproject.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.example.couponeventproject.enums.CouponType
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
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
    val updatedAt: LocalDateTime? = null,
) {}
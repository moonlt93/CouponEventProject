package org.example.couponeventproject.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Entity
@Getter
@NoArgsConstructor
class CouponLogEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val logId: String,
    val sequence: Int,
    val couponId: String,
    val userId: String,
    val createdAt: LocalDateTime,
) {

}
package org.example.couponeventproject.model.dto


data class CreateCouponRequest(
    val title: String,
    val couponType: String,
    val percent: Int,
    val size: Int,
) {

}

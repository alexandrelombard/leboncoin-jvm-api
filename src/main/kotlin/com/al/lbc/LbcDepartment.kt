package com.al.lbc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LbcDepartment(
    val id: String,
    val name: String,
    val channel: String,
    @SerialName("region_id")
    val regionId: String,
    val neighbours: List<String>
)
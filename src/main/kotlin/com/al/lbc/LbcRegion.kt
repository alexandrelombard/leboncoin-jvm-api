package com.al.lbc

import kotlinx.serialization.Serializable

/**
 * Contains data about a region
 * @author Alexandre Lombard
 */
@Serializable
data class LbcRegion(
    val id: String,
    val name: String,
    val channel: String,
    val neighbours: List<String>,
    val departments: List<String>)
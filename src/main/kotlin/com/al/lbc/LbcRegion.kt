package com.al.lbc

data class LbcRegion(
    val id: String,
    val name: String,
    val channel: String,
    val neighbours: List<String>,
    val deparments: List<String>) {

}
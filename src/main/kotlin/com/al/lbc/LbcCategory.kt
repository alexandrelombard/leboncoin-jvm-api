package com.al.lbc

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

//@Serializable
//data class LbcCategory(
//    @Optional
//    var id: Int = 0,
//    @Optional
//    var label: String = "",
//    @Optional
//    var channel: String = "",
//    @Optional
//    var subcategories: Array<LbcSubCategory> = arrayOf()) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as LbcCategory
//
//        if (id != other.id) return false
//        if (label != other.label) return false
//        if (channel != other.channel) return false
//        if (!subcategories.contentEquals(other.subcategories)) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = id
//        result = 31 * result + label.hashCode()
//        result = 31 * result + channel.hashCode()
//        result = 31 * result + subcategories.contentHashCode()
//        return result
//    }
//}
//
//@Serializable
//data class LbcSubCategory(
//    @Optional
//    var id: Int = 0,
//    @Optional
//    var label: String = "",
//    @Optional
//    var channel: String = ""
//)
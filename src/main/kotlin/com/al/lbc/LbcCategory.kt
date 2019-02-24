package com.al.lbc

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

/**
 * Data class representing a category
 * @author Alexandre Lombard
 */
@Serializable
data class LbcCategory(
    /** The ID */
    @Optional
    var id: Int = 0,
    /** The label (intelligible name) */
    @Optional
    var label: String = "",
    /** The channel (name) */
    @Optional
    var channel: String = "",
    /** The subcategories, if present */
    @Optional
    var subcategories: Array<LbcCategory> = arrayOf()) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LbcCategory

        if (id != other.id) return false
        if (label != other.label) return false
        if (channel != other.channel) return false
        if (!subcategories.contentEquals(other.subcategories)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + label.hashCode()
        result = 31 * result + channel.hashCode()
        result = 31 * result + subcategories.contentHashCode()
        return result
    }
}
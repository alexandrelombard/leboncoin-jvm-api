package com.al.lbc

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.parseList

/**
 * Object storing the references to the categories
 * @author Alexandre Lombard
 */
@kotlinx.serialization.ImplicitReflectionSerializer
object LbcCategories {

    private val resourceFile = "categories.json"
    /** List of all categories */
    private val categories: List<LbcCategory>
    /** Map linking a channel to the associated category */
    private val categoriesMap: Map<String, LbcCategory>

    init {
        val categoriesFileContent = javaClass.getResource(resourceFile).readText()

        // Read the categories.json file
        categories = Json.parseList(categoriesFileContent)

        // Process the categories to build a more intelligible map linking the channels to the categories and
        // subcategories
        val localMap = hashMapOf<String, LbcCategory>()
        categories.forEach {
            localMap[it.channel] = it
            it.subcategories.forEach { localMap[it.channel] = it }
        }
        categoriesMap = localMap
    }

    /**
     * Synthetic accessor for the categories
     * @param channel the channel
     * @return the category
     */
    operator fun get(channel: String): LbcCategory? {
        return categoriesMap[channel]
    }
}

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
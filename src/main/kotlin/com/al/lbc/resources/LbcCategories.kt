package com.al.lbc.resources

import com.al.lbc.LbcCategory
import com.al.lbc.extended.Category
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

    operator fun get(category: Category): LbcCategory {
        // We assume that if it's an enumerated category, then the value exists
        return categoriesMap.getValue(category.channel)
    }
}
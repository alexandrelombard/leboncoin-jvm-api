package com.al.lbc

import com.al.lbc.extended.Category
import com.al.lbc.extended.Region
import com.al.lbc.resources.LbcCategories
import com.al.lbc.resources.LbcRegions
import khttp.responses.Response
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class LbcSearch(
    val filters: Filters,
    val limit: Int,
    val limit_alu: Int,
    val offset: Int) {
    fun post(): Response {
        val jsonSearch = Json.stringify(LbcSearch.serializer(), this)

        return khttp.post(
            url = "http://api.leboncoin.fr/finder/search",
            headers = mapOf(
                Pair("origin",  "https://www.leboncoin.fr"),
                Pair("api_key",  "ba0c2dad52b3ec"),
                Pair("content-type",  "text/plain;charset=UTF-8"),
                Pair("accept",  "*/*"),
                Pair("referer",  "https://www.leboncoin.fr/annonces/offres/ile_de_france/")),
            data = jsonSearch)
    }
}

@Serializable
data class Filters(
    val category: SearchCategory,
    val enums: Map<String, List<String>>,
    val keywords: SearchKeywords,
    val location: SearchLocation,
    val ranges: Map<String, SearchRange>
) {
    @kotlinx.serialization.ImplicitReflectionSerializer
    constructor(
        category: Category,
        enums: Map<String, List<String>>,
        keywords: SearchKeywords,
        region: Region,
        ranges: Map<String, SearchRange>
    ) : this(SearchCategory(category), enums, keywords, SearchLocation(region), ranges)
}

@Serializable
data class SearchRange(
    val min: Int,
    val max: Int
)

@Serializable
data class SearchLocation(
    val region: String
) {
    constructor(id: Int) : this(id.toString())
    @kotlinx.serialization.ImplicitReflectionSerializer
    constructor(region: Region) : this(LbcRegions[region].id)
}

@Serializable
class SearchKeywords(
)

@Serializable
data class SearchCategory(
    val id: String
) {
    constructor(id: Int) : this(id.toString())
    @kotlinx.serialization.ImplicitReflectionSerializer
    constructor(category: Category): this(LbcCategories[category].id)
}
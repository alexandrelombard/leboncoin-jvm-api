package com.al.lbc

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
    val category: Category,
    val enums: Enums,
    val keywords: Keywords,
    val location: Location,
    val ranges: Ranges
)

@Serializable
data class Enums(
    val ad_type: List<String>,
    val brand: List<String>,
    val fuel: List<String>,
    val gearbox: List<String>,
    val model: List<String>
)

@Serializable
data class Ranges(
    val mileage: Mileage,
    val price: Price
)

@Serializable
data class Price(
    val max: Int,
    val min: Int
)

@Serializable
data class Mileage(
    val max: Int,
    val min: Int
)

@Serializable
data class Location(
    val region: String
)

@Serializable
class Keywords(
)

@Serializable
data class Category(
    val id: String
) {
    constructor(id: Int) : this(id.toString())
}
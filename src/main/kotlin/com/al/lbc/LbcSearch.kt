package com.al.lbc

import com.al.lbc.extended.Category
import com.al.lbc.extended.Department
import com.al.lbc.extended.Region
import com.al.lbc.resources.LbcCategories
import com.al.lbc.resources.LbcDepartments
import com.al.lbc.resources.LbcRegions
import khttp.responses.Response
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
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
    @Optional
    val min: Int? = null,
    @Optional
    val max: Int? = null
)

@Serializable
data class SearchLocation(
    val region: String
) {
    @kotlinx.serialization.ImplicitReflectionSerializer
    constructor(region: Region) : this(LbcRegions[region].id)
}

//@Serializable
//data class SearchLocations(val locations: MutableList<SearchLocation> = arrayListOf()) {
//    constructor(vararg locations: SearchLocation) : this(locations.toMutableList())
//
//    fun location(init: SearchLocation.() -> Unit) {
//        val searchLocation = SearchLocation()
//        searchLocation.init()
//        this.locations.add(searchLocation)
//    }
//}
//
//@Serializable
//data class SearchLocation(
//    @Optional
//    @SerialName("region_id")
//    val region: String? = null,
//    @Optional
//    @SerialName("department_id")
//    val department: String? = null,
//    @Optional
//    val zipcode: String? = null,
//    @Optional
//    val locationType: String? = null,
//    @Optional
//    val city: String? = null
//) {
//    @kotlinx.serialization.ImplicitReflectionSerializer
//    constructor(region: Region) : this(LbcRegions[region].id, locationType = SearchLocationType.REGION.value)
//    @kotlinx.serialization.ImplicitReflectionSerializer
//    constructor(region: Region, near: Boolean) :
//            this(region = LbcRegions[region].id,
//                locationType = if(near) SearchLocationType.REGION_NEAR.value else SearchLocationType.REGION.value)
//    @kotlinx.serialization.ImplicitReflectionSerializer
//    constructor(department: Department) :
//            this(region = LbcDepartments[department].id, locationType = SearchLocationType.DEPARTMENT.value,
//                department = LbcDepartments[department].regionId)
//    @kotlinx.serialization.ImplicitReflectionSerializer
//    constructor(zipcode: String) : this(locationType = SearchLocationType.CITY.value, zipcode = zipcode)
//    @kotlinx.serialization.ImplicitReflectionSerializer
//    constructor(zipcode: String, city: String) :
//            this(locationType = SearchLocationType.CITY.value, zipcode = zipcode, city = city)
//}

enum class SearchLocationType(val value: String) {
    REGION_NEAR("region_near"),
    CITY("city"),
    REGION("region"),
    DEPARTMENT("department")
}

@Serializable
data class SearchKeywords(val text: String = "")

@Serializable
data class SearchCategory(
    val id: String
) {
    constructor(id: Int) : this(id.toString())
    @kotlinx.serialization.ImplicitReflectionSerializer
    constructor(category: Category): this(LbcCategories[category].id)
}
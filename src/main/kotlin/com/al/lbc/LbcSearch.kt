package com.al.lbc

import kotlinx.serialization.Serializable

//@Serializable
//data class LbcSearch(
//    @Optional
//    var page: Int = 0,
//    @Optional
//    var query: String = "",
//    @Optional
//    var filter: LbcFilter = LbcFilter.PARTICULIER,
//    @Optional
//    var category: String = "",
//    @Optional
//    var region: String = "",
//    @Optional
//    var departement: String = "",
//    @Optional
//    var location: Array<LbcLocation> = arrayOf(),
//    @Optional
//    var extras: Array<LbcSearchExtra> = arrayOf()) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as LbcSearch
//
//        if (page != other.page) return false
//        if (query != other.query) return false
//        if (filter != other.filter) return false
//        if (category != other.category) return false
//        if (region != other.region) return false
//        if (departement != other.departement) return false
//        if (!location.contentEquals(other.location)) return false
//        if (!extras.contentEquals(other.extras)) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = page
//        result = 31 * result + query.hashCode()
//        result = 31 * result + filter.hashCode()
//        result = 31 * result + category.hashCode()
//        result = 31 * result + region.hashCode()
//        result = 31 * result + departement.hashCode()
//        result = 31 * result + location.contentHashCode()
//        result = 31

@Serializable
data class LbcSearch(
    val filters: Filters,
    val limit: Int,
    val limit_alu: Int,
    val offset: Int
)

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
)
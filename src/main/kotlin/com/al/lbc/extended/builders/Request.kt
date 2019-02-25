package com.al.lbc.extended.builders

import com.al.lbc.*
import com.al.lbc.extended.Category
import com.al.lbc.extended.Region
import kotlinx.serialization.ImplicitReflectionSerializer

/**
 * Type safe build for requests
 * @author Alexandre Lombard
 */
class Request(
    var adType: AdType = AdType.OFFER,
    var locations: List<SearchLocation> = listOf(),
    var keywords: String = "",
    var enums: MutableMap<String, List<String>> = hashMapOf(),
    var ranges: MutableMap<String, SearchRange> = hashMapOf(),
    var limit: Int = 35,
    var limitAlu: Int = 3,
    val offset: Int = 35) {

    var category: Category = Category.MISC
        private set

    fun voitures(init: VoitureRequest.() -> Unit) {
        this.category = Category.VOITURES

        val voitureRequest = VoitureRequest()
        voitureRequest.init()

        val brand = voitureRequest.brand
        if(brand != null)
            enums["brand"] = listOf(brand)

        val model = voitureRequest.model
        if(model != null)
            enums["model"] = listOf(model)

        val fuel = voitureRequest.fuel
        if(fuel != null)
            enums["fuel"] = listOf(fuel)

        val gearbox = voitureRequest.gearbox
        if(gearbox != null)
            enums["gearbox"] = listOf(gearbox.id)

        val priceRange = voitureRequest.priceRange
        if(priceRange != null)
            ranges["price"] = priceRange

        val yearRange = voitureRequest.yearRange
        if(yearRange != null)
            ranges["regdate"] = yearRange
    }

    fun ventesImmobilieres(init: VentesImmobilieresRequest.() -> Unit) {
        this.category = Category.VENTES_IMMOBILIERES

        val ventesImmobilieresRequest = VentesImmobilieresRequest()
        ventesImmobilieresRequest.init()

        val realEstateTypes = ventesImmobilieresRequest.realEstateTypes
        if(realEstateTypes != null)
            enums["real_estate_type"] = realEstateTypes.map { it.value.toString() }

        val priceRange = ventesImmobilieresRequest.priceRange
        if(priceRange != null)
            ranges["price"] = priceRange

        val squareRange = ventesImmobilieresRequest.squareRange
        if(squareRange != null)
            ranges["square"] = squareRange

        val roomsRange = ventesImmobilieresRequest.roomsRange
        if(roomsRange != null)
            ranges["rooms"] = roomsRange
    }
}

@ImplicitReflectionSerializer
fun request(init: Request.() -> Unit): LbcSearch {
    val request = Request()
    request.init()

    val lbcSearch = LbcSearch(
        Filters(
            request.category,
            request.enums,
            SearchKeywords(request.keywords),
            SearchLocations(request.locations),
            request.ranges),
        request.limit,
        request.limitAlu,
        request.offset)

    return lbcSearch
}
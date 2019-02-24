package com.al.lbc.extended.builders

import com.al.lbc.Filters
import com.al.lbc.LbcSearch
import com.al.lbc.SearchKeywords
import com.al.lbc.SearchRange
import com.al.lbc.extended.Category
import com.al.lbc.extended.Region
import kotlinx.serialization.ImplicitReflectionSerializer

class Request(
    var adType: AdType = AdType.OFFER,
    var region: Region = Region.ILE_DE_FRANCE,
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
        if(brand != null) {
            enums["brand"] = listOf(brand)
        }

        val priceRange = voitureRequest.priceRange
        if(priceRange != null)
            ranges["price"] = priceRange

        val yearRange = voitureRequest.yearRange
        if(yearRange != null)
            ranges["regdate"] = yearRange
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
            request.region,
            request.ranges),
        request.limit,
        request.limitAlu,
        request.offset)

    return lbcSearch
}
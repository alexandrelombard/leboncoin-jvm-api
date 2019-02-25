package com.al.lbc

import com.al.lbc.extended.Category
import com.al.lbc.extended.Region
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse

/**
 * Non-unit test class for API functions
 * @author Alexandre Lombard
 */
@kotlinx.serialization.ImplicitReflectionSerializer
class LbcApiTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Build the request
            val search = LbcSearch(
                Filters(
                    Category.VOITURES,
                    mapOf(
                        Pair("ad_type", listOf("offer")),
                        Pair("brand", listOf("Bmw")),
                        Pair("fuel", listOf("1")),
                        Pair("gearbox", listOf("1")),
                        Pair("model", listOf("Serie 1"))),
                    SearchKeywords(),
                    SearchLocations(SearchLocation(Region.ILE_DE_FRANCE)),
                    mapOf(
                        Pair("mileage", SearchRange(20000, 60000)),
                        Pair("price", SearchRange(250, 47500)))
                    ),

                35,
                3,
                35
            )

            // Get and print the results
            val res = search.post()
            println("HTTP Status: ${res.statusCode}")
            println(String(res.content))

            // Parse the results
            val searchResults = Json.parse<LbcSearchResults>(String(res.content))
            println("Total: ${searchResults.total}")
        }
    }
}
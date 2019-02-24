package com.al.lbc

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
                    Category(LbcCategories["voitures"]?.id ?: 0),
                    Enums(
                        listOf("offer"),
                        listOf("Bmw"),
                        listOf("1"),
                        listOf("1"),
                        listOf("Serie 1")),
                    Keywords(),
                    Location("12"),
                    Ranges(
                        Mileage(60000, 20000),
                        Price(47500, 250))),
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
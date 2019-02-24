package com.al.lbc

import com.al.lbc.extended.Category
import com.al.lbc.extended.builders.AdType
import com.al.lbc.extended.builders.request
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse

/**
 * Non-unit test class for request builders
 * @author Alexandre Lombard
 */
@kotlinx.serialization.ImplicitReflectionSerializer
class RequestBuilderTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Build the request
            val res =
                request {
                    adType = AdType.OFFER
                    voitures {
                        brand = "Bmw"
                        priceRange = SearchRange(10000, 40000)
                    }
                }.post()

            // Print the results
            println(String(res.content))

            // Parse the results
            val searchResults = Json.parse<LbcSearchResults>(String(res.content))
            println("Total: ${searchResults.total}")
        }
    }
}
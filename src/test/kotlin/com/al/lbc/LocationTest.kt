package com.al.lbc

import com.al.lbc.extended.Category
import com.al.lbc.extended.Department
import com.al.lbc.extended.Region
import com.al.lbc.extended.builders.AdType
import com.al.lbc.extended.builders.Gearbox
import com.al.lbc.extended.builders.RealEstateType
import com.al.lbc.extended.builders.request
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse

/**
 * Non-unit test class for request builders
 * @author Alexandre Lombard
 */
@kotlinx.serialization.ImplicitReflectionSerializer
class LocationTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Build the request
            val res =
                request {
                    adType = AdType.OFFER
                    locations = listOf(SearchLocation(Department.TERRITOIRE_DE_BELFORT))
                    ventesImmobilieres {
                        priceRange = SearchRange(60000, 125000)
                        squareRange = SearchRange(60, 120)
                        roomsRange = SearchRange(3, 5)
                        realEstateTypes = listOf(RealEstateType.FLAT)
                    }
                }.post()

            // Parse and print the other results details
            val searchResults = Json.parse<LbcSearchResults>(String(res.content))
            println("Total: ${searchResults.total}")
        }
    }
}
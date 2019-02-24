# LBC JVM API

_This project is not affiliated with, funded, or in any way associated with Leboncoin_

This provides a convenient JVM API to make calls to the API of the site Leboncoin.
It is written in Kotlin to take advantage of the ability to write
type-safe builders. 

Using the API is as easy as this:
    
    // Build the request
    val res =
        request {
            adType = AdType.OFFER
            region = Region.FRANCHE_COMTE
            voitures {
                brand = "Bmw"
                priceRange = SearchRange(10000, 40000)
                gearbox = Gearbox.AUTO
            }
        }.post()

    // Print the results
    println(String(res.content))

    // Parse the results
    val searchResults = Json.parse<LbcSearchResults>(String(res.content))
    println("Total: ${searchResults.total}")
 
 For the moment there is only one request builder (for "voitures"), but any contribution
 is welcome to add other builders.
 
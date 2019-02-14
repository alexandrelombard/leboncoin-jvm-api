package com.al.lbc

import kotlinx.serialization.json.Json

class LbcApiTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val search = LbcSearch(
                Filters(
                    Category("2"),
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

            val jsonSearch = Json.stringify(LbcSearch.serializer(), search)

            val res = khttp.post(
                url = "http://api.leboncoin.fr/finder/search",
                headers = mapOf(
                    Pair("origin",  "https://www.leboncoin.fr"),
                    Pair("api_key",  "ba0c2dad52b3ec"),
                    Pair("content-type",  "text/plain;charset=UTF-8"),
                    Pair("accept",  "*/*"),
                    Pair("referer",  "https://www.leboncoin.fr/annonces/offres/ile_de_france/")),
                data = jsonSearch)

            println("HTTP Status: ${res.statusCode}")
            println(String(res.content))
        }
    }
}
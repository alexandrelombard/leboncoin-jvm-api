package com.al.lbc.extended.builders

import com.al.lbc.SearchRange

/**
 * Elements of a request about the topic "voiture"
 * @author Alexandre Lombard
 */
class VoitureRequest(
    var brand: String? = null,
    var model: String? = null,
    var fuel: String? = null,
    var gearbox: Gearbox? = null,
    var priceRange: SearchRange? = null,
    var yearRange: SearchRange? = null)

enum class Gearbox(val id: String) {
    MANUAL("1"),
    AUTO("2")
}
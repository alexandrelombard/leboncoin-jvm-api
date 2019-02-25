package com.al.lbc.extended.builders

import com.al.lbc.SearchRange

/**
 * Elements of a request about the topic "ventes immobilieres"
 * @author Alexandre Lombard
 */
class VentesImmobilieresRequest(
    var realEstateTypes: List<RealEstateType>? = null,
    var priceRange: SearchRange? = null,
    var roomsRange: SearchRange? = null,
    var squareRange: SearchRange? = null)

enum class RealEstateType(val value: Int) {
    HOUSE(1),
    FLAT(2),
    TERRAIN(3),
    PARKING(4),
    OTHER(5)
}
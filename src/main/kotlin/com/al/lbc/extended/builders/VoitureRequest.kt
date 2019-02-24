package com.al.lbc.extended.builders

import com.al.lbc.SearchRange

class VoitureRequest(
    var brand: String? = null,
    var priceRange: SearchRange? = null,
    var yearRange: SearchRange? = null
)
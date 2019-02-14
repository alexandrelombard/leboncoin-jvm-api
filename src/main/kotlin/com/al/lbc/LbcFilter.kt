package com.al.lbc

enum class LbcFilter(val value: String) {
    ALL("a"),
    PARTICULIER("private"),
    PROFESSIONNELS("pro"),
    UNKNOWN("unknown");

    companion object {
        fun parse(value: String): LbcFilter {
            for(v in LbcFilter.values()) {
                if(v.value == value)
                    return v
            }

            return UNKNOWN
        }
    }
}
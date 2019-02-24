package com.al.lbc.resources

import com.al.lbc.LbcRegion
import com.al.lbc.extended.Region
import kotlinx.serialization.json.Json
import kotlinx.serialization.parseList

/**
 * Object storing the references to the regions
 * @author Alexandre Lombard
 */
@kotlinx.serialization.ImplicitReflectionSerializer
object LbcRegions {

    private val resourceFile = "regions.json"
    /** List of all regions */
    private val regions: List<LbcRegion>
    /** Map linking a channel to the associated region */
    private val regionsMap: Map<String, LbcRegion>

    init {
        val regionsFileContent = javaClass.getResource(resourceFile).readText()

        // Read the resource file
        regions = Json.parseList(regionsFileContent)

        // Process the categories to build a more intelligible map linking the channels to the categories and
        // subcategories
        val localMap = hashMapOf<String, LbcRegion>()
        regions.forEach {
            localMap[it.channel] = it
        }
        regionsMap = localMap
    }

    /**
     * Synthetic accessor for the regions
     * @param channel the channel
     * @return the region
     */
    operator fun get(channel: String): LbcRegion? {
        return regionsMap[channel]
    }

    operator fun get(region: Region): LbcRegion {
        // We assume that if it's an enumerated region, then the value exists
        return regionsMap.getValue(region.channel)
    }
}
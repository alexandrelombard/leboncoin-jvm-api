package com.al.lbc.resources

import com.al.lbc.LbcDepartment
import com.al.lbc.LbcRegion
import com.al.lbc.extended.Region
import kotlinx.serialization.json.Json
import kotlinx.serialization.parseList

/**
 * Object storing the references to the departments
 * @author Alexandre Lombard
 */
@kotlinx.serialization.ImplicitReflectionSerializer
object LbcDepartments {

    private val resourceFile = "departments.json"
    /** List of all departments */
    private val departments: List<LbcDepartment>
    /** Map linking a channel to the associated departments */
    private val departmentsMap: Map<String, LbcDepartment>

    init {
        val departmentsFileContent = javaClass.getResource(resourceFile).readText()

        // Read the resource file
        departments = Json.parseList(departmentsFileContent)

        // Process the categories to build a more intelligible map linking the channels to the categories and
        // subcategories
        val localMap = hashMapOf<String, LbcDepartment>()
        departments.forEach {
            localMap[it.channel] = it
        }
        departmentsMap = localMap
    }

    /**
     * Synthetic accessor for the departments
     * @param channel the channel
     * @return the department
     */
    operator fun get(channel: String): LbcDepartment? {
        return departmentsMap[channel]
    }

    operator fun get(region: Region): LbcDepartment {
        // We assume that if it's an enumerated department, then the value exists
        return departmentsMap.getValue(region.channel)
    }
}
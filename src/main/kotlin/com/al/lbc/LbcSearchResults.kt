package com.al.lbc

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class LbcSearchResults(
    val total: Int,
    @SerialName("total_all")
    val totalAll: Int,
    @SerialName("total_pro")
    val totalPro: Int,
    @SerialName("total_private")
    val totalPrivate: Int,
    @SerialName("total_active")
    val totalActive: Int,
    @SerialName("total_inactive")
    val totalInactive: Int,
    val pivot: String,
    @Optional
    val ads: List<LbcAd> = listOf(),
    @Optional
    @SerialName("ads_alu")
    val adsAlu: List<LbcAd> = listOf()
)

@Serializable
data class LbcAd(
    @SerialName("list_id")
    val listId: Long,
    @SerialName("first_publication_date")
    val firstPublicationDate: String,
    @Optional
    @SerialName("expiration_date")
    val expirationDate: String? = null,
    @SerialName("index_date")
    val indexDate: String,
    val status: String,
    @SerialName("category_id")
    val categoryId: String,
    @SerialName("category_name")
    val categoryName: String,
    val subject: String,
    val body: String,
    @SerialName("ad_type")
    val adType: String,
    val url: String,
    val price: List<Double>,
    @Optional
    @SerialName("price_calendar")
    val priceCalendar: String? = null,
    val images: LbcAdImages,
    val attributes: List<LbcAdAttribute>,
    val location: LbcAdLocation,
    val owner: LbcAdOwner,
    val options: LbcAdOptions,
    @SerialName("has_phone")
    val hasPhone: Boolean

)

@Serializable
data class LbcAdImages(
    @Optional
    @SerialName("thumb_url")
    val thumbUrl: String = "",
    @Optional
    @SerialName("small_url")
    val smallUrl: String = "",
    @SerialName("nb_images")
    val nbImages: Int,
    @Optional
    val urls: List<String> = arrayListOf(),
    @Optional
    @SerialName("urls_thumb")
    val urlsThumb: List<String> = arrayListOf(),
    @Optional
    @SerialName("urls_large")
    val urlsLarge: List<String> = arrayListOf()
)

@Serializable
data class LbcAdAttribute(
    val key: String,
    val value: String,
    @Optional
    @SerialName("key_label")
    val keyLabel: String = "",
    @SerialName("value_label")
    val valueLabel: String,
    val generic: Boolean
)

@Serializable
data class LbcAdLocation(
    @SerialName("region_id")
    val regionId: String,
    @SerialName("region_name")
    val regionName: String,
    @SerialName("department_id")
    val departmentId: String,
    @SerialName("department_name")
    val departmentName: String,
    @SerialName("city_label")
    val cityLabel: String,
    val city: String,
    val zipcode: String,
    val lat: Double,
    val lng: Double,
    val source: String,
    val provider: String,
    @SerialName("is_shape")
    val isShape: Boolean
)

@Serializable
data class LbcAdOwner(
    @Optional
    @SerialName("store_id")
    val storeId: String? = null,
    @SerialName("user_id")
    val userId: String,
    val type: String,
    val name: String,
    @Optional
    val siren: String? = null,
    @SerialName("no_salesmen")
    val noSalesmen: Boolean,
    @Optional
    @SerialName("pro_rates_link")
    val proRatesLink: String = ""
)

@Serializable
data class LbcAdOptions(
    @SerialName("has_option")
    val hasOption: Boolean,
    val booster: Boolean,
    val photosup: Boolean,
    val urgent: Boolean,
    val gallery: Boolean,
    @SerialName("sub_toplist")
    val subToplist: Boolean
)
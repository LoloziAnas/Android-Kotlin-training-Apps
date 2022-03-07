package com.lolozianas.amphibiansapp.network

import com.squareup.moshi.Json

/**
 * This data class defines an Amphibian which includes the amphibian's name, the type of
 * amphibian, and a brief description of the amphibian.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
data class Amphibian(
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String,
    @Json(name = "description") val description: String
)

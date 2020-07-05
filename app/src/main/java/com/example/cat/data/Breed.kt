package com.example.cat.data

import com.squareup.moshi.Json

data class Breed(

    @Json(name = "cat_friendly")
    val catFriendly: Int? = null,

    @Json(name = "suppressed_tail")
    val suppressedTail: Int? = null,

    @Json(name = "wikipedia_url")
    val wikipediaUrl: String? = null,

    @Json(name = "origin")
    val origin: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "experimental")
    val experimental: Int? = null,

    @Json(name = "life_span")
    val lifeSpan: String? = null,

    @Json(name = "cfa_url")
    val cfaUrl: String? = null,

    @Json(name = "rare")
    val rare: Int? = null,

    @Json(name = "country_codes")
    val countryCodes: String? = null,

    @Json(name = "lap")
    val lap: Int? = null,

    @Json(name = "bidability")
    val bidAbility: Int? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "short_legs")
    val shortLegs: Int? = null,

    @Json(name = "shedding_level")
    val sheddingLevel: Int? = null,

    @Json(name = "dog_friendly")
    val dogFriendly: Int? = null,

    @Json(name = "natural")
    val natural: Int? = null,

    @Json(name = "rex")
    val rex: Int? = null,

    @Json(name = "health_issues")
    val healthIssues: Int? = null,

    @Json(name = "hairless")
    val hairless: Int? = null,

    @Json(name = "weight")
    val weight: Weight? = null,

    @Json(name = "adaptability")
    val adaptability: Int? = null,

    @Json(name = "vocalisation")
    val vocalisation: Int? = null,

    @Json(name = "intelligence")
    val intelligence: Int? = null,

    @Json(name = "social_needs")
    val socialNeeds: Int? = null,

    @Json(name = "country_code")
    val countryCode: String? = null,

    @Json(name = "child_friendly")
    val childFriendly: Int? = null,

    @Json(name = "temperament")
    val temperament: String? = null,

    @Json(name = "vcahospitals_url")
    val vcaHospitalsUrl: String? = null,

    @Json(name = "grooming")
    val grooming: Int? = null,

    @Json(name = "hypoallergenic")
    val hypoallergenic: Int? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "vetstreet_url")
    val vetStreetUrl: String? = null,

    @Json(name = "indoor")
    val indoor: Int? = null,

    @Json(name = "energy_level")
    val energyLevel: Int? = null,

    @Json(name = "stranger_friendly")
    val strangerFriendly: Int? = null,

    @Json(name = "affection_level")
    val affectionLevel: Int? = null
)
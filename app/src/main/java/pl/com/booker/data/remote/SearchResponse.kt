package pl.com.booker.data.remote

import com.google.gson.annotations.SerializedName


data class SearchResponse(

	@field:SerializedName("salon_id")
	val salonId: Int? = null,

	@field:SerializedName("nazwa_salonu")
	val nazwaSalonu: String? = null,

	@field:SerializedName("nazwa_firmy")
	val nazwaFirmy: String? = null,

	@field:SerializedName("distance")
	val distance: Double? = null,

	@field:SerializedName("uslugi")
	val uslugi: String? = null,

	@field:SerializedName("photo")
	val photo: Any? = null,

	@field:SerializedName("review_count")
	val reviewCount: Int? = null,

	@field:SerializedName("adres")
	val adres: String? = null,

	@field:SerializedName("review_rating")
	val reviewRating: Int? = null
)
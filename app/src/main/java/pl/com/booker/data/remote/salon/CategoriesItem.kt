package pl.com.booker.data.remote.salon

import com.google.gson.annotations.SerializedName


data class CategoriesItem(

	@field:SerializedName("kategoria")
	val kategoria: String? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("services")
	val services: List<ServicesItem?>? = null
)
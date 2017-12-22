package pl.com.booker.data.remote

import com.google.gson.annotations.SerializedName


data class CategoryResponse(

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("cat_name")
	val catName: String? = null,

	@field:SerializedName("nearby_salons_total")
	val nearbySalonsTotal: Int? = null
)
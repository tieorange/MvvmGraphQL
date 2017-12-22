package pl.com.booker.data.remote.salon

import com.google.gson.annotations.SerializedName


data class FacilitiesItem(

	@field:SerializedName("udogodnienia_id")
	val udogodnieniaId: Int? = null,

	@field:SerializedName("name_pl")
	val namePl: String? = null,

	@field:SerializedName("glyphicon")
	val glyphicon: Any? = null,

	@field:SerializedName("name")
	val name: String? = null
)
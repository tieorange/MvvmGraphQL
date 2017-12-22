package pl.com.booker.data.remote.profile

import com.google.gson.annotations.SerializedName

data class Sexes(

	@field:SerializedName("sex_id")
	val sexId: Int? = null,

	@field:SerializedName("name_lang")
	val nameLang: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)
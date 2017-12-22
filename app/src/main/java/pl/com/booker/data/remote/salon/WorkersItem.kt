package pl.com.booker.data.remote.salon

import com.google.gson.annotations.SerializedName


data class WorkersItem(

	@field:SerializedName("sex_id")
	val sexId: Int? = null,

	@field:SerializedName("img")
	val img: Any? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("profile")
	val profile: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("job_title")
	val jobTitle: String? = null
)
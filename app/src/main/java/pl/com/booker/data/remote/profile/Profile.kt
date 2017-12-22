package pl.com.booker.data.remote.profile

import com.google.gson.annotations.SerializedName

data class Profile(

	@field:SerializedName("sex_id")
	val sexId: Int? = null,

	@field:SerializedName("sexes")
	val sexes: Sexes? = null,

	@field:SerializedName("thumb")
	val thumb: Any? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("surname")
	val surname: String? = null,

	@field:SerializedName("sex")
	val sex: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_picture")
	val profilePicture: Any? = null,

	@field:SerializedName("email")
	val email: String? = null
)
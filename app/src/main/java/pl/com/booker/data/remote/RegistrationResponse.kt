package pl.com.booker.data.remote

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("surname")
	val surname: Any? = null,

	@field:SerializedName("thumb_pic")
	val thumbPic: Any? = null,

	@field:SerializedName("name")
	val name: Any? = null,

	@field:SerializedName("profile_pic")
	val profilePic: Any? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
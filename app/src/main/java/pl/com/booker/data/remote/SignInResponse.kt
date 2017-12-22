package pl.com.booker.data.remote

import com.google.gson.annotations.SerializedName

data class SignInResponse(

	@field:SerializedName("company_id")
	val companyId: String? = null,

	@field:SerializedName("thumb")
	val thumb: Any? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("surname")
	val surname: String? = null,

	@field:SerializedName("company_name")
	val companyName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_picture")
	val profilePicture: Any? = null,

	@field:SerializedName("login_result")
	val loginResult: String? = null,

	@field:SerializedName("lang")
	val lang: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
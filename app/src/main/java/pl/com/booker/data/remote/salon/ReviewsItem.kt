package pl.com.booker.data.remote.salon

import com.google.gson.annotations.SerializedName


data class ReviewsItem(

	@field:SerializedName("review_id")
	val reviewId: Int? = null,

	@field:SerializedName("salon_id")
	val salonId: Int? = null,

	@field:SerializedName("user_id")
	val userId: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("review_rating_id")
	val reviewRatingId: Int? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("accepted")
	val accepted: Int? = null,

	@field:SerializedName("comment")
	val comment: String? = null,

	@field:SerializedName("creation_date")
	val creationDate: String? = null,

	@field:SerializedName("parent_review_id")
	val parentReviewId: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
package pl.com.booker.data.remote.salon

import com.google.gson.annotations.SerializedName

data class SalonResponse(

	@field:SerializedName("tue_from")
	val tueFrom: String? = null,

	@field:SerializedName("kg_salon_stock_photo_name")
	val kgSalonStockPhotoName: Any? = null,

	@field:SerializedName("tue_to")
	val tueTo: String? = null,

	@field:SerializedName("county")
	val county: String? = null,

	@field:SerializedName("review_count")
	val reviewCount: Int? = null,

	@field:SerializedName("thu_from")
	val thuFrom: String? = null,

	@field:SerializedName("instagram")
	val instagram: String? = null,

	@field:SerializedName("twitter")
	val twitter: String? = null,

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("reviews")
	val reviews: List<ReviewsItem?>? = null,

	@field:SerializedName("main_category")
	val mainCategory: Any? = null,

	@field:SerializedName("thu_to")
	val thuTo: String? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null,

	@field:SerializedName("salon_id")
	val salonId: Int? = null,

	@field:SerializedName("kg_salon_stock_photo_path")
	val kgSalonStockPhotoPath: Any? = null,

	@field:SerializedName("sat_from")
	val satFrom: String? = null,

	@field:SerializedName("profile")
	val profile: String? = null,

	@field:SerializedName("kg_salon_stock_photo_storage_dir")
	val kgSalonStockPhotoStorageDir: Any? = null,

	@field:SerializedName("salon_name")
	val salonName: String? = null,

	@field:SerializedName("mon_from")
	val monFrom: String? = null,

	@field:SerializedName("sun_to")
	val sunTo: Any? = null,

	@field:SerializedName("unit")
	val unit: Any? = null,

	@field:SerializedName("kg_salon_stock_photo_type")
	val kgSalonStockPhotoType: Any? = null,

	@field:SerializedName("company_name")
	val companyName: String? = null,

	@field:SerializedName("sun_from")
	val sunFrom: String? = null,

	@field:SerializedName("sat_to")
	val satTo: String? = null,

	@field:SerializedName("youtube")
	val youtube: String? = null,

	@field:SerializedName("mon_to")
	val monTo: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("voivodenship")
	val voivodenship: String? = null,

	@field:SerializedName("kg_salon_stock_photo_sha1_name")
	val kgSalonStockPhotoSha1Name: Any? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("wed_to")
	val wedTo: String? = null,

	@field:SerializedName("linkedin")
	val linkedin: String? = null,

	@field:SerializedName("is_favourite")
	val isFavourite: Int? = null,

	@field:SerializedName("review_rating")
	val reviewRating: Double? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("google_address")
	val googleAddress: String? = null,

	@field:SerializedName("fri_to")
	val friTo: String? = null,

	@field:SerializedName("fri_from")
	val friFrom: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@field:SerializedName("workers")
	val workers: List<WorkersItem?>? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("wed_from")
	val wedFrom: String? = null,

	@field:SerializedName("company_id")
	val companyId: Int? = null,

	@field:SerializedName("facebook")
	val facebook: String? = null,

	@field:SerializedName("uslugi")
	val uslugi: String? = null,

	@field:SerializedName("telefon_1")
	val telefon1: Int? = null,

	@field:SerializedName("telefon_2")
	val telefon2: Int? = null,

	@field:SerializedName("google_plus")
	val googlePlus: String? = null,

	@field:SerializedName("telefon_3")
	val telefon3: Int? = null,

	@field:SerializedName("kg_salon_stock_photo_size")
	val kgSalonStockPhotoSize: Any? = null,

	@field:SerializedName("postal_code")
	val postalCode: String? = null,

	@field:SerializedName("facilities")
	val facilities: List<FacilitiesItem?>? = null
)
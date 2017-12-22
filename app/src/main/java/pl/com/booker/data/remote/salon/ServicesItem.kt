package pl.com.booker.data.remote.salon

import com.google.gson.annotations.SerializedName


data class ServicesItem(

	@field:SerializedName("service_category_id")
	val serviceCategoryId: Int? = null,

	@field:SerializedName("service_name_en")
	val serviceNameEn: Any? = null,

	@field:SerializedName("salon_id")
	val salonId: Int? = null,

	@field:SerializedName("service_name_pl")
	val serviceNamePl: String? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("service_id")
	val serviceId: Int? = null,

	@field:SerializedName("time")
	val time: Int? = null
)
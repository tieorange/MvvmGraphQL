package pl.com.booker.util

import android.content.Context

class GoogleMapHelper(
//        private val googleMap: GoogleMap,
        private val context: Context
) {

   /* fun addMarkersFromOrder(orderEntity: OrderEntity) {
        val loadingMarkers = addMarkersAndReturnList(orderEntity.loadingPlaces)
        val unloadingMarkers = addMarkersAndReturnList(ArrayList(orderEntity.unloadingPlaces))

        val combinedMarkers = ArrayList<DeliveryLocation>()
        combinedMarkers.addAll(loadingMarkers)
        combinedMarkers.addAll(unloadingMarkers)

        googleMap.zoomToBounds(combinedMarkers, context)
        googleMap.uiSettings.isMyLocationButtonEnabled = true
    }

    private fun addMarkersAndReturnList(loadingPlaces: List<LoadingPlacesItem>): List<DeliveryLocation> {
        val deliveryLocations = loadingPlaces.map {
            val latLng = LatLng(
                    it.address?.coordinates?.lat ?: 0.0,
                    it.address?.coordinates?.lng ?: 0.0
            )
            DeliveryLocation(latLng, it.address?.name ?: "")
        }

        addMarkersToGoogleMap(deliveryLocations, BitmapDescriptorFactory.HUE_ORANGE)

        return deliveryLocations
    }

    private fun addMarkersAndReturnList(unloadingPlaces: ArrayList<UnloadingPlacesItem>): List<DeliveryLocation> {
        val deliveryLocations = unloadingPlaces.map {
            val latLng = LatLng(
                    it.address.coordinates?.lat ?: 0.0,
                    it.address.coordinates?.lng ?: 0.0
            )
            DeliveryLocation(latLng, it.address.name ?: "")
        }

        addMarkersToGoogleMap(deliveryLocations, BitmapDescriptorFactory.HUE_GREEN)

        return deliveryLocations
    }

    private fun addMarkersToGoogleMap(
            deliveryLocations: List<DeliveryLocation>,
            markerColor: Float
    ) {
        deliveryLocations.forEach {
            googleMap.addMarker(
                    MarkerOptions()
                            .position(it.latLng)
                            .title(it.name)
                            .icon(
                                    BitmapDescriptorFactory.defaultMarker(
                                            markerColor
                                    )
                            )
            )
        }
    }*/
}
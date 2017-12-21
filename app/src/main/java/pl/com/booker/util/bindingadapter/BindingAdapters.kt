package pl.com.booker.util.bindingadapter

import android.databinding.BindingAdapter
import android.databinding.ObservableInt
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewAnimator
import pl.com.booker.R
import java.text.SimpleDateFormat
import java.util.*


object BindingAdapters {

    @BindingAdapter("android:visibility")
    @JvmStatic
    fun setVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @BindingAdapter("android:layout_marginBottom")
    @JvmStatic
    fun setLayoutMarginBottom(v: View, bottomMargin: Int) {
        val layoutParams = v.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.bottomMargin = bottomMargin
    }

    @BindingAdapter("app:percentage_text_from_number")
    @JvmStatic
    fun setSectionText(view: TextView, value: Number) {
        view.text = "${value.toInt()}%"
    }

/*
    @BindingAdapter("app:latLng")
    @JvmStatic
    fun bindLocationToMap(mapView: MapView, latLong: LatLng) {
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLong, 10f)
        mapView.getMapAsync { it.moveCamera(cameraUpdate) }
    }
*/

    @BindingAdapter("app:dateToString")
    @JvmStatic
    fun bindDateToTextView(view: TextView, date: Date?) {
        if (date == null) {
            view.visibility = GONE
            return
        }

        val formatter = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        view.text = formatter.format(date)
    }

    @BindingAdapter("app:timeToString")
    @JvmStatic
    fun bindTimeToString(view: TextView, date: Date?) {
        if (date == null) {
            view.visibility = GONE
            return
        }

        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        view.text = formatter.format(date)
    }

    @BindingAdapter("app:dateTimeToString")
    @JvmStatic
    fun bindDateTimeToString(view: TextView, date: Date?) {
        if (date == null) {
            view.visibility = GONE
            return
        }

        val formatter = SimpleDateFormat("dd.MM.yy HH:mm", Locale.getDefault())
        view.text = formatter.format(date)
    }

    @BindingAdapter("app:priceFloat")
    @JvmStatic
    fun bindPriceFloatToTextView(view: TextView, price: Float?) {
        if (price == null) {
            view.visibility = GONE
            return
        }

        val stringFormat = getString(view, R.string.pricePlnFormat)
        view.text = String.format(stringFormat, price)
    }

    @BindingAdapter("app:priceInt")
    @JvmStatic
    fun bindPriceFloatToTextView(view: TextView, price: Int?) {
        if (price == null) {
            view.visibility = GONE
            return
        }
        val stringFormat = getString(view, R.string.pricePlnFormat)
        view.text = String.format(stringFormat, price.toFloat())
    }


    @BindingAdapter("bind:displayChild")
    @JvmStatic
    fun bindSeekBarMaxValue(view: ViewAnimator, pageNumber: ObservableInt) {
        view.displayedChild = pageNumber.get()
    }

    @BindingAdapter("app:srcCompat")
    @JvmStatic
    fun bindSrcCompat(imageView: ImageView, drawable: Drawable) {
        imageView.setImageDrawable(drawable)
    }

    @BindingAdapter("app:yesOrNo")
    @JvmStatic
    fun bindYesOrNo(textView: TextView, isYes: Boolean) {
        textView.text = if (isYes) getString(textView, R.string.yes)
        else getString(textView, R.string.no)
    }

    /*@BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, imageUrl: String?) {
        if (imageUrl == null) return
        Glide.with(imageView.context)
                .load(imageUrl)
                .placeholder(R.drawable.dummy_avatar)
                .error(R.drawable.dummy_avatar)
                .into(imageView)
    }*/

    @JvmStatic
    fun getString(view: View, @StringRes stringRes: Int): String {
        return view.context.getString(stringRes)
    }

    @BindingAdapter("app:imageBitmap")
    @JvmStatic
    fun loadImage(iv: ImageView, bitmap: Bitmap) {
        iv.setImageBitmap(bitmap)
    }
}

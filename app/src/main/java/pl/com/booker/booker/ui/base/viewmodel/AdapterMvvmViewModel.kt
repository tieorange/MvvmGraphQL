package pl.com.booker.booker.ui.base.viewmodel

import android.support.v7.widget.RecyclerView

import pl.com.booker.booker.ui.base.view.MvvmView


interface AdapterMvvmViewModel<V : MvvmView> : MvvmViewModel<V> {

    val adapter: RecyclerView.Adapter<*>
}

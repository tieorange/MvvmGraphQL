package pl.com.booker.ui.base.viewmodel

import android.databinding.BaseObservable
import android.os.Bundle
import android.support.annotation.CallSuper
import pl.com.booker.ui.base.MvvmViewNotAttachedException
import pl.com.booker.ui.base.view.MvvmView


/**
 * Base class that implements the ViewModel interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvvmView that
 * can be accessed from the children classes by calling getMvpView().

 * When saving state is required, restoring is handled automatically when calling attachView().
 * However, saveInstanceState() must still be called in the corresponding lifecycle callback.

 * ------

 * FILE MODIFIED 2017 Tailored Media GmbH
 */
abstract class BaseViewModel<V : MvvmView> : BaseObservable(), MvvmViewModel<V> {

    var view: V? = null
        private set

    @CallSuper
    override fun attachView(view: V, savedInstanceState: Bundle?) {
        this.view = view
        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState)
        }
    }

    @CallSuper
    override fun detachView() {
        view = null
    }

    protected open fun restoreInstanceState(savedInstanceState: Bundle) {}

    override fun saveInstanceState(outState: Bundle?) {}

    val isViewAttached: Boolean
        get() = view != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvvmViewNotAttachedException()
    }
}

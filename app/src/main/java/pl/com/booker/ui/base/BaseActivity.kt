package pl.com.booker.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IntegerRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import pl.com.booker.BR
import pl.com.booker.MyApp
import pl.com.booker.injection.components.ActivityComponent
import pl.com.booker.injection.components.DaggerActivityComponent
import pl.com.booker.injection.modules.ActivityModule
import pl.com.booker.ui.base.view.MvvmView
import pl.com.booker.ui.base.viewmodel.MvvmViewModel
import pl.com.booker.ui.base.viewmodel.NoOpViewModel
import javax.inject.Inject

/* Base class for Activities when using a view model with data binding.
 * This class provides the binding and the view model to the subclass. The
 * view model is injected and the binding is created when the content view is set.
 * Each subclass therefore has to call the following code in onCreate():
 *    activityComponent().inject(this);
 *    setAndBindContentView(R.layout.my_activity_layout, savedInstanceState);
 *
 * After calling these methods, the binding and the view model is initialized.
 * saveInstanceState() and restoreInstanceState() methods of the view model
 * are automatically called in the appropriate lifecycle events when above calls
 * are made.
 *
 * Your subclass must implement the MvvmView implementation that you use in your
 * view model. */
abstract class BaseActivity<B : ViewDataBinding, V : MvvmView, VM : MvvmViewModel<V>> : AppCompatActivity() {

    protected lateinit var binding: B
    @Inject protected lateinit var viewModel: VM

    internal lateinit var activityComponent: ActivityComponent
        private set

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .appComponent(MyApp.appComponent)
                .build()

        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        viewModel.detachView()
    }

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected fun setAndBindContentView(savedInstanceState: Bundle?, @LayoutRes layoutResID: Int) {
        binding = DataBindingUtil.setContentView<B>(this, layoutResID)
        binding.setVariable(BR.vm, viewModel)

        try {
            @Suppress("UNCHECKED_CAST")
            viewModel.attachView(this as V, savedInstanceState)
        } catch (e: ClassCastException) {
            if (viewModel !is NoOpViewModel<*>) {
                throw RuntimeException(javaClass.simpleName + " must implement MvvmView subclass as declared in " + viewModel.javaClass.simpleName)
            }
        }

    }

    fun dimen(@DimenRes resId: Int): Int {
        return resources.getDimension(resId).toInt()
    }

    fun color(@ColorRes resId: Int): Int {
        return ContextCompat.getColor(this, resId)
    }

    fun integer(@IntegerRes resId: Int): Int {
        return resources.getInteger(resId)
    }

    fun string(@StringRes resId: Int): String {
        return resources.getString(resId)
    }

}

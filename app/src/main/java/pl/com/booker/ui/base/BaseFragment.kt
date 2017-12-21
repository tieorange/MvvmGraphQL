package pl.com.booker.ui.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IntegerRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.com.booker.BR
import pl.com.booker.injection.components.DaggerFragmentComponent
import pl.com.booker.injection.components.FragmentComponent
import pl.com.booker.injection.modules.FragmentModule
import pl.com.booker.ui.base.view.MvvmView
import pl.com.booker.ui.base.viewmodel.MvvmViewModel
import pl.com.booker.ui.base.viewmodel.NoOpViewModel
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding, V : MvvmView, VM : MvvmViewModel<V>> : Fragment() {

    protected lateinit var binding: B
    @Inject protected lateinit var viewModel: VM

    protected lateinit var fragmentComponent: FragmentComponent
        private set

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveInstanceState(outState)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.detachView()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onAttach(context: Context?) {
        fragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(this))
                .activityComponent((activity as BaseActivity<*, *, *>).activityComponent)
                .build()

        super.onAttach(context)
    }

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected fun setAndBindContentView(
            inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?,
            @LayoutRes layoutResID: Int
    ): View {
        binding = DataBindingUtil.inflate<B>(inflater, layoutResID, container, false)
        binding.setVariable(BR.vm, viewModel)

        try {
            @Suppress("UNCHECKED_CAST")
            viewModel.attachView(this as V, savedInstanceState)
        } catch (e: ClassCastException) {
            if (viewModel !is NoOpViewModel<*>) {
                throw RuntimeException(javaClass.simpleName + " must implement MvvmView subclass as declared in " + viewModel.javaClass.simpleName)
            }
        }

        return binding.root
    }

    fun dimen(@DimenRes resId: Int): Int {
        return resources.getDimension(resId).toInt()
    }

    fun color(@ColorRes resId: Int): Int {
        return resources.getColor(resId)
    }

    fun integer(@IntegerRes resId: Int): Int {
        return resources.getInteger(resId)
    }

    fun string(@StringRes resId: Int): String {
        return resources.getString(resId)
    }
}

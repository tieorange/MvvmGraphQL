package pl.com.booker.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import pl.com.booker.BR
import pl.com.booker.injection.components.DaggerViewHolderComponent
import pl.com.booker.injection.components.ViewHolderComponent
import pl.com.booker.ui.base.view.MvvmView
import pl.com.booker.ui.base.viewmodel.MvvmViewModel
import pl.com.booker.ui.base.viewmodel.NoOpViewModel
import pl.com.booker.util.castWithUnwrap
import javax.inject.Inject

/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ------
 *
 * FILE MODIFIED 2017 Tailored Media GmbH
 */

/* Base class for ViewHolders when using a view model with data binding.
 * This class provides the binding and the view model to the subclass. The
 * view model is injected and the binding is created when the content view is bound.
 * Each subclass therefore has to call the following code in the constructor:
 *    getViewHolderComponent().inject(this);
 *    bindContentView(view);
 *
 * After calling these methods, the binding and the view model is initialized.
 * saveInstanceState() and restoreInstanceState() are not called/used for ViewHolder
 * view models.
 *
 * Your subclass must implement the MvvmView implementation that you use in your
 * view model. */
abstract class BaseViewHolder<B : ViewDataBinding, V : MvvmView, VM : MvvmViewModel<V>>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected lateinit var binding: B
    @Inject lateinit var viewModel: VM
        protected set

    protected val viewHolderComponent: ViewHolderComponent = DaggerViewHolderComponent.builder()
            .activityComponent(itemView.context.castWithUnwrap<BaseActivity<*,*,*>>()?.activityComponent)
            .build()

    protected fun bindContentView(view: View) {
        binding = DataBindingUtil.bind(view)
        binding.setVariable(BR.vm, viewModel)

        try {
            @Suppress("UNCHECKED_CAST")
            viewModel.attachView(this as V, null)
        } catch (e: ClassCastException) {
            if (viewModel !is NoOpViewModel<*>) {
                throw RuntimeException(javaClass.simpleName + " must implement MvvmView subclass as declared in " + viewModel.javaClass.simpleName)
            }
        }

    }

    fun executePendingBindings() {
        binding.executePendingBindings()
    }
}

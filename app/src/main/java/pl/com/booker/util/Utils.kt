package pl.com.booker.util

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/* Copyright 2017 Tailored Media GmbH
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
 * -----------------
 *
 * FILE MODIFIED 2017 Patrick Löwenstein */

object Utils {

    fun <T : RecyclerView.ViewHolder> createViewHolder(viewGroup: ViewGroup, @LayoutRes layoutResId: Int, newViewHolderAction: (View) -> T): T {
        val view = LayoutInflater.from(viewGroup.context).inflate(layoutResId, viewGroup, false)
        return newViewHolderAction(view)
    }

}

fun <T : Parcelable> Bundle.getParcelable(key: String, defaultObject: T) : T {
    if (containsKey(key)) {
        return getParcelable(key)
    } else {
        return defaultObject
    }
}

inline fun <reified T> Context.castWithUnwrap(): T? {
    if (this is T) { return this }
    var context = this
    while(context is ContextWrapper) {
        context = context.baseContext
        if(context is T) {  return context }
    }
    return null
}


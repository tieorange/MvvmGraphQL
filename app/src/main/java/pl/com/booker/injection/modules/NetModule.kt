package pl.com.booker.ui.base.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.momedia.cargo.BuildConfig
import com.momedia.cargo.MyApp
import com.momedia.cargo.data.remote.MyApi
import pl.com.booker.ui.base.qualifier.AppContext
import pl.com.booker.ui.base.scopes.PerApplication
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.*

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
 * */
@Module
class NetModule(@AppContext private val context: Context) {

    @Provides
    @PerApplication
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @PerApplication
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(context))
                .build()
    }

    @Provides
    @PerApplication
    internal fun provideMyApi(gson: Gson, okHttpClient: OkHttpClient): MyApi {
        val httpClientBuilder = okHttpClient.newBuilder().connectTimeout(20, MINUTES)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
                .baseUrl(MyApp.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .callFactory(httpClientBuilder.build())
                .build().create(MyApi::class.java)
    }
}

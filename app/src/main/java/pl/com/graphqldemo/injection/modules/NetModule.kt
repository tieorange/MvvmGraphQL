package pl.com.graphqldemo.injection.modules

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.http.ApolloHttpCache
import com.apollographql.apollo.cache.http.DiskLruHttpCacheStore
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.com.booker.BuildConfig
import pl.com.booker.injection.qualifier.AppContext
import pl.com.booker.injection.scopes.PerApplication
import pl.com.graphqldemo.data.GraphQlClient
import java.io.File

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
        val builder = OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(context))

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @Provides
    @PerApplication
    internal fun provideApollo(okHttpClient: OkHttpClient): ApolloClient {


        //Directory where cached responses will be stored
        val file = File("/cache/")

        //Size in bytes of the cache
        val size = 1024 * 1024L

        //Create the http response cache store
        val cacheStore = DiskLruHttpCacheStore(file, size)

        //Build the Apollo Client
        return ApolloClient.builder()
                .serverUrl(BASE_URL)
                .httpCache(ApolloHttpCache(cacheStore))
                .okHttpClient(okHttpClient)
                .build()
    }
    @Provides
    @PerApplication
    internal fun provideGraphQlClient(apolloClient: ApolloClient): GraphQlClient {
       return GraphQlClient(apolloClient)
    }

    companion object {
        val BASE_URL = "https://api.graph.cool/simple/v1/cjdjyomln2cqh0165r55pm2na"
    }
}

package datalayer.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Zahar on 17.04.16.
 */
class VkRest {

    val client:OkHttpClient;

    init {
        val builder = OkHttpClient.Builder()

//        if(Settings.RETROFIT_LOGS) {
//            val logging = HttpLoggingInterceptor();
//            logging.level = HttpLoggingInterceptor.Level.BODY;
//            builder.addInterceptor(logging)
//        }

        client = builder.build();
    }

    fun getRest(): VkRestApi {

        val restAdapter = Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.vk.com/method/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return restAdapter.create(VkRestApi::class.java)
    }
}

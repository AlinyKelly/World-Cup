package br.com.alinykelly.worldcup.model

import br.com.alinykelly.worldcup.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Nome anterior JogadorRepository
object NetworkModule {
    //private val service: JogadorService

    inline fun <reified T> createNetworkService(): T {
        //log
        val log = HttpLoggingInterceptor()
        log.level = HttpLoggingInterceptor.Level.BODY

        //Client
        val client = OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val originalUrl = originalRequest.url
                val newUrl = originalUrl.newBuilder()
                    .addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()

                val newRequest = originalRequest.newBuilder().url(newUrl).build()

                chain.proceed(
                    newRequest.newBuilder()
                        .addHeader(
                            "Content-Type",
                            "application/json"
                        ) //Interceptador para colocar o content type
                        .build()
                )
            }
            .addInterceptor(log) //Interceptador para logar
            .build()

        //Retrofit Builder
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        //Criacao do Service
        return retrofit.create(T::class.java)

    }
//
//    //https://pokeapi.co/api/v2/pokemon/?limit=151
//    init {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://v3.football.api-sports.io/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        service = retrofit.create(JogadorService::class.java)
//    }
//
//    fun listJogadores(limit: Int = 151): JogadoresApiResult? {
//        val call = service.listJogadores(limit)
//
//        return call.execute().body()
//
//    }
//
//    fun getJogador(number: Int): JogadorApiResult? {
//        val call = service.getJogador(number)
//
//        return call.execute().body()
//    }

}
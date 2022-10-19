package br.com.alinykelly.worldcup.api.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JogadorService {
    @GET("jogador")
    fun listJogadores(@Query("limit") limit: Int): Call<JogadoresApiResult>

    @GET("jogador/{number}")
    fun getJogador(@Path("number") number: Int): Call<JogadorApiResult>

}
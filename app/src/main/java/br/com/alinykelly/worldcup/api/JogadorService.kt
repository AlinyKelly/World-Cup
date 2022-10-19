package br.com.alinykelly.worldcup.api

import br.com.alinykelly.worldcup.api.model.JogadorApiResult
import br.com.alinykelly.worldcup.api.model.JogadoresApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JogadorService {
    @GET("jogador") // retorna quantidade de jogadores por pagina
    fun listJogadores(@Query("limit") limit: Int): Call<JogadoresApiResult>

    @GET("jogador/{number}") //inserir a parte do jogador com o numero
    fun getJogador(@Path("number") number: Int): Call<JogadorApiResult>

}
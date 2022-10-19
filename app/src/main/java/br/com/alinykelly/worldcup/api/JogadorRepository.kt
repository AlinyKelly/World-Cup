package br.com.alinykelly.worldcup.api


import br.com.alinykelly.worldcup.api.model.JogadorApiResult
import br.com.alinykelly.worldcup.api.model.JogadorService
import br.com.alinykelly.worldcup.api.model.JogadoresApiResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JogadorRepository {
    private val service: JogadorService

    //https://pokeapi.co/api/v2/pokemon/?limit=151
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    service = retrofit.create(JogadorService::class.java)
    }

    fun listJogadores(limit: Int = 151): JogadoresApiResult? {
        val call = service.listJogadores(limit)

        return call.execute().body()

    }

    fun getJogador(number: Int): JogadorApiResult? {
        val call = service.getJogador(number)

        return call.execute().body()
    }

}
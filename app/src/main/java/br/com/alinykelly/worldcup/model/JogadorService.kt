package br.com.alinykelly.worldcup.model

import retrofit2.http.GET

interface JogadorService {
    //Response | GET : https://v3.football.api-sports.io/players?league=34&season=2022&team=6

//    @GET("players?league={league}&season={season}&team={team}") // retorna quantidade de jogadores por pagina
//    fun listJogadores(@Path("league") league: Int,
//                      @Path("season") season: Int,
//                      @Path("team") team: Int): Call<JogadoresApiResult>

    @GET("players?league=34&season=2022&team=6")
    suspend fun getJogadores(): JogadoresResponse
}
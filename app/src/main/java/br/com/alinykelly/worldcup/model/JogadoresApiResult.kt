package br.com.alinykelly.worldcup.model

import br.com.alinykelly.worldcup.domain.Parameters
import br.com.alinykelly.worldcup.domain.Response

//Listagem de todos os jogadores
data class JogadoresApiResult (
    val parameters: List<Parameters>,
    val response: List<Response>
    )

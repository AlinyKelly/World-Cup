package br.com.alinykelly.worldcup.api.model

import br.com.alinykelly.worldcup.domain.JogadorType

//Listagem de todos os jogadores
data class JogadoresApiResult (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<JogadorResult>
        )

data class JogadorResult(
    val name: String,
    val url: String
)

//Resultado para apenas 1 jogador
data class JogadorApiResult(
    val id: Int,
    val name: String,
    val types: JogadorTypeSlot
)

data class JogadorTypeSlot(
    val slot: Int,
    val type: JogadorType
)
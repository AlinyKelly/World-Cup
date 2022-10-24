package br.com.alinykelly.worldcup.model

data class PlayerDto (
    val id: Int,
    val name: String,
    val age: Int,
    val photo: String // "https://media.api-sports.io/football/players/${id}.png"
    )
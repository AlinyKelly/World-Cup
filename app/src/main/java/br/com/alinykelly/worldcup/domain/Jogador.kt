package br.com.alinykelly.worldcup.domain

data class Jogador (
    val number: Int,
    val name: String,
    val types: List<JogadorType>
    ) {
    val formattedName = name.capitalize()
    val formattedNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}


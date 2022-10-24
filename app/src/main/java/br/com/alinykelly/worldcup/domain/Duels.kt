package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Duels (

	@SerializedName("total") val total : String,
	@SerializedName("won") val won : String
)
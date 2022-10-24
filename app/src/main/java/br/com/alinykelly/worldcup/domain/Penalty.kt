package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Penalty (

	@SerializedName("won") val won : String,
	@SerializedName("commited") val commited : String,
	@SerializedName("scored") val scored : Int,
	@SerializedName("missed") val missed : Int,
	@SerializedName("saved") val saved : String
)
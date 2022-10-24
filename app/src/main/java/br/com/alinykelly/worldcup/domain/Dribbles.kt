package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Dribbles (

	@SerializedName("attempts") val attempts : String,
	@SerializedName("success") val success : String,
	@SerializedName("past") val past : String
)
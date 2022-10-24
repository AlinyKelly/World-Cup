package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Birth (

	@SerializedName("date") val date : String,
	@SerializedName("place") val place : String,
	@SerializedName("country") val country : String
)
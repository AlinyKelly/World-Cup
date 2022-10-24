package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Goals (

	@SerializedName("total") val total : Int,
	@SerializedName("conceded") val conceded : Int,
	@SerializedName("assists") val assists : String,
	@SerializedName("saves") val saves : String
)
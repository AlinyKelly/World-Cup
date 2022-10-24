package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Fouls (

	@SerializedName("drawn") val drawn : String,
	@SerializedName("committed") val committed : String
)
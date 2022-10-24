package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Tackles (

	@SerializedName("total") val total : String,
	@SerializedName("blocks") val blocks : String,
	@SerializedName("interceptions") val interceptions : String
)
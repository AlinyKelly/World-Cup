package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Passes (

	@SerializedName("total") val total : String,
	@SerializedName("key") val key : String,
	@SerializedName("accuracy") val accuracy : String
)
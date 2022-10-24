package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Shots (

	@SerializedName("total") val total : String,
	@SerializedName("on") val on : String
)
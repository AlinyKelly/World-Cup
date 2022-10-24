package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Substitutes (

	@SerializedName("in") val entrada : Int,
	@SerializedName("out") val out : Int,
	@SerializedName("bench") val bench : Int
)
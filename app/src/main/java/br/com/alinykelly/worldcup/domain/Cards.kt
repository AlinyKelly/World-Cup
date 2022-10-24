package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Cards (

	@SerializedName("yellow") val yellow : Int,
	@SerializedName("yellowred") val yellowred : Int,
	@SerializedName("red") val red : Int
)
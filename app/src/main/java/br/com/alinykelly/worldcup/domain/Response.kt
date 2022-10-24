package br.com.alinykelly.worldcup.domain

import br.com.alinykelly.worldcup.model.PlayerDto
import com.google.gson.annotations.SerializedName

data class Response (

    @SerializedName("player") val playerDto : PlayerDto,
    @SerializedName("statistics") val statistics : List<Statistics>
)
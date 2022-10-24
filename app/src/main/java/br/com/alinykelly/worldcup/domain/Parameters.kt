package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

class Parameters (
    @SerializedName("league") val league : Int,
    @SerializedName("season") val season : Int,
    @SerializedName("team") val team : Int
)

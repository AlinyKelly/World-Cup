package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

data class Statistics (

    @SerializedName("team") val team : Team,
    @SerializedName("league") val league : League,
    @SerializedName("games") val games : Games,
    @SerializedName("substitutes") val substitutes : Substitutes,
    @SerializedName("shots") val shots : Shots,
    @SerializedName("goals") val goals : Goals,
    @SerializedName("passes") val passes : Passes,
    @SerializedName("tackles") val tackles : Tackles,
    @SerializedName("duels") val duels : Duels,
    @SerializedName("dribbles") val dribbles : Dribbles,
    @SerializedName("fouls") val fouls : Fouls,
    @SerializedName("cards") val cards : Cards,
    @SerializedName("penalty") val penalty : Penalty
)
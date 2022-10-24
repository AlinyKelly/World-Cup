package br.com.alinykelly.worldcup.domain

import com.google.gson.annotations.SerializedName

class JsonBase (
    @SerializedName("get") val get : String,
    @SerializedName("parameters") val parameters : Parameters,
    @SerializedName("errors") val errors : List<String>,
    @SerializedName("results") val results : Int,
    @SerializedName("paging") val paging : Paging,
    @SerializedName("response") val response : List<Response>
)
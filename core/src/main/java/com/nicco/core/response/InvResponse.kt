package com.nicco.core.response

data class InvResponse (
    val uid: String? = "",
    val responseCode: String? = "",
    val data: List<InvData> = listOf(),
    val status: String? = ""
)

data class InvData (
    val uid: String? = "",
    val status: String? = "",
    val hashCode: String? = "",
    val title: String? = "",
    val description: String? = "",
    val price: Float? = 0.0F,
    val percent: Float? = 0.0F
)
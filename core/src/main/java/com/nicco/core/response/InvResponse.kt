package com.nicco.core.response

data class InvResponse (
    val uid: String,
    val responseCode: String,
    val data: List<InvData>,
    val status: String
)

data class InvData (
    val uid: String,
    val status: String,
    val hashCode: String,
    val title: String,
    val description: String,
    val price: Float,
    val percent: Float
)
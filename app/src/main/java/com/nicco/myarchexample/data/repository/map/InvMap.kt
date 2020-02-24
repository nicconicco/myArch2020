package com.nicco.myarchexample.data.repository.map

import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.presentation.model.InvModel

object InvMap {
    fun mapFrom(response: InvResponse): List<InvModel> = response.data.map {
        InvModel(
            title = it.title,
            description = it.description,
            price = it.price,
            percent = it.percent
        )
    }
}
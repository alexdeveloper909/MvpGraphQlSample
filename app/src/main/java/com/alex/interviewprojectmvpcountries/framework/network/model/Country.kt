package com.alex.interviewprojectmvpcountries.framework.network.model

data class Country(
    val name:String,
    val native:String,
    val phone:String,
    val capital:String?,
    val currency:String?,
    val emojiU:String
)
package com.alex.interviewprojectmvpcountries.ui.continents

import com.alex.interviewprojectmvpcountries.framework.network.model.Continent
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface ContinentsView : MvpView {

    @Skip
    fun showProgressBar()

    @Skip
    fun hideProgressBar()

    @Skip
    fun showToast(message:String)

    @SingleState
    fun addAllContinents(continents:List<Continent>)
}
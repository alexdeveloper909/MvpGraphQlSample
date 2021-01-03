package com.alex.interviewprojectmvpcountries.ui.details

import com.alex.interviewprojectmvpcountries.framework.network.model.Continent
import com.alex.interviewprojectmvpcountries.framework.network.model.Country
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface DetailsView : MvpView{
    @Skip
    fun showProgressBar()

    @Skip
    fun hideProgressBar()

    @Skip
    fun showToast(message:String)

    @SingleState
    fun addAllCountries(countries:List<Country>)
}
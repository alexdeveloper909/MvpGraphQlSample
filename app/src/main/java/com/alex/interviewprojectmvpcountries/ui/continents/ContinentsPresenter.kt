package com.alex.interviewprojectmvpcountries.ui.continents

import com.alex.interviewprojectmvpcountries.framework.network.Status
import com.alex.interviewprojectmvpcountries.framework.repository.ApiRepository
import com.alex.interviewprojectmvpcountries.framework.repository.LocationsRepository
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class ContinentsPresenter @Inject constructor(
    private val locationsRepository: LocationsRepository,
    private val apiRepository: ApiRepository
) : MvpPresenter<ContinentsView>()  {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            val list = apiRepository.fetchContinents()
            viewState.showProgressBar()
            when(list.status){
                Status.ERROR -> {
                    viewState.hideProgressBar()
                    viewState.showToast("Something went wrong...")
                }
                Status.SUCCESS -> {
                    viewState.hideProgressBar()
                    viewState.addAllContinents(list.data!!)
                }
            }
        }
    }


    fun onContinentSelected(code:String){
        locationsRepository.setId(code)
    }
}
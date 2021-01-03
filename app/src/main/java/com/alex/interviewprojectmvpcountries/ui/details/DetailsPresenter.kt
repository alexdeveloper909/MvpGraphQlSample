package com.alex.interviewprojectmvpcountries.ui.details

import com.alex.interviewprojectmvpcountries.framework.network.Status
import com.alex.interviewprojectmvpcountries.framework.repository.ApiRepository
import com.alex.interviewprojectmvpcountries.framework.repository.IdChangeCallback
import com.alex.interviewprojectmvpcountries.framework.repository.LocationsRepository
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
        private val apiRepository: ApiRepository,
        private val locationsRepository:LocationsRepository
) : MvpPresenter<DetailsView>() {

    private val onIdChangedCallback = object : IdChangeCallback {
        override fun onIdChanged(id: String) {
            presenterScope.launch {
                viewState.showProgressBar()
                val list = apiRepository.fetchCountries(id)
                when(list.status){
                    Status.ERROR -> {
                        viewState.hideProgressBar()
                        viewState.showToast("Something went wrong")
                    }
                    Status.SUCCESS -> {
                        viewState.hideProgressBar()
                        viewState.addAllCountries(list.data!!)
                    }
                }
            }
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        locationsRepository.subscribeCallback(onIdChangedCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        locationsRepository.unsubscribeCallback()
    }
}
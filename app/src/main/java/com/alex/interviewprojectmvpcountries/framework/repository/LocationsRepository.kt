package com.alex.interviewprojectmvpcountries.framework.repository

object LocationsRepository  {

    private var idChangeCallback:IdChangeCallback?=null

    fun subscribeCallback(idChangeCallback: IdChangeCallback){
        this.idChangeCallback = idChangeCallback
    }

    fun unsubscribeCallback(){
        this.idChangeCallback = null
    }

    fun setId(str:String){
        idChangeCallback?.onIdChanged(str)
    }

    //suspend fun getContinents() = apiRepository.fetchCountries()

}
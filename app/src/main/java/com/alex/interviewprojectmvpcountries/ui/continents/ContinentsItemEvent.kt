package com.alex.interviewprojectmvpcountries.ui.continents

sealed class ContinentsItemEvent{
    data class OnNoteClick(val id:String) : ContinentsItemEvent()
}

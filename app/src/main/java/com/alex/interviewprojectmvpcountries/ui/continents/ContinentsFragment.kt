package com.alex.interviewprojectmvpcountries.ui.continents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alex.interviewprojectmvpcountries.R
import com.alex.interviewprojectmvpcountries.framework.network.model.Continent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_continents.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class ContinentsFragment : MvpAppCompatFragment(),ContinentsView {

    private lateinit var continentsAdapter: ContinentsAdapter

    @Inject
    lateinit var presenterProvider: Provider<ContinentsPresenter>


    private val presenter: ContinentsPresenter by moxyPresenter { presenterProvider.get() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_continents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        continentsAdapter = ContinentsAdapter().apply {
            recyclerViewCities.adapter = this
            this.event.observe(viewLifecycleOwner,{
                when(it){
                    is ContinentsItemEvent.OnNoteClick -> {
                        presenter.onContinentSelected(it.id)
                    }
                }
            })
        }
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun addAllContinents(continents: List<Continent>) {
        continentsAdapter.submitList(continents)
    }

}
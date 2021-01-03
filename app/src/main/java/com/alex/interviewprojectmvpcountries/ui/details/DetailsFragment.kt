package com.alex.interviewprojectmvpcountries.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alex.interviewprojectmvpcountries.R
import com.alex.interviewprojectmvpcountries.framework.network.model.Continent
import com.alex.interviewprojectmvpcountries.framework.network.model.Country
import com.alex.interviewprojectmvpcountries.ui.continents.ContinentsPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_continents.*
import kotlinx.android.synthetic.main.fragment_continents.progressBar
import kotlinx.android.synthetic.main.fragment_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class DetailsFragment : MvpAppCompatFragment(), DetailsView {

    private lateinit var detailsAdapter: DetailsAdapter

    @Inject
    lateinit var presenterProvider: Provider<DetailsPresenter>


    private val presenter: DetailsPresenter by moxyPresenter { presenterProvider.get() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        detailsAdapter = DetailsAdapter()
        recyclerViewCountries.adapter = detailsAdapter
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

    override fun addAllCountries(countries:List<Country>) {
        detailsAdapter.submitList(countries)
    }


}
package com.alex.interviewprojectmvpcountries.ui.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alex.interviewprojectmvpcountries.R
import com.alex.interviewprojectmvpcountries.framework.network.model.Country

class DetailsAdapter : ListAdapter<Country, DetailsAdapter.NoteViewHolder>(ContestsDiffUtilCallBack()) {


    class NoteViewHolder(root: View): RecyclerView.ViewHolder(root){
        val countryTextView = root.findViewById(R.id.countryTextView) as TextView
        val countryEmojiTextView = root.findViewById(R.id.countryEmojiTextView) as TextView
        val nativeTextView = root.findViewById(R.id.nativeTextView) as TextView
        val phoneTextView = root.findViewById(R.id.phoneTextView) as TextView
        val capitalTextView = root.findViewById(R.id.capitalTextView) as TextView
        val currencyTextView = root.findViewById(R.id.currencyTextView) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
            inflater.inflate(R.layout.country_details_item, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let { note ->
            holder.nativeTextView.text = note.native
            holder.phoneTextView.text = note.phone
            holder.capitalTextView.text = note.capital
            holder.currencyTextView.text = note.currency
            holder.countryTextView.text = note.name
        }
    }
}
class ContestsDiffUtilCallBack : DiffUtil.ItemCallback<Country>(){
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }


}
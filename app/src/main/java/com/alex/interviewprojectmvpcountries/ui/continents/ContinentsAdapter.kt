package com.alex.interviewprojectmvpcountries.ui.continents

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alex.interviewprojectmvpcountries.R
import com.alex.interviewprojectmvpcountries.framework.network.model.Continent

class ContinentsAdapter(val event: MutableLiveData<ContinentsItemEvent> = MutableLiveData()) : ListAdapter<Continent, ContinentsAdapter.NoteViewHolder>(ContestsDiffUtilCallBack()) {


    class NoteViewHolder(root: View): RecyclerView.ViewHolder(root){
        val textView = root.findViewById(R.id.textView) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
                inflater.inflate(R.layout.city_row, parent,false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let {note ->
            holder.textView.text = note.name
            holder.itemView.setOnClickListener {
                event.postValue(ContinentsItemEvent.OnNoteClick(note.code))
            }
        }
    }
}
 class ContestsDiffUtilCallBack : DiffUtil.ItemCallback<Continent>(){
    override fun areItemsTheSame(oldItem: Continent, newItem: Continent): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Continent, newItem: Continent): Boolean {
        return oldItem == newItem
    }


}
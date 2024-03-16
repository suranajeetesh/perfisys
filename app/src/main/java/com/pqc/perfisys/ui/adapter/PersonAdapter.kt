package com.pqc.perfisys.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pqc.perfisys.data.local.PersonData
import com.pqc.perfisys.databinding.ItemPersonBinding

class PersonAdapter(private val listener: OnPersonClickListener) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private val personList = ArrayList<PersonData>()

    @SuppressLint("NotifyDataSetChanged")
    fun setPersonList(list: List<PersonData>) {
        personList.clear()
        personList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    inner class PersonViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val person = personList[position]
                    listener.onPersonClick(person)
                }
            }
        }

        fun bind(person: PersonData) {
            binding.apply {
                textName.text = person.name
                textScore.text = person.score.toString()
            }
        }
    }

    interface OnPersonClickListener {
        fun onPersonClick(person: PersonData)
    }
}

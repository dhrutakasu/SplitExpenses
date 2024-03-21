package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.databinding.LayoutAddMembersBinding

class MemberAddAdapter(val context: Context, val listOfMembers: MutableList<String>) :
    RecyclerView.Adapter<MemberAddAdapter.MyViewHolder>() {
    class MyViewHolder(binding: LayoutAddMembersBinding) : RecyclerView.ViewHolder(binding.root) {
        val TvMembersGroupName = binding.TvMembersGroupName
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = LayoutAddMembersBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.TvMembersGroupName.text = listOfMembers[position].toString()
    }

    override fun getItemCount(): Int {
        return listOfMembers.size
    }
}

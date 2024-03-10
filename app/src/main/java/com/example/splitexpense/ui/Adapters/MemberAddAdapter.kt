package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.databinding.LayoutAddMembersBinding

class MemberAddAdapter(context: Context) : RecyclerView.Adapter<MemberAddAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: LayoutAddMembersBinding) : RecyclerView.ViewHolder(ItemView.root) {
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
    }

    override fun getItemCount(): Int {
        return 10
    }

}

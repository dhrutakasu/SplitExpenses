package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.databinding.LayoutListFolderBinding

class ListFolderAddAdapter(val context: Context, val list: ListFolderClick) :
    RecyclerView.Adapter<ListFolderAddAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: LayoutListFolderBinding) : RecyclerView.ViewHolder(ItemView.root) {
        val IvShare=ItemView.IvShare
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = LayoutListFolderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            list.onFolderClick()
        }
        holder.IvShare.setOnClickListener {
            list.onShareClick()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    interface ListFolderClick {
        fun onFolderClick()
        fun onShareClick()
    }
}

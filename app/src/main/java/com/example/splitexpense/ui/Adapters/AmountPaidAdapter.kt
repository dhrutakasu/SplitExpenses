package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.databinding.LayoutAmountPaidBinding
import com.example.splitexpense.databinding.LayoutAmountPaidShareBinding
import com.example.splitexpense.databinding.LayoutListFolderBinding

class AmountPaidAdapter(context: Context) : RecyclerView.Adapter<AmountPaidAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: LayoutAmountPaidBinding) : RecyclerView.ViewHolder(ItemView.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = LayoutAmountPaidBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }
}

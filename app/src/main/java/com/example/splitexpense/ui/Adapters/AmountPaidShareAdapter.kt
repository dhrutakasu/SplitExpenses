package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.databinding.LayoutAmountPaidBinding
import com.example.splitexpense.databinding.LayoutAmountPaidShareBinding
import com.example.splitexpense.databinding.LayoutListFolderBinding
import com.example.splitexpense.ui.Activities.MemberListActivity

class AmountPaidShareAdapter(val context: Context) :
    RecyclerView.Adapter<AmountPaidShareAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: LayoutAmountPaidShareBinding) :
        RecyclerView.ViewHolder(ItemView.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = LayoutAmountPaidShareBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, MemberListActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}

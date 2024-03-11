package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.databinding.LayoutListFolderBinding
import com.example.splitexpense.databinding.LayoutTabTypeBinding

class ExpenseAdapter(context: Context, val expense: ExpenseClick) :
    RecyclerView.Adapter<ExpenseAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: LayoutTabTypeBinding) : RecyclerView.ViewHolder(ItemView.root) {
        val IvMenu=ItemView.IvMenu
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = LayoutTabTypeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            expense.onExpenseClick()
        }
        holder.IvMenu.setOnClickListener {
            expense.onMenuClick()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    interface ExpenseClick {
        fun onExpenseClick()
        fun onMenuClick()
    }
}

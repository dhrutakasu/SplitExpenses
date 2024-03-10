package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.R
import com.example.splitexpense.databinding.LayoutMemberListBinding

class MemberListAdapter(val context: Context) :
    RecyclerView.Adapter<MemberListAdapter.MyViewHolder>() {
    private var isSelection: Int = -1

    class MyViewHolder(binding: LayoutMemberListBinding) : RecyclerView.ViewHolder(binding.root) {
        val ConsData = binding.ConsData
        val TvMembersGroupName = binding.TvMembersGroupName
        val TvMembersCount = binding.TvMembersCount
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = LayoutMemberListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (isSelection == position) {
            holder.ConsData.getBackground().setColorFilter(
                context.resources.getColor(R.color.main_color),
                PorterDuff.Mode.SRC_ATOP
            )
            holder.TvMembersGroupName.isSelected = true
            holder.TvMembersCount.isSelected = true
        } else {
            holder.ConsData.getBackground().setColorFilter(
                context.resources.getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP
            )
            holder.TvMembersGroupName.isSelected = false
            holder.TvMembersCount.isSelected = false
        }
        holder.itemView.setOnClickListener {
            isSelection = position
            notifyDataSetChanged()

        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}

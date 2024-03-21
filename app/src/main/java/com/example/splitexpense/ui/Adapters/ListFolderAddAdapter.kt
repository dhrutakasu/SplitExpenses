package com.example.splitexpense.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.Constants.Const
import com.example.splitexpense.Model.DataItem
import com.example.splitexpense.R
import com.example.splitexpense.databinding.LayoutListFolderBinding

class ListFolderAddAdapter(
    val context: Context,
    val listOfFolder: ArrayList<DataItem>,
    val list: ListFolderClick
) :
    RecyclerView.Adapter<ListFolderAddAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: LayoutListFolderBinding) : RecyclerView.ViewHolder(ItemView.root) {
        val IvShare = ItemView.IvShare
        val TvGroupName = ItemView.TvGroupName
        val TvCreateGroupName = ItemView.TvCreateGroupName
        val TvTransaction = ItemView.TvTransaction
        val TvFirstLetter = ItemView.TvFirstLetter
        val TvSecondLetter = ItemView.TvSecondLetter
        val TvForLetter = ItemView.TvForLetter
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
        holder.TvGroupName.text = listOfFolder[position].name
        holder.TvCreateGroupName.text = Const.formatDate(listOfFolder[position].createdAt!!)
        holder.TvTransaction.text = context.resources.getString(
            R.string._6_transactions_6000_spent,
            listOfFolder[position].transactions,
            listOfFolder[position].expense
        )
        if (!listOfFolder[position].members!!.isNullOrEmpty()) {
            println("========= :: "+listOfFolder[position].members!!.toString())

            if (listOfFolder[position].members!!.size > 0) {
                val firstLetter = listOfFolder[position].members!![0]!!.firstOrNull()?.toString() ?: ""
                if (firstLetter.isEmpty()) {
                    holder.TvFirstLetter.visibility = View.GONE
                } else {
                    holder.TvFirstLetter.visibility = View.VISIBLE
                    holder.TvFirstLetter.text = firstLetter
                }
            }else{
                holder.TvFirstLetter.visibility = View.GONE
            }
            if (listOfFolder[position].members!!.size > 1) {
                val secondLetter = listOfFolder[position].members!![1]!!.firstOrNull()?.toString() ?: ""
                if (secondLetter.isEmpty()) {
                    holder.TvSecondLetter.visibility = View.GONE
                } else {
                    holder.TvSecondLetter.visibility = View.VISIBLE
                    holder.TvSecondLetter.text = secondLetter
                }
            }else{
                holder.TvSecondLetter.visibility = View.GONE
            }
            if (listOfFolder[position].members!!.size > 2) {
                holder.TvForLetter.visibility = View.VISIBLE
                holder.TvForLetter.text = "+${(listOfFolder[position]!!.members!!.size - 2)}"
            } else {
                holder.TvForLetter.visibility = View.GONE
            }
        } else {
            holder.TvFirstLetter.visibility = View.GONE
            holder.TvSecondLetter.visibility = View.GONE
            holder.TvForLetter.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            list.onFolderClick()
        }
        holder.IvShare.setOnClickListener {
            list.onShareClick()
        }
    }

    override fun getItemCount(): Int {
        return listOfFolder.size
    }

    interface ListFolderClick {
        fun onFolderClick()
        fun onShareClick()
    }
}

package com.example.splitexpense.Model

import com.google.gson.annotations.SerializedName

data class ListOfGroupData(

	@field:SerializedName("issuccess")
	val issuccess: Boolean? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItem(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("members")
	val members: List<String?>? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("expense")
	val expense: Int? = null,

	@field:SerializedName("transactions")
	val transactions: Int? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

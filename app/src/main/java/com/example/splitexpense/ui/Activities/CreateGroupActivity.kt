package com.example.splitexpense.ui.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitexpense.Constants.Const
import com.example.splitexpense.Model.CreateGroupData
import com.example.splitexpense.Model.ListOfGroupData
import com.example.splitexpense.R
import com.example.splitexpense.Utils.LoadProgressDialog
import com.example.splitexpense.databinding.ActivityCreateGroupBinding
import com.example.splitexpense.retrofit.RetrofitConfig
import com.example.splitexpense.ui.Adapters.MemberAddAdapter
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody


class CreateGroupActivity : AppCompatActivity() {
    private var REQUEST_CONTACT: Int = 110
    private lateinit var context: CreateGroupActivity
    private lateinit var binding: ActivityCreateGroupBinding
    private var listOfMembers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListeners()
        initActions()
    }

    private fun initViews() {
        context = this@CreateGroupActivity
    }

    private fun initListeners() {
        binding.LayoutTool.ConsLeft.setOnClickListener {
            finish()
        }
        binding.LayoutTool.TvRightView.setOnClickListener {
            CreateGroup()
        }
        binding.IvContactMember.setOnClickListener {
            ChooseContactNumbers()
        }
        binding.IvAddMember.setOnClickListener {
            if (binding.EdtAddMember.text.isNotEmpty()) {
                listOfMembers.add(binding.EdtAddMember.text.toString().trim())
                binding.EdtAddMember.text.clear()
                binding.EdtAddMember.setText("")
                binding.ConsGroupList.visibility = View.VISIBLE
                println("============ list of members : $listOfMembers")
                binding.RvMembers.adapter!!.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Please Add Member Name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initActions() {
        binding.LayoutTool.TvSubTitle.visibility = View.GONE
        binding.LayoutTool.TvGroup.text = getString(R.string.create_group)

        binding.RvMembers.layoutManager = LinearLayoutManager(this@CreateGroupActivity)
        binding.RvMembers.adapter = MemberAddAdapter(this@CreateGroupActivity, listOfMembers)
        binding.ConsGroupList.visibility = View.GONE
    }

    private fun CreateGroup() {
        if (!listOfMembers.isNullOrEmpty()) {
            if (binding.EdtGroupName.text.isEmpty()) {
                Toast.makeText(context, "Please Enter Group name", Toast.LENGTH_SHORT).show()
            } else if (binding.EdtCurrency.text.isEmpty()) {
                Toast.makeText(context, "Please Enter Currency", Toast.LENGTH_SHORT).show()
            } else {
                initApis()
            }
        } else {
            Toast.makeText(context, "Please Add Members", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ChooseContactNumbers() {
        val pickContact = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        pickContact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE)
        startActivityForResult(pickContact, REQUEST_CONTACT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val contactData: Uri = data!!.data!!
        val c = contentResolver.query(contactData, null, null, null, null)
        if (c!!.moveToFirst()) {
            val phoneIndex: Int =
                c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val num = c!!.getString(phoneIndex)
            listOfMembers.add(num)
            binding.ConsGroupList.visibility = View.VISIBLE
            Toast.makeText(this@CreateGroupActivity, "Number=$num", Toast.LENGTH_LONG).show()
            println("============ list of members : $listOfMembers")
            binding.RvMembers.adapter!!.notifyDataSetChanged()
        }
    }

    private fun initApis() {
           if (Const.isNetwork(applicationContext)) {
               LoadProgressDialog.showDialog(context)
               val jsonObject = JsonObject()
               jsonObject.addProperty("name", binding.EdtGroupName.text.toString().trim())
               jsonObject.addProperty("currency", binding.EdtCurrency.text.toString().trim())
               jsonObject.addProperty("members", listOfMembers.toString())
               jsonObject.addProperty("userId", "kds detail")
               println("------ JSON : $jsonObject")
               val mediaType = "application/json".toMediaType()
               val jsonBody = Gson().toJson(jsonObject)
               val requestBody = jsonBody.toRequestBody(mediaType)
               val call = RetrofitConfig.getRequestInterface().CreateGroup(
                   requestBody
               )

               call.enqueue(object : retrofit2.Callback<ResponseBody> {
                   override fun onResponse(
                       call: retrofit2.Call<ResponseBody>,
                       response: retrofit2.Response<ResponseBody>
                   ) {
                       println("========== body ${response.body()}")
                       when (response.code()) {
                           201 -> {
                               println("========== 200 $requestBody")
                               val listCreateOfGroupData =
                                   Gson().fromJson(
                                       response.body()!!.string(),
                                       CreateGroupData::class.java
                                   )

                               if (listCreateOfGroupData.issuccess!!.toString().equals("true")) {
                                   finish()
                                   Toast.makeText(context,listCreateOfGroupData.message,Toast.LENGTH_SHORT).show()
                               }else{
                                   Toast.makeText(context,"Group not created",Toast.LENGTH_SHORT).show()
                               }
                               LoadProgressDialog.hideDialog(context)
                           }

                           else -> {
                               println("========== response.code() ${response.code()}")
                               LoadProgressDialog.hideDialog(context)
                           }
                       }
                   }

                   override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                       println("========== onFailure ${t.message}")
                       LoadProgressDialog.hideDialog(context)
                   }
               })
           } else {
               Const.showNoInternetDialog(context, object : Const.Companion.TryAgainInternet {
                   override fun InternetAgainClick() {
                       initApis()
                   }
               })
           }
    }
}
package com.example.caldas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.util.ArrayList
import org.json.JSONArray
import org.json.JSONException

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mContacts: ArrayList<Contact>
    private lateinit var mAdapter: ContactsAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       recycler = findViewById(R.id.contact_list)
        setupRecyclerView()
        generateContacts()
//        mContacts = createMockContacts()
    }

    private fun setupRecyclerView() {
        mContacts = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = ContactsAdapter(mContacts)
        recycler.adapter = mAdapter
    }

    private fun generateContacts() {
        val contactsString = readContactJsonFile()
        try {
            val contactsJson = JSONArray(contactsString)
            for (i in 0 until contactsJson.length()) {
                val contactJson = contactsJson.getJSONObject(i)
                val contact = Contact(
                    contactJson.getString("first_name"),
                    contactJson.getString("last_name"),
                    contactJson.getString("email")
                )
                Log.d(TAG, "generateContacts: $contact")
                mContacts.add(contact)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    private fun readContactJsonFile(): String? {
        var contactsString: String? = null
        try {
            val inputStream = assets.open("mock_contacts.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }

    private fun createMockContacts(): ArrayList<Contact> {
        return arrayListOf(
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Juan", "Perez", "juan@gmail.com")
        )
    }
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
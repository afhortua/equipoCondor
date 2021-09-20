package com.condorteam.caldasturisticofinal1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.place_main)

        val placeDesc = findViewById<TextView>(R.id.place_desc)
        placeDesc.movementMethod = ScrollingMovementMethod()
       // val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
       // val adapter= CustomAdapter()

       // recyclerView.layoutManager = LinearLayoutManager(this)
       // recyclerView.adapter = adapter
    }
}
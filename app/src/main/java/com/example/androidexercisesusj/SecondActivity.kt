package com.example.androidexercisesusj

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexercisesusj.R
import kotlinx.android.synthetic.main.activity_first.*

class SecondActivity : AppCompatActivity() {

    lateinit var items : Array<String>

    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        items = createSampleData(100)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        lvItems.adapter = this.adapter
        lvItems.onItemClickListener = AdapterView.OnItemClickListener { _ , _, position, _ ->
            var selected = adapter.getItem(position)
            Toast.makeText(this, selected, Toast.LENGTH_SHORT).show()
        }
    }
    private fun createSampleData(size: Int) = Array(size) { it -> "Item ${it + 1}" }


}

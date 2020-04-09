package com.example.androidexercisesusj

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexercisesusj.R
import kotlinx.android.synthetic.main.activity_first.*

class ThirdActivity : AppCompatActivity() {

    lateinit var items : MutableList<String>

    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        items = createSampleData(100)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        lvItems.adapter = adapter
        lvItems.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            var selected = adapter.getItem(position)
            adapter.remove(selected)
            adapter.add("NEW OBJECT")
            adapter.notifyDataSetChanged()
        }
    }

    private fun createSampleData(size: Int) = mutableListOf<String>().apply {
        for (i in 0..size)
            add("Item ${i + 1}")
    }
}

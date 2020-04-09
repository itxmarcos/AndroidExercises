package com.example.androidexercisesusj

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexercisesusj.R
import com.example.androidexercisesusj.adapters.CustomArrayAdapter
import kotlinx.android.synthetic.main.activity_first.*

class FourthActivity : AppCompatActivity() {

    lateinit var items : Array<String>

    lateinit var adapter : CustomArrayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        items = createSampleData(100)
        adapter =
            CustomArrayAdapter(this, R.layout.row_element, items)
        lvItems.adapter = this.adapter
        lvItems.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show()
        }
    }

    private fun createSampleData(size: Int) = Array(size) { it -> "Item ${it + 1}" }

}

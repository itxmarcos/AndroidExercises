package com.example.androidexercisesusj

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexercisesusj.R
import com.example.androidexercisesusj.adapters.CustomPeopleViewHolderAdapter
import com.example.androidexercisesusj.model.People
import kotlinx.android.synthetic.main.activity_first.*

const val ID = "ID"
const val EDIT_CODE = 27

class SixthActivity : AppCompatActivity() {

    lateinit var adapter : CustomPeopleViewHolderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        adapter = CustomPeopleViewHolderAdapter(context = this, resourceId = R.layout.row_element, items = People.persons)
        lvItems.adapter = this.adapter
        lvItems.setOnItemClickListener { parent, view, position, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            val person = People.persons[position]
            intent.putExtra(ID, person.id)
            startActivityForResult(intent, EDIT_CODE)
            adapter.getView(position, view, parent)
            Log.d("RESULT", "Data updated")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == EDIT_CODE)
            adapter.notifyDataSetChanged()
    }
}

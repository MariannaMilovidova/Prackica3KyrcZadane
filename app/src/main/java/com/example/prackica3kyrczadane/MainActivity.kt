package com.example.prackica3kyrczadane

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var phones: Array<String> = arrayOf(
        "Virat Kohli", "Rohit Sharma", "Steve Smith",
        "Kane Williamson", "Ross Taylor"
    )
    var adapter: ArrayAdapter<String>? = null

    var selectedPhones: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_single_choice,
            phones
        )
        phonesList.setAdapter(adapter)
        phonesList.setOnItemClickListener(){ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            selectedPhones = phonesList.selectedItem.toString()
        }
        rem.setOnClickListener(){
            for (i in 0 until phonesList.count) {
                if(selectedPhones == phonesList.getItemAtPosition(i))
                {
                    adapter!!.remove(selectedPhones.toString())
                }
            }
            phonesList.clearChoices()
            selectedPhones = ""
            adapter!!.notifyDataSetChanged()

            ad.setOnClickListener(){
                if(phone.text != null && phones.contains(phone.text.toString())==false){
                    adapter!!.add(phone.text.toString())
                    phone.setText("")
                    adapter!!.notifyDataSetChanged()
                }
            }
        }
    }




}

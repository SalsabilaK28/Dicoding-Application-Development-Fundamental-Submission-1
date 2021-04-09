 package com.dicoding.picodiploma.listuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

 class MainActivity : AppCompatActivity() {


     private lateinit var adapter: ListUserAdapter
     private lateinit var dataName: Array<String>
     private lateinit var dataUsername: Array<String>
     private lateinit var dataPhoto: TypedArray
     private lateinit var dataLocation: Array<String>
     private lateinit var dataRepository: Array<String>
     private lateinit var dataCompany: Array<String>
     private lateinit var dataFollowers: Array<String>
     private lateinit var dataFollowing: Array<String>
     private var users = arrayListOf<User>()



     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val listView: ListView = findViewById(R.id.lv_list)
         adapter = ListUserAdapter(this)
         listView.adapter = adapter

         prepare()
         addItem()

         listView.onItemClickListener = AdapterView.OnItemClickListener{
            _, _, position, _->
             val user = User(

                     dataName[position],
                     dataUsername[position],
                     dataPhoto.getResourceId(position, -1),
                     dataFollowers[position],
                     dataFollowing[position],
                     dataCompany[position],
                     dataLocation[position],
                     dataRepository[position]

             )


             val intent = Intent(this@MainActivity, DetailUser::class.java)
             intent.putExtra("user", users[position])

             this@MainActivity.startActivity(intent)
             Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.data_username)
        dataName = resources.getStringArray(R.array.data_name)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataFollowers = resources.getStringArray(R.array.data_followers)
        dataFollowing = resources.getStringArray(R.array.data_following)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataRepository = resources.getStringArray(R.array.data_repository)


    }

    private fun addItem(){
        for(position in dataName.indices) {
            val user = User(

                    dataName[position],
                    dataUsername[position],
                    dataPhoto.getResourceId(position, -1),
                    dataFollowers[position],
                    dataFollowing[position],
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position]

            )
            users.add(user)
        }
        adapter.users = users

    }
}
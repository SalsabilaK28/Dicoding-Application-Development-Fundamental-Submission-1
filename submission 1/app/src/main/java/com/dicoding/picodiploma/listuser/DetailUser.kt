package com.dicoding.picodiploma.listuser

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class DetailUser : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_user)
        val actionB = supportActionBar
        actionB!!.title = "Detail"
        actionB.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>("user") as User

        val txtName: TextView = findViewById(R.id.txt_name)
        val txtUsername: TextView = findViewById(R.id.txt_username)
        val imgPhoto: CircleImageView = findViewById(R.id.img_photo)
        val txtCompany: TextView = findViewById(R.id.txt_company)
        val txtLocation: TextView = findViewById(R.id.txt_location)
        val txtRepository: TextView = findViewById(R.id.txt_repository)
        val txtFollower: TextView = findViewById(R.id.txt_followers)
        val txtFollowing: TextView = findViewById(R.id.txt_following)


        txtName.text = user.name
        txtUsername.text = user.username
        txtFollower.text = user.followers
        txtFollowing.text = user.following
        txtCompany.text = user.company
        txtLocation.text = user.location
        txtRepository.text = user.repository
        user.photo?.let { imgPhoto.setImageResource(it) }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
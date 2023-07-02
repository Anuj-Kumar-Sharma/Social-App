package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socialapp.daos.PostDao
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : AppCompatActivity() {

    private lateinit var postDao: PostDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postDao = PostDao()

        postButton.setOnClickListener {
            val input = postInput.text.toString().trim()
            if(input.isNotEmpty()) {
                postDao.addPost(input)
                finish()

                // val exintent = Intent(this, MainActivity::class.java)
                // startActivity(exintent)
                //I found in some device ths shows an error "java.lang.IndexOutOfBoundsException: Inconsistency detected. Invalid view holder adapter positionPostViewHolder"
                // By replacing the setUpRecyclerView it can be resolved while tapping the post button but if we go back by using phones gesture the app crashed with same erroe
                // can you please update why is this happening
            }
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

    }
}

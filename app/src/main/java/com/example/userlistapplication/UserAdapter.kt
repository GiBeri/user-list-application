package com.example.userlistapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserAdapter(private val userList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private lateinit var databaseReference: DatabaseReference

    init {
        val database = FirebaseDatabase.getInstance()
        databaseReference =
            database.getReference("users") // Replace "users" with your database path
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.tvFirstName)
        val lastName: TextView = itemView.findViewById(R.id.tvLastName)
        val age: TextView = itemView.findViewById(R.id.tvAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.firstName.text = currentUser.firstName
        holder.lastName.text = currentUser.lastName
        holder.age.text = currentUser.age
    }

    override fun getItemCount() = userList.size
}
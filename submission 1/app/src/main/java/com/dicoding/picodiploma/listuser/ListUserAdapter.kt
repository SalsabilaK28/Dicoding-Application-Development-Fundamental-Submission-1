package com.dicoding.picodiploma.listuser


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView


class ListUserAdapter  internal constructor (private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_row_user, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)

        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtUsername: TextView = view.findViewById(R.id.txt_username)
        private val imgPhoto:  CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(user: User) {
            txtName.text = user.name
            txtUsername.text = user.username
            user.photo?.let { imgPhoto.setImageResource(it) }
        }
    }


    override fun getItem(i: Int): Any {
        return users[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return users.size
    }
}
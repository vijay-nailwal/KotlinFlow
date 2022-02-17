package com.flow.examples.kotlinflow.adapter


/**
 * Created by Vijay on 17-02-2022.
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flow.examples.kotlinflow.R
import com.flow.examples.kotlinflow.model.PostModel

class PostAdapter(private val context:Context, private var postList:ArrayList<PostModel>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=postList[position]
        holder.body.text=post.body
    }

    override fun getItemCount(): Int =postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val body:TextView=itemView.findViewById(R.id.body)
    }

    fun setPostData(postList: ArrayList<PostModel>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}
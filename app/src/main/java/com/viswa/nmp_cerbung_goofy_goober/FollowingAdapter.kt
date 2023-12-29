package com.viswa.nmp_cerbung_goofy_goober

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.viswa.nmp_cerbung_goofy_goober.databinding.FollowingCardItemBinding

class FollowingAdapter constructor(private val userId: String): RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>(){
    class FollowingViewHolder(val binding: FollowingCardItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val binding = FollowingCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Global.favorite.size
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        with(holder.binding){
            txtFollowingTitle.text = Global.cerbungs[Global.favorite[position]].title
            txtFollowingAuthor.text = "by " + Global.cerbungs[Global.favorite[position]].penulis
            txtFollowingLastUpdate.text = "Last Update: " + Global.cerbungs[Global.favorite[position]].createDate //Change to Create Date

            val imgUrl = Global.cerbungs[Global.favorite[position]].cerbungImg
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener{picasso, uri, exception->exception.printStackTrace()}
            Picasso.get().load(imgUrl).into(imgCardFollowing)

        }
    }
}
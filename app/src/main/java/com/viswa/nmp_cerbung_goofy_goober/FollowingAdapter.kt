package com.viswa.nmp_cerbung_goofy_goober

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.viswa.nmp_cerbung_goofy_goober.databinding.FollowingCardItemBinding

class FollowingAdapter constructor(private val followingCerbungList: MutableList<Cerbung>): RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>(){
    class FollowingViewHolder(val binding: FollowingCardItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val binding = FollowingCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return followingCerbungList.size
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        with(holder.binding){
            txtFollowingTitle.text = followingCerbungList[position].title
            txtFollowingAuthor.text = "by " + followingCerbungList[position].author_name
            txtFollowingLastUpdate.text = "Last Update: " + followingCerbungList[position].created_date //Change to Create Date

            val imgUrl = followingCerbungList[position].display_picture
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener{picasso, uri, exception->exception.printStackTrace()}
            Picasso.get().load(imgUrl).into(imgCardFollowing)

        }

        holder.binding.cardFollowing.setOnClickListener{
            val intent = Intent(holder.itemView.context, CerbungDetailsActivity::class.java)
            intent.putExtra(HomeFragment.CERBUNG_ID, followingCerbungList[position].id)
            holder.itemView.context.startActivity(intent)
        }
    }
}
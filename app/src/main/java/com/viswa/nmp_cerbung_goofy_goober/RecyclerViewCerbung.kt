package com.viswa.nmp_cerbung_goofy_goober

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import com.squareup.picasso.Picasso

class RecyclerViewCerbung(private val context: Context, private val cerbungList: MutableList<Cerbung>) :
    RecyclerView.Adapter<RecyclerViewCerbung.MyViewHolder>()
{
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
        val txtAuthor: TextView = itemView.findViewById(R.id.txtAuthor)
        val txtDesc : TextView = itemView.findViewById(R.id.txtDesc)
        val imgCover : ImageView = itemView.findViewById(R.id.imgCover)
        val cardView: CardView = itemView.findViewById(R.id.cardView)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cerbung_card_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cerbungList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = cerbungList[position].title
        holder.txtAuthor.text = cerbungList[position].author_name
        holder.txtDesc.text = cerbungList[position].description

//        holder.cerbungImg.setImageResource(cerbungList[position].cerbungImg)
        val imgUrl = cerbungList[position].display_picture
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener{picasso, uri, exception->exception.printStackTrace()}
        Picasso.get().load(imgUrl).into(holder.imgCover)

        holder.cardView.setOnClickListener{
            val intent = Intent(context, CerbungDetailsActivity::class.java)
            intent.putExtra(HomeFragment.CERBUNG_ID, position)
            context.startActivity(intent)
        }
    }
    //



}
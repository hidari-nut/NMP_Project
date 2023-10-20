package com.viswa.nmp_cerbung_goofy_goober

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import android.content.Context
import androidx.core.view.marginTop
import com.squareup.picasso.Picasso

class RecyclerViewCerbung constructor(private val context: Context, private val cerbungList: List<Cerbungs>) : RecyclerView.Adapter<RecyclerViewCerbung.MyViewHolder>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cerbung_card_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cerbungList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = cerbungList[position].judul
        holder.txtAuthor.text = cerbungList[position].penulis
        holder.txtDesc.text = cerbungList[position].deskripsi

//        holder.cerbungImg.setImageResource(cerbungList[position].cerbungImg)
        val imgUrl = cerbungList[position].cerbungImg
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener{picasso, uri, exception->exception.printStackTrace()}
        Picasso.get().load(imgUrl).into(holder.imgCover)

        holder.cardView.setOnClickListener{
            val intent = Intent(context, CerbungDetailsActivity::class.java)
            intent.putExtra(HomeActivity.CERBUNG_ID, position)
            context.startActivity(intent)
        }
    }
    //
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
        val txtAuthor: TextView = itemView.findViewById(R.id.txtAuthor)
        val txtDesc : TextView = itemView.findViewById(R.id.txtDesc)
        val imgCover : ImageView = itemView.findViewById(R.id.imgCover)
        val cardView: CardView = itemView.findViewById(R.id.cardView)

    }



}
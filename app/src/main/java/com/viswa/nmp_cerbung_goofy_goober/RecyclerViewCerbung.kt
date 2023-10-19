package com.viswa.nmp_cerbung_goofy_goober

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerViewCerbung constructor(private val getActivity: HomeActivity, private val cerbungList: List<Cerbungs>): RecyclerView.Adapter<RecyclerViewCerbung.MyViewHolder>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cerbungs_card_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cerbungList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cerbungTitle.text=cerbungList[position].judul
        holder.cerbungWriter.text=cerbungList[position].penulis
        holder.cerbungDesc.text=cerbungList[position].deskripsi
        holder.cerbungImg.setImageResource(cerbungList[position].cerbungImg)

        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity, cerbungList[position].judul, Toast.LENGTH_LONG).show()
        }
    }
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val cerbungTitle : TextView = itemView.findViewById(R.id.cerbungTitle)
        val cerbungWriter: TextView = itemView.findViewById(R.id.cerbungWriter)
        val cerbungDesc : TextView = itemView.findViewById(R.id.cerbungDesc)
        val cerbungImg : ImageView = itemView.findViewById(R.id.imageCerbung)

        val cardView: CardView = itemView.findViewById(R.id.cardCerbungs)

    }



}
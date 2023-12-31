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
import com.viswa.nmp_cerbung_goofy_goober.databinding.CerbungCardItemBinding

class RecyclerViewCerbung(private val context: Context, private val cerbungList: MutableList<Cerbung>) :
    RecyclerView.Adapter<RecyclerViewCerbung.MyViewHolder>()
{
    class MyViewHolder(val binding: CerbungCardItemBinding): RecyclerView.ViewHolder(binding.root)

    private lateinit var binding: CerbungCardItemBinding

//    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
//        val txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
//        val txtAuthor: TextView = itemView.findViewById(R.id.txtAuthor)
//        val txtDesc : TextView = itemView.findViewById(R.id.txtDesc)
//        val imgCover : ImageView = itemView.findViewById(R.id.imgCover)
//        val cardView: CardView = itemView.findViewById(R.id.cardView)
//
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.cerbung_card_item, parent, false)
//        return MyViewHolder(view)
        binding = CerbungCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cerbungList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        binding.txtTitle.text = cerbungList[position].title
        binding.txtAuthor.text = cerbungList[position].author_name
        binding.txtDesc.text = cerbungList[position].description
        binding.txtParagraphCount.text = cerbungList[position].contribution_count.toString()
        binding.txtLikes.text = cerbungList[position].likes.toString()

//        holder.cerbungImg.setImageResource(cerbungList[position].cerbungImg)
        val imgUrl = cerbungList[position].display_picture
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener{picasso, uri, exception->exception.printStackTrace()}
        Picasso.get().load(imgUrl).into(binding.imgCover)

        binding.cardView.setOnClickListener{
            val intent = Intent(context, CerbungDetailsActivity::class.java)
            intent.putExtra(HomeFragment.CERBUNG_ID, position)
            context.startActivity(intent)
        }
    }
    //



}
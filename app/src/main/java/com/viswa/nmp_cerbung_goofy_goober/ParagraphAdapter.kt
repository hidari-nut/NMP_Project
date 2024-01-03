package com.viswa.nmp_cerbung_goofy_goober

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.viswa.nmp_cerbung_goofy_goober.databinding.CerbungParagraphCardItemBinding
import org.json.JSONObject

class ParagraphAdapter constructor(private val cerbungContributions: ArrayList<CerbungContribution>): RecyclerView.Adapter<ParagraphAdapter.ParagraphViewHolder>() {
    class ParagraphViewHolder(val binding: CerbungParagraphCardItemBinding):RecyclerView.ViewHolder(binding.root)

    private lateinit var binding:CerbungParagraphCardItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParagraphViewHolder {
        binding = CerbungParagraphCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParagraphViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cerbungContributions.size
    }


    override fun onBindViewHolder(holder: ParagraphViewHolder, position: Int) {
        with(holder.binding){
            txtParagraph.text = cerbungContributions[position].paragraph
            txtParagraphAuthor.text = cerbungContributions[position].author_name

            if(cerbungContributions[holder.adapterPosition].user_like == 0){
                binding.imgbtnLike.setImageResource(R.drawable.baseline_favorite_border_24)
            }
            else{
                binding.imgbtnLike.setImageResource(R.drawable.baseline_favorite_24)
            }
        }

        binding.imgbtnLike.setOnClickListener{

            val q = Volley.newRequestQueue(holder.itemView.context)
            val url = "https://ubaya.me/native/160421069/project/update_like_paragraph.php"
            var stringRequest = object: StringRequest(
                Request.Method.POST, url, Response.Listener<String>{
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "OK"){
                        if(cerbungContributions[holder.adapterPosition].user_like == 1){
                            cerbungContributions[holder.adapterPosition].user_like = 0
                            holder.binding.imgbtnLike.setImageResource(R.drawable.baseline_favorite_border_24)
                        }
                        else{
                            cerbungContributions[holder.adapterPosition].user_like = 1
                            holder.binding.imgbtnLike.setImageResource(R.drawable.baseline_favorite_24)
                        }

                        // Notify the adapter that the data has changed
                        notifyDataSetChanged()
                    }
                    Log.e("likeresult", obj.toString())

                },
                Response.ErrorListener {
                    Log.e("likeresult", it.message.toString())
                })
            {
                override fun getParams(): MutableMap<String, String>? {
                    val params = HashMap<String, String>()
                    if(cerbungContributions[holder.adapterPosition].user_like == 1){
                        params["likes"] = "0"
                    }
                    else{
                        params["likes"] = "1"
                    }
                    params["contribution_id"] = cerbungContributions[holder.adapterPosition].id.toString()
                    params["user_id"] = Global.currentUser.userId.toString()
                    return params
                }
            }
            q.add(stringRequest)

//            if(cerbungContributions[holder.adapterPosition].user_like == 0){
//                holder.binding.imgbtnLike.setImageResource(R.drawable.baseline_favorite_border_24)
//            }
//            else{
//                holder.binding.imgbtnLike.setImageResource(R.drawable.baseline_favorite_24)
//            }
        }
    }
}
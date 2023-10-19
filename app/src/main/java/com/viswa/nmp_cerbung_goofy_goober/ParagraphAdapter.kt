package com.viswa.nmp_cerbung_goofy_goober

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viswa.nmp_cerbung_goofy_goober.databinding.CerbungParagraphCardItemBinding

class ParagraphAdapter constructor(private val cerbungId: Int): RecyclerView.Adapter<ParagraphAdapter.ParagraphViewHolder>() {
    class ParagraphViewHolder(val binding: CerbungParagraphCardItemBinding):RecyclerView.ViewHolder(binding.root)

    private lateinit var binding:CerbungParagraphCardItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParagraphViewHolder {
        val binding = CerbungParagraphCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParagraphViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Global.cerbungs[cerbungId].paragraphs.size
    }

    override fun onBindViewHolder(holder: ParagraphViewHolder, position: Int) {
        with(holder.binding){
            txtParagraph.text = Global.cerbungs[cerbungId].paragraphs[position].paragraphContent
            txtParagraphAuthor.text = Global.cerbungs[cerbungId].paragraphs[position].author
        }
    }
}
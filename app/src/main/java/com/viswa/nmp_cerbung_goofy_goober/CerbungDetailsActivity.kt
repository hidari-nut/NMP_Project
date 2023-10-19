package com.viswa.nmp_cerbung_goofy_goober

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCerbungDetailsBinding
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityLogInBinding
import com.squareup.picasso.Picasso

class CerbungDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCerbungDetailsBinding;
    val CERBUNG_ID = HomeActivity.CERBUNG_ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCerbungDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var cerbungID = intent.getIntExtra(CERBUNG_ID, 0)

        //Set Cerbung Details
        val imgUrl = Global.cerbungs[cerbungID].cerbungImg
        val builder = Picasso.Builder(this)
        builder.listener{picasso, uri, exception->exception.printStackTrace()}

        with(binding){
            Picasso.get().load(imgUrl).into(imgCover)

            txtTitle.text = Global.cerbungs[cerbungID].judul
            txtParagraphCount.text = Global.cerbungs[cerbungID].paragraphs.size.toString()
            txtLikes.text = Global.cerbungs[cerbungID].likes.toString()
            txtAuthor.text= "by " + Global.cerbungs[cerbungID].penulis
            txtCreateDate.text = Global.cerbungs[cerbungID].createDate
        }

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = ParagraphAdapter(cerbungID)
    }
}
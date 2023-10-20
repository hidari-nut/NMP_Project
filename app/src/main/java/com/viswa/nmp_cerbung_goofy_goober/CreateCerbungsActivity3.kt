package com.viswa.nmp_cerbung_goofy_goober

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCreateCerbungs3Binding

class CreateCerbungsActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungs3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungs3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var shared : SharedPreferences = getSharedPreferences("CreateCerbungsPreferences", Context.MODE_PRIVATE)
    //        setContentView(R.layout.activity_create_cerbungs3)


//        val bundle = intent.extras
        val cerbungTitleText = shared.getString("cerbungTitleText", "")
        val shortDescriptionText = shared.getString("shortDescriptionText", "")
        val cerbungImageCoverURL = shared.getString("cerbungImageCoverURL", "")
        val chooseGenre = shared.getString("chooseGenre", "")
        val firstParagraphText = shared.getString("firstParagraphText", "")
        val radioButtonValue = shared.getString("radioButtonValue", "")

        binding.titleDisplay.text = cerbungTitleText
        binding.genreDisplay.text = chooseGenre
        binding.shortDescriptionDisplay.text = shortDescriptionText
        binding.paragraphDisplay1.text = firstParagraphText
        binding.accessDisplay.text = radioButtonValue

        binding.prevBtn3.setOnClickListener{
            finish()
        }

        binding.publishBtn.setOnClickListener{
//            val intent = Intent(this, HomeActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            startActivity(intent)
            finish()
        }
    }
}
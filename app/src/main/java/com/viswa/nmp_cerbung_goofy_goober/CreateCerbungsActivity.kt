package com.viswa.nmp_cerbung_goofy_goober

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCreateCerbungsBinding

class CreateCerbungsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungsBinding.inflate(layoutInflater)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Global.genre)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.chooseGenreDropDown.adapter = adapter

        setContentView(binding.root)
//        setContentView(R.layout.activity_create_cerbungs)

        binding.nextBtn.setOnClickListener(){
            var shared: SharedPreferences = getSharedPreferences("CreateCerbungsPreferences", Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor = shared.edit()
            editor.putString("cerbungTitleText", binding.cerbungTitleText.text.toString())
            editor.putString("shortDescriptionText", binding.shortDescriptionText.text.toString())
            editor.putString("cerbungImageCoverURL", binding.cerbungImageCoverURL.text.toString())
            editor.putString("chooseGenre", binding.chooseGenreDropDown.selectedItem.toString())
            editor.apply()

//            val bundle = Bundle()
//            bundle.putString("cerbungTitleText", binding.cerbungTitleText.toString())
//            bundle.putString("shortDescriptionText", binding.shortDescriptionText.toString())
//            bundle.putString("cerbungImageCoverURL", binding.cerbungImageCoverURL.toString())
//            bundle.putString("chooseGenre", binding.chooseGenreDropDown.selectedItem.toString())
//


            val intent = Intent(this, CreateCerbungsActivity2::class.java)
//            intent.putExtra("cerbungTitleText", binding.cerbungTitleText.toString())
//            intent.putExtra("shortDescriptionText", binding.shortDescriptionText.toString())
//            intent.putExtra("cerbungImageCoverURL", binding.cerbungImageCoverURL.toString())
//            intent.putExtra("chooseGenre", binding.chooseGenreDropDown.selectedItem.toString())
//            intent.putExtras(bundle)
            startActivity(intent)

        }


    }
}
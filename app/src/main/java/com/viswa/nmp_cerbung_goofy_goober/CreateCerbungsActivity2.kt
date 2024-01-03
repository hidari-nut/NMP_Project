package com.viswa.nmp_cerbung_goofy_goober

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCreateCerbungs2Binding

class CreateCerbungsActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungs2Binding
    private var radioButtonValue: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungs2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.prevBtn.setOnClickListener{
            finish()
        }

        var radioButtonValue = ""
        binding.accessGroup.setOnCheckedChangeListener { radioGroup, id ->
            var selectedRadio = findViewById<RadioButton>(id)
            radioButtonValue = selectedRadio.text.toString()
        }

        binding.nextBtn2.setOnClickListener{
            var shared: SharedPreferences = this.getSharedPreferences("CreateCerbungsPreferences", Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor = shared.edit()
            var firstParagraphText = binding.firstParagraphText.text.toString()
            editor.putString("radioButtonValue", radioButtonValue)
            editor.putString("firstParagraphText", firstParagraphText)
            editor.apply()

            val intent = Intent(this, CreateCerbungsActivity3::class.java)
//            intent.putExtra("radioButtonValue", radioButtonValue)
//            intent.putExtra("firstParagraphText", firstParagraphText)
            startActivity(intent)
        }
    }
}
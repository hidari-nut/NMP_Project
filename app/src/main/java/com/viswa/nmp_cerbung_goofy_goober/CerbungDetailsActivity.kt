package com.viswa.nmp_cerbung_goofy_goober

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCerbungDetailsBinding
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityLogInBinding

class CerbungDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCerbungDetailsBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCerbungDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = ParagraphAdapter()
    }
}
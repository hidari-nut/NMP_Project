package com.viswa.nmp_cerbung_goofy_goober
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityHomeBinding
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityLogInBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    var recyclerView: RecyclerView? = null
    var recyclerViewCerbung: RecyclerViewCerbung? = null
    var cerbungList = mutableListOf<Cerbungs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        cerbungList.addAll(Global.cerbungs) // Add Cerbungs from Global

        recyclerView = findViewById(R.id.recyclerViewHome)
        recyclerViewCerbung = RecyclerViewCerbung(this, cerbungList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = recyclerViewCerbung

        recyclerViewCerbung?.notifyDataSetChanged()

        binding.buttonAddCerbung.setOnClickListener{
            val intent = Intent(this, CreateCerbungsActivity::class.java)
            startActivity(intent)
        }
    }
}

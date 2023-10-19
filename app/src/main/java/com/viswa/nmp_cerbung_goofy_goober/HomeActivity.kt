package com.viswa.nmp_cerbung_goofy_goober
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var recyclerViewCerbung: RecyclerViewCerbung? = null
    var cerbungList = mutableListOf<Cerbungs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cerbungList.addAll(Global.cerbungs) // Add Cerbungs from Global

        recyclerView = findViewById(R.id.recyclerViewHome)
        recyclerViewCerbung = RecyclerViewCerbung(this, cerbungList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = recyclerViewCerbung

        recyclerViewCerbung?.notifyDataSetChanged()
    }
}

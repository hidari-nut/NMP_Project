package com.viswa.nmp_cerbung_goofy_goober

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var recyclerViewCerbung:RecyclerViewCerbung?=null
    var cerbungList = mutableListOf<Cerbungs>()

    val cerbungs = arrayOf(
        Cerbungs(R.drawable.cerbungimg,"Reincarnated as a Surabayans, I now need to deal with hot weather", "Kobo Amane", "Hideo Gosling pemuda dari " +
                "negara Ambasing harus menerima takdirnya direinkarnasikan di Surabaya."),
        Cerbungs(R.drawable.cerbungimg,"The brilliant success of Redd White", "Redd White", "Book about how Redd White easily overcome his struggle to build BLUE CORP."),
        Cerbungs(R.drawable.cerbungimg,"Bocchi the Guitar Hero", "Edgeworth Von Karma", "Ryan Kojima picks up his guitar and transform into Bocchi, The Guitar Hero!"),
        Cerbungs(R.drawable.cerbungimg,"Satria Naga Coco", "Rieno Barrack", "Siapa sangka satria yang ini bukanlah sebuah khayalan."),
        Cerbungs(R.drawable.cerbungimg,"Dodo's Normal Adventure", "Hirahiki Aruku", "Dodo and his Brother, Jio accidentally found a cheap plastic mask in Pasar Atom.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cerbungList = ArrayList()
        recyclerView = findViewById<View>(R.id.recyclerViewHome) as RecyclerView
        recyclerViewCerbung = RecyclerViewCerbung(this@HomeActivity, cerbungList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewCerbung

        cerbungList.add(cerbungs[0])
        cerbungList.add(cerbungs[1])
        cerbungList.add(cerbungs[2])

        recyclerViewCerbung?.notifyDataSetChanged()

    }
}
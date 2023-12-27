package com.viswa.nmp_cerbung_goofy_goober

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagesAdapter(val activity: AppCompatActivity, val fragments: ArrayList<Fragment>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
package com.viswa.nmp_cerbung_goofy_goober

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val fragments: ArrayList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fragments.add(HomeFragment())
        fragments.add(FollowingFragment())
        fragments.add(CreateCerbungFragment())
        fragments.add(UsersFragment())
        fragments.add(PreferencesFragment())

        binding.viewPager.adapter = MainPagesAdapter(this, fragments)
        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.selectedItemId = binding.bottomNav.menu.getItem(position).itemId
            }
        })

        binding.bottomNav.setOnItemSelectedListener{
            binding.viewPager.currentItem = when(it.itemId){
                R.id.itemHome -> 0
                R.id.itemFollowing -> 1
                R.id.itemCreate -> 2
                R.id.itemUsers -> 3
                R.id.itemPrefs -> 4
                else -> 0
            }
            true
        }

    }
}
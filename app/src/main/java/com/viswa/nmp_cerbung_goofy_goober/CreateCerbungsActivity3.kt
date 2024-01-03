package com.viswa.nmp_cerbung_goofy_goober

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCreateCerbungs3Binding
import org.json.JSONObject

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
        val restricted = shared.getString("radioButtonValue", "")
        val genreId = shared.getString("genreId", "")

        binding.titleDisplay.text = cerbungTitleText
        binding.genreDisplay.text = chooseGenre
        binding.shortDescriptionDisplay.text = shortDescriptionText
        binding.paragraphDisplay1.text = firstParagraphText
        binding.accessDisplay.text = restricted

        binding.prevBtn3.setOnClickListener{
            finish()
        }

        binding.publishBtn.setOnClickListener{

            var restrictedInt = 1
            if(restricted.toString() == "Public"){
                restrictedInt = 0
            }

            val q = Volley.newRequestQueue(this)
            val url = "https://ubaya.me/native/160421069/project/create_cerbung.php"
            var stringRequest = object: StringRequest(
                Request.Method.POST,
                url,
                Response.Listener<String>{
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "OK"){

                        Toast.makeText(this, "Successfully created a Cerbung!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else if(obj.getString("result") == "ERROR"){
                        Toast.makeText(this, "Failed to create a cerbung! Please try again", Toast.LENGTH_SHORT).show()
                    }
                },
                Response.ErrorListener {
                    Log.e("createcerbungresult", it.message.toString())
                }
            )
            {
                override fun getParams(): MutableMap<String, String>? {
                    val params = HashMap<String, String>()
                    params["title"] = cerbungTitleText.toString()
                    params["description"] = shortDescriptionText.toString()
                    params["display_picture"] = cerbungImageCoverURL.toString()
//                    params["like_cerbung"] = "0"
//                    params["like_paragraph"] = "0"
                    params["restricted"] = restrictedInt.toString()
                    params["genres_id"] = genreId.toString()
                    params["user_id"] = Global.currentUser.userId.toString()
                    params["paragraph"] = firstParagraphText.toString()
                    return params
                }
            }
            q.add(stringRequest)

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
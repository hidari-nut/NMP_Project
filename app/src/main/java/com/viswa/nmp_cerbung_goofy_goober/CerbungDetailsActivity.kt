package com.viswa.nmp_cerbung_goofy_goober

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityCerbungDetailsBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject

class CerbungDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCerbungDetailsBinding;
    val CERBUNG_ID = HomeFragment.CERBUNG_ID
    var currentCerbung: Cerbung = Cerbung()

    override fun onResume() {
        super.onResume()
        updateList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cerbungID = intent.getIntExtra(CERBUNG_ID, 0)

        binding = ActivityCerbungDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        updateList()

        binding.imgbtnLikeCerbung.setOnClickListener{

            val q = Volley.newRequestQueue(this)
            val url = "https://ubaya.me/native/160421069/project/update_like_cerbung.php"
            var stringRequest = object: StringRequest(
                Request.Method.POST, url, Response.Listener<String>{
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "OK"){
                        if(currentCerbung.user_like == 1){
                            currentCerbung.user_like = 0
                            currentCerbung.likes -= 1
                            binding.imgbtnLikeCerbung.setImageResource(R.drawable.baseline_favorite_border_24)
                        }
                        else{
                            currentCerbung.user_like = 1
                            currentCerbung.likes += 1
                            binding.imgbtnLikeCerbung.setImageResource(R.drawable.baseline_favorite_24)
                        }
                        binding.txtLikes.text = currentCerbung.likes.toString()
                    }
                    Log.e("likeresult", obj.toString())

                },
                Response.ErrorListener {
                    Log.e("likeresult", it.message.toString())
                })
            {
                override fun getParams(): MutableMap<String, String>? {
                    val params = HashMap<String, String>()
                    if(currentCerbung.user_like == 1){
                        params["likes"] = "0"
                    }
                    else{
                        params["likes"] = "1"
                    }
                    params["cerbung_id"] = cerbungID.toString()
                    params["user_id"] = Global.currentUser.userId.toString()
                    return params
                }
            }
            q.add(stringRequest)
        }

        binding.imgbtnFollowCerbung.setOnClickListener{

            val q = Volley.newRequestQueue(this)
            val url = "https://ubaya.me/native/160421069/project/update_follow_cerbung.php"
            var stringRequest = object: StringRequest(
                Request.Method.POST, url, Response.Listener<String>{
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "OK"){
                        if(currentCerbung.user_follow == 1){
                            currentCerbung.user_follow = 0
                            binding.imgbtnFollowCerbung.setImageResource(R.drawable.outline_bookmark_add_24)
                        }
                        else{
                            currentCerbung.user_follow = 1
                            binding.imgbtnFollowCerbung.setImageResource(R.drawable.baseline_bookmark_added_24)
                        }
                    }
                    Log.e("followresult", obj.toString())
                },
                Response.ErrorListener {
                    Log.e("followresult", it.message.toString())
                })
            {
                override fun getParams(): MutableMap<String, String>? {
                    val params = HashMap<String, String>()
                    if(currentCerbung.user_follow == 1){
                        params["follows"] = "0"
                    }
                    else{
                        params["follows"] = "1"
                    }
                    params["cerbung_id"] = cerbungID.toString()
                    params["user_id"] = Global.currentUser.userId.toString()
                    return params
                }
            }
            q.add(stringRequest)
        }

        binding.buttonSubmitRequest.setOnClickListener{
            if(currentCerbung.user_permitted == 0 && currentCerbung.restricted == 1){
                Toast.makeText(this, "Request sent!", Toast.LENGTH_SHORT).show()
            }
            else{
                val q = Volley.newRequestQueue(this)
                val url = "https://ubaya.me/native/160421069/project/create_cerbung_paragraph.php"
                var stringRequest = object: StringRequest(
                    Request.Method.POST, url, Response.Listener<String>{
                        val obj = JSONObject(it)
                        if(obj.getString("result") == "OK"){
                            Toast.makeText(this, "Contribution Submitted!", Toast.LENGTH_SHORT).show()
                            updateList()
                        }
                        else{
                            Toast.makeText(this, "Contribution Submit Failed!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener {
                        Log.e("submitResult", it.message.toString())
                    })
                {
                    override fun getParams(): MutableMap<String, String>? {
                        val params = HashMap<String, String>()
                        params["paragraph"] = binding.addParagraphInput.text.toString()
                        params["cerbung_id"] = cerbungID.toString()
                        params["user_id"] = Global.currentUser.userId.toString()
                        return params
                    }
                }
                q.add(stringRequest)
            }
        }
    }

    fun updateList(){
        var cerbungID = intent.getIntExtra(CERBUNG_ID, 0)

        val q = Volley.newRequestQueue(this)
        val url = "https://ubaya.me/native/160421069/project/read_cerbung_detail.php"
        var stringRequest = object: StringRequest(
            Request.Method.POST, url, Response.Listener<String>{
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK"){
                    val data = obj.getJSONObject("data")
                    val contributions = data.getJSONArray("contributions")

                    val sTypeCerbung = object: TypeToken<Cerbung>(){ }.type
                    currentCerbung = Gson().fromJson(data.toString(), sTypeCerbung) as Cerbung

                    val sTypeContribution = object : TypeToken<ArrayList<CerbungContribution>>() { }.type
                    var currentCerbungContributions = Gson().fromJson(contributions.toString(), sTypeContribution) as
                            ArrayList<CerbungContribution>

                    //Set Cerbung Details
                    val imgUrl = currentCerbung.display_picture
                    val builder = Picasso.Builder(this)
                    builder.listener{picasso, uri, exception->exception.printStackTrace()}

                    with(binding){
                        Picasso.get().load(imgUrl).into(imgCover)

                        txtTitle.text = currentCerbung.title
                        txtParagraphCount.text = currentCerbung.contribution_count.toString()
                        txtLikes.text = currentCerbung.likes.toString()
                        txtAuthor.text = "by " + currentCerbung.author_name
                        txtCreateDate.text = currentCerbung.created_date


                        Log.e("resultsomething2", currentCerbung.user_like.toString())
                        Log.e("resultsomething3", data.toString())

                        if(currentCerbung.user_like == 1){
                            imgbtnLikeCerbung.setImageResource(R.drawable.baseline_favorite_24)
                        }

                        if(currentCerbung.user_follow == 1){
                            imgbtnFollowCerbung.setImageResource(R.drawable.baseline_bookmark_added_24)
                        }

                        if(currentCerbung.user_permitted == 0 && currentCerbung.restricted == 1){
                            binding.addParagraphInput.hint = "This Cerbung is Restricted, Request permission from author to Contribute."
                            binding.addParagraphInput.isEnabled = false
                            binding.buttonSubmitRequest.text = "Request to Contribute"
                        }
                        else{
                            binding.addParagraphInput.hint = "Continue the Story"
                            binding.addParagraphInput.isEnabled = true
                            binding.buttonSubmitRequest.text = "Submit"
                        }

                    }

//                    val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
                    val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                    binding.recyclerViewParagraph?.layoutManager = layoutManager
                    binding.recyclerViewParagraph.setHasFixedSize(false)
                    binding.recyclerViewParagraph.adapter = ParagraphAdapter(currentCerbungContributions)

                    Log.e("detailresult", currentCerbungContributions.toString())
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", cerbungID.toString())
            })
        {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["cerbung_id"] = cerbungID.toString()
                params["user_id"] = Global.currentUser.userId.toString()
                return params
            }
        }

        q.add(stringRequest)
    }

}
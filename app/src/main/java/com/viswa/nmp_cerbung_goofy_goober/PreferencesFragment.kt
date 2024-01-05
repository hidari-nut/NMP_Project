package com.viswa.nmp_cerbung_goofy_goober

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import com.viswa.nmp_cerbung_goofy_goober.databinding.FragmentPreferencesBinding
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PreferencesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PreferencesFragment : Fragment() {
    private lateinit var binding: FragmentPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPreferencesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val imgUrl = Global.currentUser.profile_picture
        Picasso.get().load(imgUrl).into(binding.imgProfilePicPref)
    }

    override fun onResume() {
        super.onResume()
        with(binding){
            UpdateUser()
            usernameInput.setText(Global.currentUser.username)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val builder = Picasso.Builder(context)
        builder.listener{picasso, uri, exception->exception.printStackTrace()}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        UpdateUser()

        binding.usernameInput.setText(Global.currentUser.username)

        binding.switchDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.btnSavePref.setOnClickListener{

            var username = binding.usernameInput.text.toString()

            val q = Volley.newRequestQueue(context)
            val url = "https://ubaya.me/native/160421069/project/update_user.php"
            var stringRequest = object: StringRequest(
                Request.Method.POST, url, Response.Listener<String>{
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "OK"){
                        Toast.makeText(context, "Update Successful!", Toast.LENGTH_SHORT).show()
                    }

                    Log.e("followresult", obj.toString())
                },
                Response.ErrorListener {
                    Log.e("followresult", it.message.toString())
                })
            {
                override fun getParams(): MutableMap<String, String>? {
                    val params = HashMap<String, String>()
                    params["username"] = username
                    params["profile_picture"] = Global.currentUser.userId.toString()
                    params["user_id"] = Global.currentUser.userId.toString()
                    return params
                }
            }
            q.add(stringRequest)
        }

        binding.btnChangePass.setOnClickListener{

            if(binding.newPassInput.text.toString() == binding.repeatPassInput.text.toString()){
                var username = binding.usernameInput.text.toString()

                val q = Volley.newRequestQueue(context)
                val url = "https://ubaya.me/native/160421069/project/update_user_password.php"
                var stringRequest = object: StringRequest(
                    Request.Method.POST, url, Response.Listener<String>{
                        val obj = JSONObject(it)
                        if(obj.getString("result") == "OK"){
                            UpdateUser()
                            binding.usernameInput.setText(Global.currentUser.username)

                            Toast.makeText(context, "Password Change successful!", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            Toast.makeText(context, "Update Failed! Please try again", Toast.LENGTH_LONG).show()
                        }
                        Log.e("followresult", obj.toString())
                    },
                    Response.ErrorListener {
                        Log.e("followresult", it.message.toString())
                    })
                {
                    override fun getParams(): MutableMap<String, String>? {
                        val params = HashMap<String, String>()
                        params["old_password"] = binding.oldPassInput.text.toString()
                        params["new_password"] = binding.newPassInput.text.toString()
                        params["user_id"] = Global.currentUser.userId.toString()
                        return params
                    }
                }
                q.add(stringRequest)
            }
            else{
                Toast.makeText(context, "New password repeat does not match!", Toast.LENGTH_SHORT).show()
            }


        }

        binding.btnLogout.setOnClickListener{
            Global.currentUser = User(0, "default", "url", "created_date")
            val intent = Intent(context, LogInActivity::class.java)
            startActivity(intent)
        }
    }

    fun UpdateUser(){
        val q = Volley.newRequestQueue(context)
        val url = "https://ubaya.me/native/160421069/project/read_user.php"
        var stringRequest = object: StringRequest(
            Request.Method.POST,
            url,
            Response.Listener<String>{
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK"){
                    val data = obj.getJSONObject("data")

                    val sType = object : TypeToken<User>() { }.type
                    Global.currentUser = Gson().fromJson(data.toString(), sType) as User
                    Log.e("updateuser", Global.currentUser.toString())
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
            }
        )
        {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["user_id"] = Global.currentUser.userId.toString()
                return params
            }
        }
        q.add(stringRequest)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PreferencesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PreferencesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
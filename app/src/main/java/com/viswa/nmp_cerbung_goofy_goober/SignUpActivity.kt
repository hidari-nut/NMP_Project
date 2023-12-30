package com.viswa.nmp_cerbung_goofy_goober

import android.content.Intent
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
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivitySignUpBinding
import org.json.JSONObject

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignUp.setOnClickListener {

            var username_input = binding.inputUName.text.toString()
            var profile_picture_input = binding.inputURL.text.toString()
            var password_input = binding.inputPwd.text.toString()
            var password_confirm = binding.inputPwdConf.text.toString()

            if(password_input == password_confirm){
                val q = Volley.newRequestQueue(this)
                val url = "https://ubaya.me/native/160421069/project/create_user.php"
                var stringRequest = object: StringRequest(
                    Request.Method.POST,
                    url,
                    Response.Listener<String>{
                        val obj = JSONObject(it)
                        if(obj.getString("result") == "OK"){

                            Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LogInActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else if(obj.getString("result") == "ERROR"){
                            Toast.makeText(this, "Account creation failed! Please try again", Toast.LENGTH_LONG).show()
                        }
                    },
                    Response.ErrorListener {
                        Log.e("apiresult", it.message.toString())
                    }
                )
                {
                    override fun getParams(): MutableMap<String, String>? {
                        val params = HashMap<String, String>()
                        params["username"] = username_input
                        params["password"] = password_input
                        params["profile_picture"] = profile_picture_input
                        return params
                    }
                }
                q.add(stringRequest)
            }
            else{
                Toast.makeText(this, "Password confirmation incorrect!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

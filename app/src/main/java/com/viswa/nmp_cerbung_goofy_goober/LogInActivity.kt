package com.viswa.nmp_cerbung_goofy_goober

import android.content.ContextParams
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
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityLogInBinding
import org.json.JSONObject

class LogInActivity : AppCompatActivity() {
    public val username: String = "Novella"
    public val password: String = "1234"

    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonLogIn.setOnClickListener {
            val enteredUsername = binding.inputUname.text.toString()
            val enteredPassword = binding.inputPwd.text.toString()

            val q = Volley.newRequestQueue(this)
            val url = "https://ubaya.me/native/160421069/project/login.php"
            var stringRequest = object: StringRequest(
                Request.Method.POST,
                url,
                Response.Listener<String>{
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "Success"){
                        val data = obj.getJSONObject("data")

                        val sType = object : TypeToken<User>() { }.type
                        Global.currentUser = Gson().fromJson(data.toString(), sType) as User

                        Toast.makeText(this, "Correct username and password!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else if(obj.getString("result") == "Failed"){
                        Toast.makeText(this, "Username or Password Incorrect!", Toast.LENGTH_LONG).show()
                    }
                },
                Response.ErrorListener {
                    Log.e("apiresult", it.message.toString())
                }
            )
            {
                override fun getParams(): MutableMap<String, String>? {
                    val params = HashMap<String, String>()
                    params["username"] = enteredUsername
                    params["password"] = enteredPassword
                    return params
                }
            }
            q.add(stringRequest)

            // Toast.makeText(this, "blablabla", Toast.LENGTH_SHORT).show()
//            if (enteredUsername == username && enteredPassword == password) {
//                Toast.makeText(this, "Correct username and password!", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, "Incorrect username or password!", Toast.LENGTH_SHORT).show()
//            }
        }

        binding.buttonSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.viswa.nmp_cerbung_goofy_goober

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.viswa.nmp_cerbung_goofy_goober.databinding.ActivityLogInBinding

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

            // Toast.makeText(this, "blablabla", Toast.LENGTH_SHORT).show()
            if (enteredUsername == username && enteredPassword == password) {
                Toast.makeText(this, "Correct username and password!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrect username or password!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
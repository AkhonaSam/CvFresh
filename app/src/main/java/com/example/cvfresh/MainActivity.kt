package com.example.cvfresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //auth = Firebase.auth
        auth = FirebaseAuth.getInstance()

        /*val email: EditText
        val password: EditText
        val registerBtn: Button
        val loginBtn: Button*/

        // Initialize Firebase Auth


        val email = findViewById<EditText>(R.id.et_user_name)
        val password = findViewById<EditText>(R.id.et_password)
        val register = findViewById<Button>(R.id.btn_register)
        val loginBtn = findViewById<Button>(R.id.btn_login)



        register.setOnClickListener()
        {
            val entered_email = email.text.toString()
            val entered_password = password.text.toString()

            auth.createUserWithEmailAndPassword(entered_email, entered_password).addOnCompleteListener(this,)
            {
                    task ->
                if(task.isSuccessful)
                {
                    Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                }
            }
                .addOnFailureListener(this)
                {
                        exception -> Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
                }
        }

        //need a login event
        loginBtn.setOnClickListener()
        {
            val entered_email = email.text.toString()
            val entered_password = password.text.toString()

            //auth.
        }


    }

    /*public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload()
        }*/
    }

    /*auth.createUserWithEmailAndPassword(email, password)
    .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "createUserWithEmail:success")
            val user = auth.currentUser
            updateUI(user)
        } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "createUserWithEmail:failure", task.exception)
            Toast.makeText(baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT).show()
            updateUI(null)
        }
    }*/



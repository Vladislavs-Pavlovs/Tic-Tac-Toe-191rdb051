package com.example.tic_tac_toe_191rdb051

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "Greetings in tic-tac-toe!", Toast.LENGTH_SHORT).show()
    }

    fun ChooseNamePVP(view : View){
        Intent(this, PVP_Name::class.java).also{
            startActivity(it)
        }
    }
    fun ChooseNamePVC(view : View){
        Intent(this, PVC_Name::class.java).also{
            startActivity(it)
        }
    }
}
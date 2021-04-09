package com.example.tic_tac_toe_191rdb051

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class PVC_Name : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvc_name)
    }
    fun OnePlayerGame(view : View){
        val Player1Name = findViewById<EditText>(R.id.Player1Name)
        val intent =  Intent(this, GameActivity::class.java)
        intent.putExtra("Player1Name",Player1Name.text.toString())
        intent.putExtra("Player2Name","Computer")
        intent.putExtra("comp", true)
        startActivity(intent)
    }
}
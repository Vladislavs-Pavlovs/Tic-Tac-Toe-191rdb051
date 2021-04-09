package com.example.tic_tac_toe_191rdb051

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity()  {


    private var squares =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private var player1Turn: Boolean = true
    private var roundCount: Int = 0
    private var firstPlayerScore: Int = 0
    private var secondPlayerScore: Int = 0
    private var Player1Name: String = ""
    private var Player2Name: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        Player1Name = intent.getStringExtra("Player1Name").toString()
        Player2Name = intent.getStringExtra("Player2Name").toString()
        val comp: Boolean = intent.getBooleanExtra("comp",false)

        val Player1frame = findViewById<TextView>(R.id.FirstName)
        val Player2frame = findViewById<TextView>(R.id.SecondName)



        Player1frame.text = Player1Name
        Player2frame.text = Player2Name


        
        for (i in 0..2){
            for (j in 0..2){
                val square = resources.getIdentifier("square$i$j", "id", packageName)
                squares[i].add(findViewById(square))
                squares[i][j].setOnClickListener{
                    click(squares[i][j], comp)
                }
            }
        }
    }



    private fun win():Boolean{
        val firstScore = findViewById<TextView>(R.id.Player1Score)

        val secondScore = findViewById<TextView>(R.id.Player2Score)

        for(i in 0..2){
        if (squares[i][0].text==squares[i][1].text &&squares[i][0].text==squares[i][2].text && squares[i][0].text!=""){
            if(!player1Turn){
                Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                ++firstPlayerScore
                firstScore.text = "$firstPlayerScore"
            }
            else{
                Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                ++secondPlayerScore
                secondScore.text = "$secondPlayerScore"
            }
            return true}
        }
        for(j in 0..2){
            if (squares[0][j].text==squares[1][j].text &&squares[0][j].text==squares[2][j].text&&squares[0][j].text!=""){
                if(!player1Turn){
                    Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                    ++firstPlayerScore
                    firstScore.text = "$firstPlayerScore"
                }
                else{
                    Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                    ++secondPlayerScore
                    secondScore.text = "$secondPlayerScore"
                }

            return true}
        }
        if(squares[0][0].text==squares[1][1].text &&squares[0][0].text==squares[2][2].text&& squares[0][0].text!=""){
            if(!player1Turn){
                Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                ++firstPlayerScore
                firstScore.text = "$firstPlayerScore"
            }
            else{
                Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                ++secondPlayerScore
                secondScore.text = "$secondPlayerScore"
            }
            return true
        }
        if(squares[0][2].text==squares[1][1].text &&squares[0][2].text==squares[2][0].text&& squares[0][2].text!=""){
            if(!player1Turn){
                Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                ++firstPlayerScore
                firstScore.text = "$firstPlayerScore"
            }
            else{
                Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                ++secondPlayerScore
                secondScore.text = "$secondPlayerScore"
            }
            return true
        }
        

        return false
    }



    private fun draw():Boolean{
        if(roundCount==9 && !win()){
            Toast.makeText(applicationContext, "Draw", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }



    private fun click(square: Button, comp: Boolean) {
        if(square.text!="")return
        if(player1Turn) {
            square.text = "X"
            player1Turn = false
        }
        else{
            square.text ="0"
            player1Turn = true
        }
        roundCount++



        if(win()||draw()){
            for (i in 0..2){
                for (j in 0..2)
                    squares[i][j].text = ""
            }
            player1Turn=true
            roundCount=0
        }
        if(comp){
            computer()}
    }


    private fun computer(){
        var i = 0
        var j = 0

        while(true){
            i = (0..2).random()
            j = (0..2).random()
            if (squares[i][j].text==""){

                break
            }

        }
        if(!player1Turn) {
            click(squares[i][j], false)
        }


    }
}


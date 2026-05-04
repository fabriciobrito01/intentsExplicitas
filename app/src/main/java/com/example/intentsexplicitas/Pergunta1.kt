package com.example.intentsexplicitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Pergunta1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta1)

        val btnNext = findViewById<Button>(R.id.btnNext1)
        val rbBatman = findViewById<RadioButton>(R.id.rbBatman1)
        val rbSpider = findViewById<RadioButton>(R.id.rbSpider1)
        val rbCap = findViewById<RadioButton>(R.id.rbCap1)

        btnNext.setOnClickListener {
            var batmanScore = 0
            var spiderScore = 0
            var capScore = 0

            when {
                rbBatman.isChecked -> batmanScore = 1
                rbSpider.isChecked -> spiderScore = 1
                rbCap.isChecked -> capScore = 1
                else -> {
                    Toast.makeText(this, "Selecione uma opção!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val intent = Intent(this, Pergunta2::class.java)
            intent.putExtra("BATMAN_SCORE", batmanScore)
            intent.putExtra("SPIDER_SCORE", spiderScore)
            intent.putExtra("CAP_SCORE", capScore)
            startActivity(intent)
        }
    }
}
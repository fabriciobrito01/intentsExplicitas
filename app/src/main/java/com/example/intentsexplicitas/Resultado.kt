package com.example.intentsexplicitas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Button

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val btnLink = findViewById<Button>(R.id.btnAbrirLink)

        btnLink.setOnClickListener {
            val url = "https://github.com/fabriciobrito01"

            val intentLink = Intent(Intent.ACTION_VIEW)
            intentLink.data = Uri.parse(url)

            startActivity(intentLink)
        }

        val batmanScore = intent.getIntExtra("BATMAN_SCORE", 0)
        val spiderScore = intent.getIntExtra("SPIDER_SCORE", 0)
        val capScore = intent.getIntExtra("CAP_SCORE", 0)

        val tvHeroResult = findViewById<TextView>(R.id.tvHeroResult)

        val resultado = when {
            batmanScore > spiderScore && batmanScore > capScore -> "🦇 Batman"
            spiderScore > batmanScore && spiderScore > capScore -> "🕷️ Homem-Aranha"
            capScore > batmanScore && capScore > spiderScore -> "🛡️ Capitão América"
            else -> "✨ Você é uma mistura dos três!"
        }

        tvHeroResult.text = resultado
    }
}
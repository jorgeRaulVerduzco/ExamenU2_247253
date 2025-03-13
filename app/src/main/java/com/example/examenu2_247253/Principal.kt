package com.example.examenu2_247253

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_detalles: Button = findViewById(R.id.btn_detalles)
        val btn_globos:Button = findViewById(R.id.btn_globos)
        val btn_peluches:Button = findViewById(R.id.btn_peluches)
        val btn_regalos:Button = findViewById(R.id.btn_regalos)
        val btn_tazas:Button = findViewById(R.id.btn_tazas)

        btn_detalles.setOnClickListener{
            val intent = Intent(this,Regalos::class.java)
            intent.putExtra("title","Detalles")
            startActivity(intent)
        }

        btn_globos.setOnClickListener{
            val intent = Intent(this,Regalos::class.java)
            intent.putExtra("title","Globos")
            startActivity(intent)
        }

        btn_peluches.setOnClickListener{
            val intent = Intent(this,Regalos::class.java)
            intent.putExtra("title","Peluches")
            startActivity(intent)
        }

        btn_regalos.setOnClickListener{
            val intent = Intent(this,Regalos::class.java)
            intent.putExtra("title","Regalos")
            startActivity(intent)
        }

        btn_tazas.setOnClickListener{
            val intent = Intent(this,Regalos::class.java)
            intent.putExtra("title","Tazas")
            startActivity(intent)
        }
    }
}
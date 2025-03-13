package com.example.examenu2_247253

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Regalos : AppCompatActivity() {
    val regalos = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_regalos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tv_title : TextView = findViewById(R.id.tv_detalles)
        val title: String? = intent.getStringExtra("title")

        tv_title.setText(title)

        agregarProductos(title)

        val gridView = findViewById<GridView>(R.id.gv_productos)
        val adapter = DetallesAdapter(this, regalos)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val detalle = regalos[position]

            val intent = Intent(this, DetalleRegalos::class.java)

            intent.putExtra("imagen", detalle.image)
            intent.putExtra("precio", detalle.precio)

            startActivity(intent)
        }
    }
    fun agregarProductos(tipo:String?) {
        when (tipo) {
            "Detalles" -> {
                regalos.add(Detalles(R.drawable.cumplecheve,"$100"))
                regalos.add(Detalles(R.drawable.cumpleescolar, "$200"))
                regalos.add(Detalles(R.drawable.cumplepaletas, "$300"))
                regalos.add(Detalles(R.drawable.cumplesnack, "$400"))
                regalos.add(Detalles(R.drawable.cumplebotanas, "$5000"))
                regalos.add(Detalles(R.drawable.cumplevinos,"$600"))
            }

            "Globos" -> {
                regalos.add(Detalles(R.drawable.globocumple, "$100"))
                regalos.add(Detalles(R.drawable.globoregalo, "$200"))
                regalos.add(Detalles(R.drawable.globocumple, "$300"))
                regalos.add(Detalles(R.drawable.globoamor, "$400"))
                regalos.add(Detalles(R.drawable.globonum, "$500"))
                regalos.add(Detalles(R.drawable.globofestejo, "$600"))
            }

            "Peluches" -> {
                regalos.add(Detalles(R.drawable.peluchesony, "$100"))
                regalos.add(Detalles(R.drawable.peluches, "$200"))
                regalos.add(Detalles(R.drawable.peluchemario, "$300"))
                regalos.add(Detalles(R.drawable.peluchepeppa, "$400"))
                regalos.add(Detalles(R.drawable.peluchestich, "$500"))
                regalos.add(Detalles(R.drawable.peluchemario, "$600"))
                regalos.add(Detalles(R.drawable.pelucheminecraft, "$700"))
            }

            "Regalos" -> {
                regalos.add(Detalles(R.drawable.regalos, "$100"))
                regalos.add(Detalles(R.drawable.regaloazul, "$200"))
                regalos.add(Detalles(R.drawable.regalobebe, "$300"))
                regalos.add(Detalles(R.drawable.regalocajas, "$400"))
                regalos.add(Detalles(R.drawable.regalovarios, "$500"))
                regalos.add(Detalles(R.drawable.regalocajas, "$600"))
                regalos.add(Detalles(R.drawable.regalocolores, "$700"))
            }

            "Tazas" -> {
                regalos.add(Detalles(R.drawable.tazas, "$100"))
                regalos.add(Detalles(R.drawable.tazaabuela, "$200"))
                regalos.add(Detalles(R.drawable.tazaquiero, "$300"))
                regalos.add(Detalles(R.drawable.tazalove, "$400"))
            }
        }
    }

    class DetallesAdapter(private val context: Context, private val detalles: ArrayList<Detalles>) :
        BaseAdapter() {

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(position: Int): Any {
            return detalles[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val detalle = detalles[position]
            val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val vista = inflator.inflate(R.layout.activity_detalle_regalos, null)

            val imageView: ImageView = vista.findViewById(R.id.iv_producto)
            val precioTextView: TextView = vista.findViewById(R.id.tv_precio)

            imageView.layoutParams.height = 300
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP

            precioTextView.textSize = 14f

            imageView.setImageResource(detalle.image)
            precioTextView.text = detalle.precio

            vista.setOnClickListener {
                val intent = Intent(context, DetalleRegalos::class.java)
                intent.putExtra("imagen", detalle.image)
                intent.putExtra("precio", detalle.precio)
                context.startActivity(intent)
            }

            return vista
        }
}}
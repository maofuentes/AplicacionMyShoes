package com.example.shoesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val viewModel: ShoeViewModel by viewModels()
    private lateinit var shoeAdapter: ShoeAdapter
    private val cartItems = mutableListOf<Item>() // Lista carrito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.shoeList.observe(this) { shoeList ->
            shoeAdapter = ShoeAdapter(shoeList) { item ->
                addToCart(item) // agregar
            }
            recyclerView.adapter = shoeAdapter
        }

        // Configurar boton
        val fabCart: FloatingActionButton = findViewById(R.id.fabCart)
        fabCart.setOnClickListener {
        // boton cierra la aplicacion
            //val intent = Intent(this, CartActivity::class.java)
            //intent.putParcelableArrayListExtra("CART_ITEMS", ArrayList(cartItems))
            //startActivity(intent)
        }
    }

    private fun addToCart(item: Item) {
        cartItems.add(item) // Agrega al carrito
        Toast.makeText(this, "${item.name} agregado al carrito", Toast.LENGTH_SHORT).show()
    }
}
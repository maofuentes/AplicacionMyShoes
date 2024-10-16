package com.example.shoesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Parcelable
import android.widget.TextView

class CartActivity : AppCompatActivity() {
    private lateinit var cartItems: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartItems = intent.getParcelableArrayListExtra<Item>("CART_ITEMS") ?: emptyList()

        val recyclerViewCart: RecyclerView = findViewById(R.id.recyclerViewCart)
        recyclerViewCart.layoutManager = LinearLayoutManager(this)
        recyclerViewCart.adapter = CartAdapter(cartItems)
    }
}


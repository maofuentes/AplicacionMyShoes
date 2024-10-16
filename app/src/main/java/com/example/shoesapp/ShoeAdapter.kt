package com.example.shoesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShoeAdapter(
    private val shoeList: List<Item>,
    private val onItemClick: (Item) -> Unit,
    private val onAddToCartClick: (Item) -> Unit
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    inner class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.itemName)
        private val priceTextView: TextView = itemView.findViewById(R.id.itemPrice)
        private val imageView: ImageView = itemView.findViewById(R.id.itemImage)
        private val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)

        fun bind(item: Item) {
            nameTextView.text = item.name
            priceTextView.text = "${item.price} CLP"

            Glide.with(itemView.context)
                .load(item.imageUrl)
                .into(imageView)

            // click imagen
            imageView.setOnClickListener {
                onItemClick(item)
            }

            // boton agregar carrito
            addToCartButton.setOnClickListener {
                onAddToCartClick(item) // Llama al listener
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.bind(shoeList[position])
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }
}
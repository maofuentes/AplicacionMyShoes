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
    private val onAddToCartClick: (Item) -> Unit //
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val shoeImage: ImageView = itemView.findViewById(R.id.shoeImage)
        private val shoeName: TextView = itemView.findViewById(R.id.shoeName)
        private val shoePrice: TextView = itemView.findViewById(R.id.shoePrice)
        private val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)

        fun bind(item: Item, onAddToCartClick: (Item) -> Unit) {
            shoeName.text = item.name
            shoePrice.text = item.price.toString()

            Glide.with(itemView.context)
                .load(item.imageUrl)
                .error(R.drawable.error_image)
                .into(shoeImage)

            // Agregar al carrito
            addToCartButton.setOnClickListener {
                onAddToCartClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.bind(shoeList[position], onAddToCartClick)
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }
}
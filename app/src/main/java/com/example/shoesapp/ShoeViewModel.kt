package com.example.shoesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Item>>() // MutableLiveData para la lista de zapatos
    val shoeList: LiveData<List<Item>> get() = _shoeList

    init {
        loadShoes() // Cargar los zapatos al inicializar
    }

    private fun loadShoes() {
        _shoeList.value = getShoeList() // Asigna la lista de zapatos
    }

    fun getShoeList(): List<Item> {
        return listOf(
            Item("Zapato 1", "https://www.bestiasxx.com/cdn/shop/products/zapato-hombre-upepo-curry-bestias-644907_5000x.jpg", 94.990),
            Item("Zapato 2", "https://www.bestiasxx.com/cdn/shop/files/zapatilla-hombre-dronte-west-fargo-bestias-shoes-655865_400x.jpg", 99.990),
            Item("Zapato 3", "https://www.bestiasxx.com/cdn/shop/files/botin-hombre-new-atlas-low-black-bestias-shoes-338807_400x.jpg", 99.990),
            Item("Zapato 4", "https://www.bestiasxx.com/cdn/shop/files/zapato-hombre-ox-black-bestias-shoes-119412_400x.jpg", 94.990),
            Item("Zapato 5", "https://www.bestiasxx.com/cdn/shop/files/zapatilla-mujer-koi-white-mostaza-bestias-shoes-372677_400x.jpg", 94.990),
            Item("Zapato 6", "https://www.bestiasxx.com/cdn/shop/files/zapatilla-hombre-monkey-west-fargo-bestias-shoes-317064_400x.jpg", 94.990),
            Item("Zapato 7", "https://www.bestiasxx.com/cdn/shop/files/bototo-hombre-yeti-west-fargo-bestias-shoes-536341_400x.jpg", 119.990),
            Item("Zapato 8", "https://www.bestiasxx.com/cdn/shop/files/zapato-hombre-ox-west-fargo-bestias-shoes-788776_400x.jpg", 94.990),
            Item("Zapato 9", "https://www.bestiasxx.com/cdn/shop/files/botin-hombre-kiltro-black-nw-bestias-shoes-134985_400x.jpg", 60.990),
            Item("Zapato 10", "https://www.bestiasxx.com/cdn/shop/files/zapatilla-mujer-cayman-low-cayma-off-white-bestias-shoes-163340_400x.jpg", 49.990)
        )
    }
}
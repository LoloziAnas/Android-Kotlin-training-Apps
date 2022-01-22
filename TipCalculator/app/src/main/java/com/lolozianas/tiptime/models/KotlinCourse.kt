package com.lolozianas.tiptime.models

open class Item(val name: String, val price: Int) {

}

class Noodles() : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }

}

class Vegetables(private vararg val toppings: String) : Item("Vegetables", 20) {
    override fun toString(): String {
        if (toppings.isEmpty()) {
            return "$name Chef's Choice"
        } else {
            return name + " " + toppings.joinToString()
        }
    }


}

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()

    fun addItem(newItem: Item) {
    }

    fun addAll(newItems: List<Item>) {
    }

    fun print() {
        println("Order #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")

    }

}

fun main() {
    val noodles = Noodles()
    val vegetables = Vegetables()
    println(noodles)
    println(vegetables)

}
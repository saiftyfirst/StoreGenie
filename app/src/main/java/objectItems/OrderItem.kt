package com.example.safe.storegenie

/**
 * Created by saiankithramayanam on 5/11/2017.
 */
abstract class OrderItem: BaseItem {
    override var id: Int? = null

    var totalCost: Double? = null

    var products: Array<ProductItem>? = null

    var storeId: Int? = null

    constructor()
    constructor(id: Int?, totalPrice: Double?, products: Array<ProductItem>?, storeId: Int?) {
        this.id = id
        this.totalCost = totalPrice
        this.products = products
        this.storeId = storeId
    }


    fun getTotalCost(): Double {
        var cost: Double = 0.0

        this.products?.forEach {
            it.cost?.let { c -> cost = cost + c  }
        }

        return cost
    }

}
/**
 * Created by saiankithramayanam on 5/11/2017.
 */

package com.example.safe.storegenie

abstract class StoreItem : BaseItem{

    override var id: Int? = null
    var name: String? = null
    var products: Array<ProductItem>? = null

    //  var orderItems: Array<OrderItem>? = null
    constructor()
    constructor(id: Int?, name: String?, products: Array<ProductItem>?) {
        this.id = id
        this.name = name
        this.products = products
    }
}
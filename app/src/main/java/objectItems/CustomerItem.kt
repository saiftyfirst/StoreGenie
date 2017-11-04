/**
 * Created by saiankithramayanam on 5/11/2017.
 */

package com.example.safe.storegenie

abstract class CustomerItem : BaseItem{

    override var id: Int? = null
    var orderItems: Array<OrderItem>? = null

    constructor()
    constructor(id: Int?, orderItems: Array<OrderItem>?) {
        this.id = id
        this.orderItems = orderItems
    }


}
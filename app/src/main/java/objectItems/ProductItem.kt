/**
 * Created by saiankithramayanam on 5/11/2017.
 */

package com.example.safe.storegenie

abstract class ProductItem : BaseItem {

    override var id: Int? = null
    var name: String? = null
    var cost: Double? = null

    var storeId: Int? = null

    var discount: Double? = null

    constructor()

    constructor(id: Int?, name: String?, cost: Double, storeId: Int?) {
        this.id = id
        this.name = name
        this.cost = cost
        this.storeId = storeId
    }

}





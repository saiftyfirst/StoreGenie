package com.example.safe.storegenie

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView

/**
 * Created by saiankithramayanam on 5/11/2017.
 */


class OrdersActivity : AppCompatActivity() {

    internal var itemList: ListView? = null
    internal var context: Context? = null

    var item_names = arrayOf("Bananas", "CocaCola")
    var promoDetails = arrayOf("Half a dozen bananas for only $20!", "Buy 1 get 1 free!")
    var res_ids = intArrayOf(0, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        context = this.context

        itemList = findViewById<ListView>(R.id.ordersList)
        itemList?.adapter = PromotionListAdapter(context, item_names, promoDetails, res_ids)

    }
}

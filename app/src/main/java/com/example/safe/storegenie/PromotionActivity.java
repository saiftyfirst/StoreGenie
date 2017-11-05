package com.example.safe.storegenie;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PromotionActivity extends AppCompatActivity {

    ListView itemList;
    Context context;

    public String[] item_names = {"Bananas", "CocaCola"};
    public String[] promoDetails = {"Half a dozen bananas for only $20!","Buy 1 get 1 free!"};
    public int[] res_ids = {0,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        context = this;

        itemList = (ListView) findViewById(R.id.promoList);
        itemList.setAdapter(new PromotionListAdapter(context, item_names, promoDetails, res_ids));

    }
}

package com.example.safe.storegenie;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Safe on 11/5/2017.
 */

public class PromotionListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater = null;

    private String[] item_names;
    private String[] promo_details;
    private int[] image_array;
    private Context context;

    public PromotionListAdapter(MainActivity mainActivity, String [] items, String[] details, int[] images){
        context = mainActivity;
        item_names = items;
        promo_details = details;
        image_array = images;

    }

    public int getCount(){
        return 2;
    }

    public long getItemId(int position){
        return position;
    }

    public Object getItem(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.promotions_list_item, null);

        TextView itemText = (TextView) vi.findViewById(R.id.itemText);
        TextView detailsText = (TextView) vi.findViewById(R.id.promoDetails);
        ImageView productImage = (ImageView) vi.findViewById(R.id.productImage);

        itemText.setText(item_names[position]);
        detailsText.setText(promo_details[position]);
        productImage.setImageResource(image_array[position]);

        return vi;

    }
}

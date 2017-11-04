package com.example.safe.storegenie;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class MainActivity extends AppCompatActivity {

    private ImageView qrCodeView;
    Bitmap sampleImage;



    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first commit from ankith // sd
        qrCodeView = (ImageView) findViewById(R.id.qrView);


        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode("20144747", BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            sampleImage = barcodeEncoder.createBitmap(bitMatrix);
        }catch (Exception e){
            e.printStackTrace();
        }
        qrCodeView.setImageBitmap(sampleImage);



        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragment(selectedItem);


    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.menu_home:
                frag = MenuFragment.newInstance(getString(R.string.text_home),
                        getColorFromRes(R.color.color_home));
                break;
            case R.id.menu_notifications:
                frag = MenuFragment.newInstance(getString(R.string.text_notifications),
                        getColorFromRes(R.color.color_notifications));
                break;
            case R.id.menu_search:
                frag = MenuFragment.newInstance(getString(R.string.text_search),
                        getColorFromRes(R.color.color_search));
                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        updateToolbarText(item.getTitle());

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }
}

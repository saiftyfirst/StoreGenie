package com.example.safe.storegenie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class MainActivity extends AppCompatActivity {

    private Button squeezeBtn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //first commit from ankith // sd // df
        squeezeBtn = (Button) findViewById(R.id.dummyBtn);
        squeezeBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(context, PromotionsActivity.class);
                startActivity(intent);
            }
        });

    }
}

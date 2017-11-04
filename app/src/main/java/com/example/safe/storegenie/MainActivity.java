package com.example.safe.storegenie;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class MainActivity extends AppCompatActivity {

    private ImageView qrCodeView;
    Bitmap sampleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first commit from ankith // sd // df
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
    }
}

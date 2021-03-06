package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.abts.database.DBHelperBuddhi;

import java.util.ArrayList;
import java.util.List;

public class shopCaps extends AppCompatActivity {
    public static final String Extra_Message1 ="com.mad.abts";
    public static final String Extra_Message2 ="com.mad.abts";
    public static final String Extra_Message3 ="com.mad.abts";
    String tv9, tv10, tv11, tv12;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    ImageView im1,im2,im3,im4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_caps);
        tv1 = findViewById(R.id.shpprdname1);
        tv2 = findViewById(R.id.shpprd1price);
        tv3 = findViewById(R.id.shpprdname2);
        tv4 = findViewById(R.id.shpprd2price);
        tv5 = findViewById(R.id.shpprdname3);
        tv6 = findViewById(R.id.shpprd3price);
        tv7 = findViewById(R.id.shpprdname4);
        tv8 = findViewById(R.id.shpprd4price);
        im1 = findViewById(R.id.shopprd1img);
        im2 = findViewById(R.id.shopprd2img);
        im3 = findViewById(R.id.shopprd3img);
        im4 = findViewById(R.id.shopprd4img);

        List pname = new ArrayList<>();
        List ppirce = new ArrayList<>();
        List pdesc = new ArrayList<>();
        List pimages = new ArrayList<>();

        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        pname=dbHelper.readProductUserCap1();
        ppirce=dbHelper.readProductUserCap2();
        pimages=dbHelper.readProductUserCap3();
        pdesc=dbHelper.readProductUserCap7();

        tv1.setText((String)pname.get(0));
        tv3.setText((String)pname.get(1));
        tv5.setText((String)pname.get(2));
        tv7.setText((String)pname.get(3));

        tv2.setText((String)ppirce.get(0) +".00");
        tv4.setText((String)ppirce.get(1) +".00");
        tv6.setText((String)ppirce.get(2) +".00");
        tv8.setText((String)ppirce.get(3) +".00");

        tv9 = (String) pdesc.get(0);
        tv10= (String) pdesc.get(1);
        tv11= (String) pdesc.get(2);
        tv12= (String) pdesc.get(3);

        byte[] img1 = (byte[])pimages.get(0);
        byte[] img2 = (byte[])pimages.get(1);
        byte[] img3 = (byte[])pimages.get(2);
        byte[] img4 = (byte[])pimages.get(3);

        Bitmap bitmap1 = BitmapFactory.decodeByteArray(img1,0,img1.length);
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(img2,0,img2.length);
        Bitmap bitmap3 = BitmapFactory.decodeByteArray(img3,0,img3.length);
        Bitmap bitmap4 = BitmapFactory.decodeByteArray(img4,0,img4.length);

        im1.setImageBitmap(bitmap1);
        im2.setImageBitmap(bitmap2);
        im3.setImageBitmap(bitmap3);
        im4.setImageBitmap(bitmap4);
    }
    public void matches(View view) {
        Intent intent = new Intent(this, matches.class);
        startActivity(intent);
    }
    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void shop(View view) {
        Intent intent = new Intent(this, shop.class);
        startActivity(intent);
    }
    public void teams(View view) {
        Intent intent = new Intent(this, teams.class);
        startActivity(intent);
    }
    public void sidebar(View view) {
        Intent intent = new Intent(this, sidebar.class);
        startActivity(intent);
    }

    public void GOTOCART(View view){
        Intent shopintent = new Intent(shopCaps.this, Cart.class);
        startActivity(shopintent);


    }    public void MyOrders(View view){
        Intent myordintent = new Intent(shopCaps.this, myorders.class);
        startActivity(myordintent);


    }  public void GoRight(View view){
        Intent gorightintent = new Intent(shopCaps.this, myorders.class);
        startActivity(gorightintent);


    }public void GoLeft(View view){
        Intent goleftintent = new Intent(shopCaps.this, shop.class);
        startActivity(goleftintent);
    }
    public void ProductDetails1(View view){
        Intent prddetintent = new Intent(shopCaps.this, productdetails.class);
        String value1 = tv1.getText().toString();
        String value2 = tv2.getText().toString();
        String value3 = tv9;
        prddetintent.putExtra("Extra_Message1",value1);
        prddetintent.putExtra("Extra_Message2",value2);
        prddetintent.putExtra("Extra_Message3",value3);
        startActivity(prddetintent);
    }
    public void ProductDetails2(View view){
        Intent prddetintent = new Intent(shopCaps.this, productdetails.class);
        String value1 = tv3.getText().toString();
        String value2 = tv4.getText().toString();
        String value3 = tv10;
        prddetintent.putExtra("Extra_Message1",value1);
        prddetintent.putExtra("Extra_Message2",value2);
        prddetintent.putExtra("Extra_Message3",value3);
        startActivity(prddetintent);
    }
    public void ProductDetails3(View view){
        Intent prddetintent = new Intent(shopCaps.this, productdetails.class);
        String value1 = tv5.getText().toString();
        String value2 = tv6.getText().toString();
        String value3 = tv11;
        prddetintent.putExtra("Extra_Message1",value1);
        prddetintent.putExtra("Extra_Message2",value2);
        prddetintent.putExtra("Extra_Message3",value3);
        startActivity(prddetintent);
    }
    public void ProductDetails4(View view){
        Intent prddetintent = new Intent(shopCaps.this, productdetails.class);
        String value1 = tv7.getText().toString();
        String value2 = tv8.getText().toString();
        String value3 = tv12;
        prddetintent.putExtra("Extra_Message1",value1);
        prddetintent.putExtra("Extra_Message2",value2);
        prddetintent.putExtra("Extra_Message3",value3);
        startActivity(prddetintent);
    }
}
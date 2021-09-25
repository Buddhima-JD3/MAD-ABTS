package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.abts.database.DBHelperBuddhi;

import java.util.ArrayList;
import java.util.List;

public class adminproduct1 extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    EditText tv5,tv6,tv7,tv8;
    String t1,t2,t3,t4,t5,t6,t7,t8;
    ImageView im1,im2,im3,im4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminproduct1);
        tv1 = findViewById(R.id.adminproducts1sh);
        tv2 = findViewById(R.id.adminproductsimg2sh);
        tv3 = findViewById(R.id.adminproductsimg3sh);
        tv4 = findViewById(R.id.productsimg1sh);
        tv5 = (EditText)findViewById(R.id.adminproduct1qty);
        tv6 = (EditText)findViewById(R.id.adminproduct2qty);
        tv7 = (EditText)findViewById(R.id.adminproduct3qty);
        tv8 = (EditText)findViewById(R.id.product1qty);
        im1 = findViewById(R.id.imageView1);
        im2 = findViewById(R.id.adminimageView2);
        im3 = findViewById(R.id.adminimageView3);
        im4 = findViewById(R.id.imageView2);

        List pname = new ArrayList<>();
        List pqty = new ArrayList<>();
        List pimages = new ArrayList<>();
        List ids = new ArrayList<>();

        List pname1 = new ArrayList<>();
        List pqty1 = new ArrayList<>();
        List pimages1 = new ArrayList<>();
        List idc = new ArrayList<>();

        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        pname=dbHelper.readProductUserShirt1();
        pqty=dbHelper.readProductUserShirt4();
        pimages=dbHelper.readProductUserShirt3();
        ids = dbHelper.readProductUserShirt5();

        pname1=dbHelper.readProductUserCap1();
        pqty1=dbHelper.readProductUserCap4();
        pimages1=dbHelper.readProductUserCap3();
        idc = dbHelper.readProductUserCap5();
        String x = (String) pname.get(1);
        if(x.isEmpty()){

        }else {
            tv1.setText((String) pname.get(0));
            tv2.setText((String) pname.get(1));
            tv3.setText((String) pname1.get(0));
            tv4.setText((String) pname1.get(1));

            tv5.setText((String) pqty.get(0));
            tv6.setText((String) pqty.get(1));
            tv7.setText((String) pqty1.get(0));
            tv8.setText((String) pqty1.get(1));

            byte[] img1 = (byte[]) pimages.get(0);
            byte[] img2 = (byte[]) pimages.get(1);
            byte[] img3 = (byte[]) pimages1.get(0);
            byte[] img4 = (byte[]) pimages1.get(1);

            Bitmap bitmap1 = BitmapFactory.decodeByteArray(img1, 0, img1.length);
            Bitmap bitmap2 = BitmapFactory.decodeByteArray(img2, 0, img2.length);
            Bitmap bitmap3 = BitmapFactory.decodeByteArray(img3, 0, img3.length);
            Bitmap bitmap4 = BitmapFactory.decodeByteArray(img4, 0, img4.length);

            im1.setImageBitmap(bitmap1);
            im2.setImageBitmap(bitmap2);
            im3.setImageBitmap(bitmap3);
            im4.setImageBitmap(bitmap4);
        }

    }
    public void editQty1(View view){
        t5 = tv5.getText().toString();
        t6= tv6.getText().toString();
        t7= tv7.getText().toString();
        t8= tv8.getText().toString();
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List ids = new ArrayList<>();
        ids = dbHelper.readProductUserShirt5();
        dbHelper.updateProduct((int)ids.get(0),Integer.parseInt(t5));


    }
    public void editQty2(View view){
        t5 = tv5.getText().toString();
        t6= tv6.getText().toString();
        t7= tv7.getText().toString();
        t8= tv8.getText().toString();
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List ids = new ArrayList<>();
        ids = dbHelper.readProductUserShirt5();
        dbHelper.updateProduct((int)ids.get(1),Integer.parseInt(t6));


    }

    public void editQty3(View view){
        t5 = tv5.getText().toString();
        t6= tv6.getText().toString();
        t7= tv7.getText().toString();
        t8= tv8.getText().toString();
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List idc = new ArrayList<>();
        idc = dbHelper.readProductUserCap5();
        dbHelper.updateProduct((int)idc.get(0),Integer.parseInt(t7));


    }
    public void editQty4(View view){
        t5 = tv5.getText().toString();
        t6= tv6.getText().toString();
        t7= tv7.getText().toString();
        t8= tv8.getText().toString();
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List idc = new ArrayList<>();
        idc = dbHelper.readProductUserCap5();
        dbHelper.updateProduct((int)idc.get(1),Integer.parseInt(t8));


    }

    public void deleteProd1(View view){

        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List ids = new ArrayList<>();
        ids = dbHelper.readProductUserShirt5();
        dbHelper.deleteProduct((int)ids.get(0));


    }
    public void deleteProd2(View view){
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List ids = new ArrayList<>();
        ids = dbHelper.readProductUserShirt5();
        dbHelper.deleteProduct((int)ids.get(1));


    }

    public void deleteProd3(View view){
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List idc = new ArrayList<>();
        idc = dbHelper.readProductUserCap5();
        dbHelper.deleteProduct((int)idc.get(0));


    }
    public void deleteProd4(View view){
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        List idc = new ArrayList<>();
        idc = dbHelper.readProductUserCap5();
        dbHelper.deleteProduct((int)idc.get(1));


    }

    public void adminmatches(View view) {
        Intent intent = new Intent(this, adminmatches.class);
        startActivity(intent);
    }
    public void admin(View view) {
        Intent intent = new Intent(this, adminhome.class);
        startActivity(intent);
    }
    public void adminsidebar(View view) {
        Intent intent = new Intent(this, adminsidebar.class);
        startActivity(intent);
    }
    public void adminOrders(View view) {
        Intent ordintent = new Intent(this, adminOrders.class);
        startActivity(ordintent);
    }    public void addProduct(View view) {
        Intent ordintent = new Intent(this, addnewproduct.class);
        startActivity(ordintent);
    }
}
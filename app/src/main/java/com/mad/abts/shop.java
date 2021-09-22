package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
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
        Intent shopintent = new Intent(shop.this, Cart.class);
        startActivity(shopintent);


    }    public void MyOrders(View view){
        Intent myordintent = new Intent(shop.this, myorders.class);
        startActivity(myordintent);


    }  public void GoRight(View view){
        Intent gorightintent = new Intent(shop.this, shopCaps.class);
        startActivity(gorightintent);


    }public void GoLeft(View view){
        Intent goleftintent = new Intent(shop.this, myorders.class);
        startActivity(goleftintent);


    }
}

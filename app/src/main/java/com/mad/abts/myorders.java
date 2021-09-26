package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class myorders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);
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

    public void GoRight(View view){
        Intent gorightintent = new Intent(this, shop.class);
        startActivity(gorightintent);


    }public void GoLeft(View view){
        Intent goleftintent = new Intent(this, shopCaps.class);
        startActivity(goleftintent);
   }
    public void shopcap(View view) {
        Intent intent = new Intent(this, shopCaps.class);
        startActivity(intent);
    }
}
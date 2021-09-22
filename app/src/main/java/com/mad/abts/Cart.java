package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }
    public void PayNow(View view){
        Intent payintent = new Intent(Cart.this, paymentdetails.class);
        startActivity(payintent);
    }
}
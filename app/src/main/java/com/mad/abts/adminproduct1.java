package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminproduct1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminproduct1);
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
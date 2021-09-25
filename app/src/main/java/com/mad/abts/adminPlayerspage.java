package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminPlayerspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_playerspage);
    }

    public void adminplayerprofile(View view) {
        Intent intent = new Intent(this, adminPlayerspage.class);
        startActivity(intent);
    }

    public void adminPlayerspage(View view) {
        Intent intent = new Intent(this, adminPlayerspage.class);
        startActivity(intent);
    }

    public void adminmatches(View view) {
        Intent intent = new Intent(this, adminmatches.class);
        startActivity(intent);
    }
    public void adminlive(View view) {
        Intent intent = new Intent(this, adminlive.class);
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
        Intent intent = new Intent(this, adminOrders.class);
        startActivity(intent);
    }
}
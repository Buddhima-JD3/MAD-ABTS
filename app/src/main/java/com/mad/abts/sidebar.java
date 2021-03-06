package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sidebar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar);
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
    public void players(View view) {
        Intent intent = new Intent(this, playerpage.class);
        startActivity(intent);
    }
    public void gallery(View view) {
        Intent intent = new Intent(this, gallery.class);
        startActivity(intent);
    }
    public void statistics(View view) {
        Intent intent = new Intent(this, statistics.class);
        startActivity(intent);
    }
    public void venues(View view) {
        Intent intent = new Intent(this, teams3.class);
        startActivity(intent);
    }
    public void admin(View view) {
        Intent intent = new Intent(this, adminhome.class);
        startActivity(intent);
    }
    public void createacc(View view) {
        Intent intent = new Intent(this, createaccount.class);
        startActivity(intent);
    }
    public void login(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
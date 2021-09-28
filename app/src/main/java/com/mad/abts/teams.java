package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mad.abts.database.DBHelper;
import com.mad.abts.database.DBHelperSenara;

import java.util.ArrayList;
import java.util.List;

public class teams extends AppCompatActivity {
    TextView as1,as2,as3,as4,as5;
    ImageView ig1,ig2,ig3,ig4,ig5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

    }
    public void team1(View view) {
        Intent sendIntent = new Intent(this, team2.class);
        sendIntent.putExtra("Extra", "Colombo Kings");
        startActivity(sendIntent);
        as1 = findViewById(R.id.teamname1);
        as2 = findViewById(R.id.teamname4);
        as3 = findViewById(R.id.teamname3);
        as4 = findViewById(R.id.teamname2);
        as5 = findViewById(R.id.teamname5);
        ig1 = findViewById(R.id.teamlogo1);
        ig2 = findViewById(R.id.teamlogo4);
        ig3 = findViewById(R.id.teamlogo3);
        ig4 = findViewById(R.id.teamlogo2);
        ig5 = findViewById(R.id.teamlogo5);

        List mnlogo = new ArrayList<>();
        List mnteam = new ArrayList<>();
        List mncaptain = new ArrayList<>();

        DBHelperSenara dbHelper = new DBHelperSenara(this);
        mnlogo = dbHelper.readTeams1();
        mnteam = dbHelper.readTeams2();
        mncaptain = dbHelper.readTeams3();

        byte[] img1 = (byte[])mnlogo.get(0);
        byte[] img2 = (byte[])mnlogo.get(1);
        byte[] img3 = (byte[])mnlogo.get(2);
        byte[] img4 = (byte[])mnlogo.get(3);
        byte[] img5 = (byte[])mnlogo.get(4);

        Bitmap bitmap1 = BitmapFactory.decodeByteArray(img1,0,img1.length);
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(img2,0,img2.length);
        Bitmap bitmap3 = BitmapFactory.decodeByteArray(img3,0,img3.length);
        Bitmap bitmap4 = BitmapFactory.decodeByteArray(img4,0,img4.length);
        Bitmap bitmap5 = BitmapFactory.decodeByteArray(img5,0,img5.length);

        ig1.setImageBitmap(bitmap1);
        ig2.setImageBitmap(bitmap2);
        ig3.setImageBitmap(bitmap3);
        ig4.setImageBitmap(bitmap4);
        ig5.setImageBitmap(bitmap5);

        as1.setText((String)mnteam.get(0));
        as2.setText((String)mnteam.get(1));
        as3.setText((String)mnteam.get(2));
        as4.setText((String)mnteam.get(3));
        as5.setText((String)mnteam.get(4));
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
}
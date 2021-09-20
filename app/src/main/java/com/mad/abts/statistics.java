package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mad.abts.database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class statistics extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    TextView tm1,tm2,tm3,tm4,tm5;
    TextView tw1,tw2,tw3,tw4,tw5;
    TextView tl1,tl2,tl3,tl4,tl5;
    TextView tn1,tn2,tn3,tn4,tn5;
    TextView tp1,tp2,tp3,tp4,tp5;
    TextView twp1,twp2,twp3,twp4,twp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        tv1 = findViewById(R.id.team1s);
        tv2 = findViewById(R.id.team2s);
        tv3 = findViewById(R.id.team3s);
        tv4 = findViewById(R.id.team4s);
        tv5 = findViewById(R.id.team5s);
        tm1 = findViewById(R.id.team1m);
        tm2 = findViewById(R.id.team2m);
        tm3 = findViewById(R.id.team3m);
        tm4 = findViewById(R.id.team4m);
        tm5 = findViewById(R.id.team5m);
        tw1 = findViewById(R.id.team1w);
        tw2 = findViewById(R.id.team2w);
        tw3 = findViewById(R.id.team3w);
        tw4 = findViewById(R.id.team4w);
        tw5 = findViewById(R.id.team5w);
        tl1 = findViewById(R.id.team1l);
        tl2 = findViewById(R.id.team2l);
        tl3 = findViewById(R.id.team3l);
        tl4 = findViewById(R.id.team4l);
        tl5 = findViewById(R.id.team5lost);
        tn1 = findViewById(R.id.team1nr);
        tn2 = findViewById(R.id.team2nr);
        tn3 = findViewById(R.id.team3nr);
        tn4 = findViewById(R.id.team4nr);
        tn5 = findViewById(R.id.team5nr);
        tp1 = findViewById(R.id.team1p);
        tp2 = findViewById(R.id.team2p);
        tp3 = findViewById(R.id.team3p);
        tp4 = findViewById(R.id.team4p);
        tp5 = findViewById(R.id.team5p);
        twp1 = findViewById(R.id.team1nrr);
        twp2 = findViewById(R.id.team2nrr);
        twp3 = findViewById(R.id.team3nrr);
        twp4 = findViewById(R.id.team4nrr);
        twp5 = findViewById(R.id.team5nrr);
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        DBHelper dbHelper =  new DBHelper(this);
        teams=dbHelper.readStats1();
        tv1.setText((String)teams.get(0));
        tv2.setText((String)teams.get(1));
        tv3.setText((String)teams.get(2));
        tv4.setText((String)teams.get(3));
        tv5.setText((String)teams.get(4));

        System.out.println(teams);

        matches=dbHelper.readStats2();
        tm1.setText((String)matches.get(0));
        tm2.setText((String)matches.get(1));
        tm3.setText((String)matches.get(2));
        tm4.setText((String)matches.get(3));
        tm5.setText((String)matches.get(4));

        System.out.println(matches);

        wons=dbHelper.readStats3();
        tw1.setText((String)wons.get(0));
        tw2.setText((String)wons.get(1));
        tw3.setText((String)wons.get(2));
        tw4.setText((String)wons.get(3));
        tw5.setText((String)wons.get(4));

        System.out.println(wons);
        losts=dbHelper.readStats4();
        tl1.setText((String)losts.get(0));
        tl2.setText((String)losts.get(1));
        tl3.setText((String)losts.get(2));
        tl4.setText((String)losts.get(3));
        tl5.setText((String)losts.get(4));

        System.out.println(losts);
        nrs=dbHelper.readStats5();
        tn1.setText((String)nrs.get(0));
        tn2.setText((String)nrs.get(1));
        tn3.setText((String)nrs.get(2));
        tn4.setText((String)nrs.get(3));
        tn5.setText((String)nrs.get(4));

        System.out.println(nrs);
        points=dbHelper.readStats6();
        tp1.setText((String)points.get(0));
        tp2.setText((String)points.get(1));
        tp3.setText((String)points.get(2));
        tp4.setText((String)points.get(3));
        tp5.setText((String)points.get(4));

        System.out.println(points);
        winpercs=dbHelper.readStats7();
        twp1.setText((String)winpercs.get(0));
        twp2.setText((String)winpercs.get(1));
        twp3.setText((String)winpercs.get(2));
        twp4.setText((String)winpercs.get(3));
        twp5.setText((String)winpercs.get(4));

        System.out.println(winpercs);
    }
    public void readTeamStats(View view){

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
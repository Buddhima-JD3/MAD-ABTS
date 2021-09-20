package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mad.abts.database.DBHelper;

import static java.lang.String.valueOf;

public class teamstats extends AppCompatActivity {
    EditText team,matches,won,lost,nr;
    String team1;
    int matches1,won1,lost1,nr1,points;
    double winperce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamstats);
        team = findViewById(R.id.inteamstats);
        matches= findViewById(R.id.teammatchin);
        won= findViewById(R.id.teamwonenter);
        lost= findViewById(R.id.teamlost1);
        nr= findViewById(R.id.teamnorenter);
    }
    public void saveStats(View view){
        team1 = team.getText().toString();
        matches1 = Integer.parseInt(matches.getText().toString());
        won1 = Integer.parseInt(won.getText().toString());
        lost1 = Integer.parseInt(lost.getText().toString());
        nr1 = Integer.parseInt(nr.getText().toString());
        points = 2*won1+nr1;
        System.out.println(points);
        winperce= (won1*100)/matches1;
        DBHelper dbHelper =  new DBHelper(this);
        if(team1.isEmpty()){
            System.out.println("team");
            Toast.makeText(this,"Enter Team", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addMatchStats(team1,matches1,won1,lost1,nr1,points,winperce);
        }
    }
    public void updateStats(View view){
        team1 = team.getText().toString();
        matches1 = Integer.parseInt(matches.getText().toString());
        won1 = Integer.parseInt(won.getText().toString());
        lost1 = Integer.parseInt(lost.getText().toString());
        nr1 = Integer.parseInt(nr.getText().toString());
        points = 2*won1+nr1;
        System.out.println(points);
        winperce= (won1*100)/matches1;
        DBHelper dbHelper =  new DBHelper(this);
        dbHelper.updateStats(team1,matches1,won1,lost1,nr1,points,winperce);

    }
    public void deleteStats(View view){
        team1 = team.getText().toString();

        DBHelper dbHelper =  new DBHelper(this);
        dbHelper.deleteStats(team1);

    }
    public void adminmatches(View view) {
        Intent intent = new Intent(this, adminmatches.class);
        startActivity(intent);
    }
    public void sidebar(View view) {
        Intent intent = new Intent(this, adminsidebar.class);
        startActivity(intent);
    }


    public void adminstatistics(View view) {
        Intent intent = new Intent(this, teamstats.class);
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
}
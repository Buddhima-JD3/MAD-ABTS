package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mad.abts.database.DBHelper;

public class adminmatches extends AppCompatActivity {
    EditText team1,team2,matchno,matchdate;
    String team11,team22,date;
    int matchno1,runs1,runs2,wickets1,wickets2;
    double overs1,overs2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmatches);
        team1 = findViewById(R.id.inteam1);
        team2= findViewById(R.id.inteam2);
        matchno= findViewById(R.id.matchnoin1);
        matchdate= findViewById(R.id.inmatchdate);

    }
    public void saveMatch(View view){
        team11 = team1.getText().toString();
        team22 = team2.getText().toString();
        matchno1 = Integer.parseInt(matchno.getText().toString());
        date = matchdate.getText().toString();
        runs1 = 0;
        runs2 = 0;
        wickets1 = 0;
        wickets2 = 0;
        overs1 = 0;
        overs2 = 0;
        DBHelper dbHelper =  new DBHelper(this);
        if(team11.isEmpty()||team22.isEmpty()){
            Toast.makeText(this,"Enter Teams", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addMatch(team11,team22,matchno1,date,runs1,runs2,wickets1,wickets2,overs1,overs2);
        }
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
}
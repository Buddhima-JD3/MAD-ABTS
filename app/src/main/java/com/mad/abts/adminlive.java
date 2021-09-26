package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mad.abts.database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class adminlive extends AppCompatActivity {
    EditText runs1,runs2,wickets1,wickets2,overs1,overs2,matchno,batting1,batting2;
    TextView t1,t2;
    String team11,team22,date,batting11,batting22;
    int matchno1,runs11,runs22,wickets11,wickets22;
    double overs11,overs22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlive2);
        matchno= findViewById(R.id.matchnoin);
        runs1= findViewById(R.id.runsin3);
        runs2= findViewById(R.id.runsin2);
        wickets1= findViewById(R.id.wicketsin1);
        wickets2= findViewById(R.id.wicketsin2);
        overs1= findViewById(R.id.oversin1);
        overs2= findViewById(R.id.oversin2);
        batting1 = findViewById(R.id.batin1i);
        batting2 = findViewById(R.id.batini);
        t1 = findViewById(R.id.team1live);
        t2 = findViewById(R.id.team2live);
    }
    public void deleteMatch(View view){
        matchno1 = Integer.parseInt(matchno.getText().toString());

        DBHelper dbHelper =  new DBHelper(this);
        dbHelper.deleteMatch(matchno1);
        Toast.makeText(this,"Deleted", Toast.LENGTH_SHORT).show();

    }
    public void editMatch(View view){
        matchno1 = Integer.parseInt(matchno.getText().toString());
        List teams1 = new ArrayList<>();
        List teams2 = new ArrayList<>();
        DBHelper dbHelper =  new DBHelper(this);
        teams1=dbHelper.readspecMatch(matchno1);
        t1.setText((String)teams1.get(0));
        teams2=dbHelper.readspecMatch2(matchno1);
        t2.setText((String)teams2.get(0));
    }
    public void updateMatch(View view){
        matchno1 = Integer.parseInt(matchno.getText().toString());
        runs11 = Integer.parseInt(runs1.getText().toString());
        runs22 = Integer.parseInt(runs2.getText().toString());
        wickets11 = Integer.parseInt(wickets1.getText().toString());
        wickets22 = Integer.parseInt(wickets2.getText().toString());
        overs11 = Double.parseDouble(overs1.getText().toString());
        overs22 = Double.parseDouble(overs2.getText().toString());
        batting11 = batting1.getText().toString();
        batting22 = batting2.getText().toString();

        DBHelper dbHelper =  new DBHelper(this);
        if(String.valueOf(matchno1).isEmpty()){
            Toast.makeText(this,"Enter Match Number", Toast.LENGTH_SHORT).show();
        }else{
            if(batting11.isEmpty()){
                dbHelper.updateMatch(matchno1,"team2",runs11,runs22,wickets11,wickets22,overs11,overs22);
                Toast.makeText(this,"Updated", Toast.LENGTH_SHORT).show();
            }else{
                dbHelper.updateMatch(matchno1,"team1",runs11,runs22,wickets11,wickets22,overs11,overs22);
                Toast.makeText(this,"Updated", Toast.LENGTH_SHORT).show();
            }

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
    public void adminOrders(View view) {
        Intent ordintent = new Intent(this, adminOrders.class);
        startActivity(ordintent);
    }
}
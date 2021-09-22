package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class createaccount extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    String s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        et1 = findViewById(R.id.fullnameinput2);
        et2 = findViewById(R.id.emailin);
        et3 = findViewById(R.id.passwordin);
        et4 = findViewById(R.id.confirmpasswordin);
    }
    public void savedata(View view){
        s1 = et1.getText().toString();
        s2 = et2.getText().toString();
        s3 = et3.getText().toString();
        s4 = et4.getText().toString();
        if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty()){
            System.out.println("aaa");
            Toast.makeText(this,"Enter All Fields", Toast.LENGTH_SHORT).show();
        }else{
            if(s3.equals(s4)){
                Toast.makeText(this,"Registered!", Toast.LENGTH_SHORT).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
            }else{
                Toast.makeText(this,"Passwords not matching", Toast.LENGTH_SHORT).show();
                et3.setText("");
                et4.setText("");
            }
        }
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
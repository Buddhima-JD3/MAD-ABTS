package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class addnewproduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewproduct);
    }

    public void adminOrders(View view) {
        Intent ordintent = new Intent(this, adminproduct1.class);
        startActivity(ordintent);
        ShowToast st = new ShowToast(getApplicationContext(), "Product Uploaded Successfully");
    }

    public class ShowToast {
        public ShowToast(Context context, String info) {
            Toast toast = Toast.makeText(context, Html.fromHtml("<font color='#000000' ><b>" + info + "</b></font>"), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }
}
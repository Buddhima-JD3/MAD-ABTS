package com.mad.abts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class matches extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    TextView v1,v2,v3,v4,v5,v6,v7,v8;
    ImageView im1,im2,im3,im4,im5,im6;
    PieChart pieChart;
    PieChart pieChart2;
    PieChart pieChart3;
    PieData pieData;
    PieData pieData2;
    PieData pieData3;
    int a,b,c,d,e,f;
    String [] dates = {};
    List<PieEntry> pieEntryList = new ArrayList<>();
    List<PieEntry> pieEntryList2 = new ArrayList<>();
    List<PieEntry> pieEntryList3 = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);
        tv1 = findViewById(R.id.matchheading1);
        tv2 = findViewById(R.id.status);
        tv3 = findViewById(R.id.team1);
        tv4 = findViewById(R.id.team4);
        tv5 = findViewById(R.id.score);
        tv6 = findViewById(R.id.score2);
        tv7 = findViewById(R.id.overs);
        tv8 = findViewById(R.id.overs2);
        t1 = findViewById(R.id.matchheading);
        t2 = findViewById(R.id.status2);
        t3 = findViewById(R.id.team11);
        t4 = findViewById(R.id.team22);
        t5 = findViewById(R.id.score12);
        t6 = findViewById(R.id.score22);
        t7 = findViewById(R.id.overs21);
        t8 = findViewById(R.id.overs22);
        im1 = findViewById(R.id.team1img);
        im2 = findViewById(R.id.img2team);
        im3 = findViewById(R.id.team11img);
        im4 = findViewById(R.id.team22img);
        v1 = findViewById(R.id.matchheading3);
        v2 = findViewById(R.id.status3);
        v3 = findViewById(R.id.team13);
        v4 = findViewById(R.id.team5);
        v5 = findViewById(R.id.score3);
        v6 = findViewById(R.id.score23);
        v7 = findViewById(R.id.overs3);
        v8 = findViewById(R.id.overs23);
        im5 = findViewById(R.id.team1img3);
        im6 = findViewById(R.id.img2team5);
        List team1 = new ArrayList<>();
        List team2 = new ArrayList<>();
        List matchnu = new ArrayList<>();
        List bat = new ArrayList<>();
        List runs1 = new ArrayList<>();
        List runs2 = new ArrayList<>();
        List wickets1 = new ArrayList<>();
        List wickets2 = new ArrayList<>();
        List overs1 = new ArrayList<>();
        List overs2 = new ArrayList<>();
        List lg1 = new ArrayList<>();
        List lg2 = new ArrayList<>();
        List date = new ArrayList<>();


        DBHelper dbHelper =  new DBHelper(this);
        team1=dbHelper.readMatch1();
        team2=dbHelper.readMatch2();
        matchnu=dbHelper.readMatch3();
        bat=dbHelper.readMatch4();
        runs1=dbHelper.readMatch5();
        runs2=dbHelper.readMatch6();
        wickets1=dbHelper.readMatch7();
        wickets2=dbHelper.readMatch8();
        overs1=dbHelper.readMatch9();
        overs2=dbHelper.readMatch10();
        lg1=dbHelper.readMatch11();
        lg2=dbHelper.readMatch12();
        date=dbHelper.readMatch13();

        LocalDate day = LocalDate.now(); // Create a date object
        System.out.println(day);
        String dayt = ""+day;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        for(int jj = 0; jj < date.size(); jj++){
            if(dayt.equals((String)date.get(jj))){
                System.out.println("1");
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.r_premadasa) //set icon for notification
                                .setContentTitle("Notifications Example") //set title of notification
                                .setContentText("This is a notification message")//this is notification message
                                .setAutoCancel(true) // makes auto cancel of notification
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification


                Intent notificationIntent = new Intent(this, activity_notification_view.class);
                notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //notification message will get at NotificationView
                notificationIntent.putExtra("message", "This is a notification message");

                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
                AlertDialog alertDialog = new AlertDialog.Builder(matches.this).create();
                alertDialog.setTitle("Live Match!!!");
                alertDialog.setMessage("Match No - "+(String)matchnu.get(jj)+" \n"+(String)team1.get(jj)+" vs "+(String)team2.get(jj));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }


                        });
                alertDialog.show();
            }
        }

        byte[] img1 = (byte[])lg1.get(0);
        byte[] img2 = (byte[])lg2.get(0);
        byte[] img3 = (byte[])lg1.get(1);
        byte[] img4 = (byte[])lg2.get(1);
        byte[] img5 = (byte[])lg1.get(2);
        byte[] img6 = (byte[])lg2.get(2);
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(img1,0,img1.length);
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(img2,0,img2.length);
        Bitmap bitmap3 = BitmapFactory.decodeByteArray(img3,0,img3.length);
        Bitmap bitmap4 = BitmapFactory.decodeByteArray(img4,0,img4.length);
        Bitmap bitmap5 = BitmapFactory.decodeByteArray(img5,0,img5.length);
        Bitmap bitmap6 = BitmapFactory.decodeByteArray(img6,0,img6.length);
        im1.setImageBitmap(bitmap1);
        im2.setImageBitmap(bitmap2);
        im3.setImageBitmap(bitmap3);
        im4.setImageBitmap(bitmap4);
        im5.setImageBitmap(bitmap5);
        im6.setImageBitmap(bitmap6);
        tv1.setText("Match "+(String)matchnu.get(0));
        tv3.setText((String)team1.get(0));
        tv4.setText((String)team2.get(0));
        tv5.setText((String)runs1.get(0)+"/"+(String)wickets1.get(0));
        tv6.setText((String)runs2.get(0)+"/"+(String)wickets2.get(0));
        tv7.setText((String)overs1.get(0)+" Ov");
        tv8.setText((String)overs2.get(0)+" Ov");
        if(((String)bat.get(0)).equalsIgnoreCase("team1") && ((String) overs2.get(0)).equalsIgnoreCase("0")){
            tv2.setText((String)team1.get(0)+" Batting First");
            a=50;
            b=50;
        }else if(((String)bat.get(0)).equalsIgnoreCase("team2") && ((String) overs1.get(0)).equalsIgnoreCase("0")){
            tv2.setText((String)team2.get(0)+" Batting First");
            b=50;
            a=50;
        }else if(((String) bat.get(0)).equalsIgnoreCase("team1")&& !((String) overs2.get(0)).equalsIgnoreCase("0")){
            tv2.setText((String)team1.get(0)+" need "+String.valueOf(Integer.parseInt((String)runs2.get(0))-Integer.parseInt((String)runs1.get(0)))+" to win in "+String.valueOf(20-Integer.parseInt((String)overs1.get(0)))+" Overs");
            a=Integer.parseInt((String)runs2.get(0))-Integer.parseInt((String)runs1.get(0));
            int w2 = 10 -Integer.parseInt((String)wickets1.get(0));
            if(a > 100){
                a = winchance1(a,w2);
                if(a>100){
                    a = 99;
                }
                b = 100-a;
            }else{
                a =  winchance2(a,w2);
                if(b<0){
                    a = 1;
                }else if(b > 100){
                    b = 99;
                }
                b = 100-a;
            }
        }else if(((String)bat.get(0)).equalsIgnoreCase("team2") && !((String) overs1.get(0)).equalsIgnoreCase("0")){
            tv2.setText((String)team2.get(0)+" need "+String.valueOf(Integer.parseInt((String)runs1.get(0))-Integer.parseInt((String)runs2.get(0)))+" to win in "+String.valueOf(20-Integer.parseInt((String)overs2.get(0)))+" Overs");
            b=Integer.parseInt((String)runs1.get(0))-Integer.parseInt((String)runs2.get(0));
            int w2 = 10 -Integer.parseInt((String)wickets2.get(0));
            if(b > 100){
                b = winchance1(b,w2);
                if(b>100){
                    b = 99;
                }
                a = 100-b;
            }else{
                b =  winchance2(b,w2);
                if(b<0){
                    b = 1;
                }else if(b > 100){
                    b = 99;
                }
                a = 100-b;
            }
        }else{
            tv2.setText("Match Over");
        }
        v1.setText("Match "+(String)matchnu.get(2));
        v3.setText((String)team1.get(2));
        v4.setText((String)team2.get(2));
        v5.setText((String)runs1.get(2)+"/"+(String)wickets1.get(2));
        v6.setText((String)runs2.get(2)+"/"+(String)wickets2.get(2));
        v7.setText((String)overs1.get(2)+" Ov");
        v8.setText((String)overs2.get(2)+" Ov");
        if(((String)bat.get(2)).equalsIgnoreCase("team1") && ((String) overs2.get(2)).equalsIgnoreCase("0")){
            v2.setText((String)team1.get(2)+" Batting First");
            e=50;
            f=50;
        }else if(((String)bat.get(2)).equalsIgnoreCase("team2") && ((String) overs1.get(2)).equalsIgnoreCase("0")){
            v2.setText((String)team2.get(2)+" Batting First");
            e=50;
            f=50;
        }else if(((String) bat.get(2)).equalsIgnoreCase("team1")&& !((String) overs2.get(2)).equalsIgnoreCase("0")){
            v2.setText((String)team1.get(2)+" need "+String.valueOf(Integer.parseInt((String)runs2.get(2))-Integer.parseInt((String)runs1.get(2)))+" to win in "+String.valueOf(20-Integer.parseInt((String)overs1.get(2)))+" Overs");
            e=Integer.parseInt((String)runs2.get(2))-Integer.parseInt((String)runs1.get(2));
            int w1 = 10 -Integer.parseInt((String)wickets1.get(2));
            if(e > 100){
                e = winchance1(e,w1);
                if(e>100){
                    e = 99;
                }
                f = 100-e;
            }else{
                e =winchance2(e,w1);
                if(e<0){
                    e = 1;
                }else if(e > 100){
                    e = 99;
                }
                f = 100-f;
            }
        }else if(((String)bat.get(2)).equalsIgnoreCase("team2") && !((String) overs1.get(2)).equalsIgnoreCase("0")){
            v2.setText((String)team2.get(2)+" need "+String.valueOf(Integer.parseInt((String)runs1.get(2))-Integer.parseInt((String)runs2.get(2)))+" to win in "+String.valueOf(20-Integer.parseInt((String)overs2.get(2)))+" Overs");
            f=Integer.parseInt((String)runs1.get(2))-Integer.parseInt((String)runs2.get(2));
            int w1 = 10 -Integer.parseInt((String)wickets2.get(2));
            if(f > 100){
                f = winchance1(f,w1);
                if(f>100){
                    f = 99;
                }
                e = 100-f;
            }else{
                f =  winchance2(f,w1);
                if(f<0){
                    f = 1;
                }else if(f > 100){
                    f = 99;
                }
                e = 100-f;
            }
        }else{
            v2.setText("Match Over");
        }
        pieChart = findViewById(R.id.piepercentage);
        pieChart.setUsePercentValues(true);
        pieEntryList.add(new PieEntry(a,(String)team1.get(0)));
        pieEntryList.add(new PieEntry(b,(String)team2.get(0)));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Team");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setHoleRadius(18);
        pieChart.getDescription().setText("Team");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
        t1.setText("Match "+(String)matchnu.get(1));
        t3.setText((String)team1.get(1));
        t4.setText((String)team2.get(1));
        t5.setText((String)runs1.get(1)+"/"+(String)wickets1.get(1));
        t6.setText((String)runs2.get(1)+"/"+(String)wickets2.get(1));
        t7.setText((String)overs1.get(1)+" Ov");
        t8.setText((String)overs2.get(1)+" Ov");
        if(((String)bat.get(1)).equalsIgnoreCase("team1") && ((String) overs2.get(1)).equalsIgnoreCase("0")){
            t2.setText((String)team1.get(1)+" Batting First");
            c=50;
            d=50;
        }else if(((String)bat.get(1)).equalsIgnoreCase("team2") && ((String) overs1.get(1)).equalsIgnoreCase("0")){
            t2.setText((String)team2.get(1)+" Batting First");
            c=50;
            d=50;
        }else if(((String) bat.get(1)).equalsIgnoreCase("team1")&& !((String) overs2.get(1)).equalsIgnoreCase("0")){
            t2.setText((String)team1.get(1)+" need "+String.valueOf(Integer.parseInt((String)runs2.get(1))-Integer.parseInt((String)runs1.get(1)))+" to win in "+String.valueOf(20-Integer.parseInt((String)overs1.get(1)))+" Overs");
            c=Integer.parseInt((String)runs2.get(1))-Integer.parseInt((String)runs1.get(1));
            int w = 10 -Integer.parseInt((String)wickets1.get(1));
            if(c > 100){
                c = winchance1(c,w);
                if(c >100){
                    c = 99;
                }
               d = 100-c;
            }else{
                c = winchance2(c,w);
                if(c<0){
                    c = 1;
                }else if(c > 100){
                    c = 99;
                }
                d = 100-c;
            }
        }else if(((String)bat.get(1)).equalsIgnoreCase("team2") && !((String) overs1.get(1)).equalsIgnoreCase("0")){
            t2.setText((String)team2.get(1)+" need "+String.valueOf(Integer.parseInt((String)runs1.get(1))-Integer.parseInt((String)runs2.get(1)))+" to win in "+String.valueOf(20-Integer.parseInt((String)overs2.get(1)))+" Overs");
            d=Integer.parseInt((String)runs1.get(1))-Integer.parseInt((String)runs2.get(1));
            int w = 10 -Integer.parseInt((String)wickets2.get(1));
            if(d > 100){
               d = winchance1(d,w);
               if(d >100){
                   d = 99;
               }
                c = 100-d;
            }else{
                d =  winchance2(d,w);
                if(d<0){
                    d = 1;
                }else if(d > 100){
                    d = 99;
                }
                c = 100-d;
            }
        }else{
            t2.setText("Match Over");
        }
        pieChart2 = findViewById(R.id.piepercentage2);
        pieChart2.setUsePercentValues(true);
        pieEntryList2.add(new PieEntry(c,(String)team1.get(1)));
        pieEntryList2.add(new PieEntry(d,(String)team2.get(1)));
        PieDataSet pieDataSet2 = new PieDataSet(pieEntryList2,"Team");
        pieDataSet2.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart2.setHoleRadius(18);
        pieChart2.getDescription().setText("Team");
        pieData2 = new PieData(pieDataSet2);
        pieChart2.setData(pieData2);
        pieChart2.invalidate();

        pieChart3 = findViewById(R.id.piepercentage3);
        pieChart3.setUsePercentValues(true);
        pieEntryList3.add(new PieEntry(e,(String)team1.get(2)));
        pieEntryList3.add(new PieEntry(f,(String)team2.get(2)));
        PieDataSet pieDataSet3 = new PieDataSet(pieEntryList3,"Team");
        pieDataSet3.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart3.setHoleRadius(18);
        pieChart3.getDescription().setText("Team");
        pieData3 = new PieData(pieDataSet3);
        pieChart3.setData(pieData3);
        pieChart3.invalidate();
        System.out.println(team1);

    }
    public int winchance1(int a, int b){

        return (((a-100)*100)/100)+(b*3);
    }
    public int winchance2(int a, int b){

        return (120-((a*100)/100))-((10-b)*3);
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

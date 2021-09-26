package com.mad.abts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBHelperSenara extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "SenLPLT20.db";
    public ByteArrayOutputStream ba,ba2;
    public byte[] lg1,lg2;
    public DBHelperSenara(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE "+AllTeams.Teams.TABLE_NAME+
                " ("+AllTeams.Teams._ID+" INTEGER PRIMARY KEY,"+
                AllTeams.Teams.COLUMN_NAME_LOGO+" BLOB,"+
                AllTeams.Teams.COLUMN_NAME_TEAM+" TEXT,"+
                AllTeams.Teams.COLUMN_NAME_CAPTAIN+" TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
/*
        db.execSQL("CREATE TABLE "+AllVenues.Venues.TABLE_NAME+
                " ("+AllVenues.Venues._ID+" INTEGER PRIMARY KEY,"+
                AllVenues.Venues.COLUMN_NAME_VENPIC1+" BLOB,"+
                AllVenues.Venues.COLUMN_NAME_VENNAME1+" TEXT,"+
                AllVenues.Venues.COLUMN_NAME_VENPIC2+" BLOB,"+
                AllVenues.Venues.COLUMN_NAME_VENNAME2+" TEXT,"+
                AllVenues.Venues.COLUMN_NAME_VENPIC3+" BLOB,"+
                AllVenues.Venues.COLUMN_NAME_VENNAME3+" TEXT,"+
                AllVenues.Venues.COLUMN_NAME_VENPIC4+" BLOB,"+
                AllVenues.Venues.COLUMN_NAME_VENNAME4+" TEXT,"+
                AllVenues.Venues.COLUMN_NAME_VENPIC5+" BLOB,"+
                AllVenues.Venues.COLUMN_NAME_VENNAME5+" TEXT)"
        );
*/
        db.execSQL("CREATE TABLE "+TeamStatistics.TeamStat.TABLE_NAME+
                " ("+TeamStatistics.TeamStat._ID+" INTEGER PRIMARY KEY,"+
                //TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO+" BLOB,"+
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME+" TEXT,"+
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL+" INTEGER,"+
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL+" INTEGER,"+
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS+" INTEGER,"+
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS+" INTEGER,"+
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME+" TEXT,"+
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE+" INTEGER)"
        );


    }

    public Long addTeams(byte[] logo, String team, String captain){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllTeams.Teams.COLUMN_NAME_LOGO,logo);
        values.put(AllTeams.Teams.COLUMN_NAME_TEAM, team);
        values.put(AllTeams.Teams.COLUMN_NAME_CAPTAIN, captain);

        return db.insert(AllTeams.Teams.TABLE_NAME, null, values);

    }

    public Long addVenues(byte[] venpic1, String venname1, byte[] venpic2, String venname2, byte[] venpic3, String venname3, byte[] venpic4, String venname4, byte[] venpic5, String venname5){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllVenues.Venues.COLUMN_NAME_VENPIC1, venpic1);
        values.put(AllVenues.Venues.COLUMN_NAME_VENNAME1, venname1);
        values.put(AllVenues.Venues.COLUMN_NAME_VENPIC2, venpic2);
        values.put(AllVenues.Venues.COLUMN_NAME_VENNAME2, venname2);
        values.put(AllVenues.Venues.COLUMN_NAME_VENPIC3, venpic3);
        values.put(AllVenues.Venues.COLUMN_NAME_VENNAME3, venname3);
        values.put(AllVenues.Venues.COLUMN_NAME_VENPIC4, venpic4);
        values.put(AllVenues.Venues.COLUMN_NAME_VENNAME4, venname4);
        values.put(AllVenues.Venues.COLUMN_NAME_VENPIC5, venpic5);
        values.put(AllVenues.Venues.COLUMN_NAME_VENNAME5, venname5);

        return db.insert(AllVenues.Venues.TABLE_NAME, null, values);

    }

    public Long addTeamStat(String teamname, int highesttotal, int lowesttotal, int mostruns, int mostwickets, String bowlername, int average){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO, teamlogo);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME, teamname);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL, highesttotal);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL, lowesttotal);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS, mostruns);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS, mostwickets);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME, bowlername);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE, average);

        return db.insert(TeamStatistics.TeamStat.TABLE_NAME, null, values);
    }

    public void updateTeams(String team, String captain){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllTeams.Teams.COLUMN_NAME_TEAM,team);
        values.put(AllTeams.Teams.COLUMN_NAME_CAPTAIN, captain);
        String selection = AllTeams.Teams.COLUMN_NAME_TEAM+" LIKE ?";
        String[] selectionArgs = {String.valueOf(team)};
        int count = db.update(
               AllTeams.Teams.TABLE_NAME, values, selection, selectionArgs);
    }

    public void updateTeamStat(String teamname, int highesttotal, int lowesttotal, int mostruns, int mostwickets, String bowlername, int average){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,teamname);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,highesttotal);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,lowesttotal);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,mostruns);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,mostwickets);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,bowlername);
        values.put(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE,average);
        String selection = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME+" LIKE ?";
        String[] selectionArgs = {String.valueOf(teamname)};
        int count = db.update(
                TeamStatistics.TeamStat.TABLE_NAME, values, selection, selectionArgs);
    }

    public void deleteTeams(String team, String captain){
    SQLiteDatabase db = getReadableDatabase();
    String selection = AllTeams.Teams.COLUMN_NAME_TEAM+ " LIKE ?";
    String[] selectionArgs = {String.valueOf(team)};
    db.delete(AllTeams.Teams.TABLE_NAME,selection,selectionArgs);
    }

    public void deleteTeamStat(String teamname, int highesttotal, int lowesttotal, int mostruns, int mostwickets, String bowlername, int average){
        SQLiteDatabase db = getReadableDatabase();
        String selection = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME+ " LIKE ?";
        String[] selectionArgs = {String.valueOf(teamname)};
        db.delete(TeamStatistics.TeamStat.TABLE_NAME,selection,selectionArgs);
    }
/*
    public List readTeamStat(String teamname){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection ={
                TeamStatistics.TeamStat._ID,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME
        };
        String selection = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME+" LIKE ?";
        String[] selectionArgs = {String.valueOf(teamname)};
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        List teamnames = new ArrayList<>();

        while(cursor.moveToNext()){
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            teamnames.add(mteamname);
        }
        cursor.close();
        return teamnames;
    }

    public List reachTeamStat1() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
                //TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
        //List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
            //String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
            //teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return teamname;
    }

    public List reachTeamStat2() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
                //TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
        //List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
            //String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
            //teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return highesttotal;
    }

    public List reachTeamStat3() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
                //TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
        //List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
            //String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
            //teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return lowesttotal;
    }

    public List reachTeamStat4() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
                //TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
        //List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
           // String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
            //teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return mostruns;
    }

    public List reachTeamStat5() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
                //TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
        //List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
           // String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
            //teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return mostwickets;
    }

    public List reachTeamStat6() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
               // TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
       // List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
           // String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
           // teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return bowlername;
    }

    public List reachTeamStat7() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TeamStatistics.TeamStat._ID,
                // TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO,
                TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS,
                TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS,
                TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME,
                TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE
        };
        String sortOrder = TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME + " DESC";
        Cursor cursor = db.query(
                TeamStatistics.TeamStat.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder,
                "3"
        );
        // List teamlogo = new ArrayList<>();
        List teamname = new ArrayList<>();
        List highesttotal = new ArrayList<>();
        List lowesttotal = new ArrayList<>();
        List mostruns = new ArrayList<>();
        List mostwickets = new ArrayList<>();
        List bowlername = new ArrayList<>();
        List average = new ArrayList<>();

        while (cursor.moveToNext()) {
            // String image = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMLOGO));
            String mteamname = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_TEAMNAME));
            String mhighesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_HIGHESTTOTAL));
            String mlowesttotal = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_LOWESTTOTAL));
            String mmostruns = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTRUNS));
            String mmostwickets = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_MOSTWICKETS));
            String mbowlername = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_BOWLERNAME));
            String maverage = cursor.getString(cursor.getColumnIndexOrThrow(TeamStatistics.TeamStat.COLUMN_NAME_AVERAGE));
            // teamlogo.add(image);
            teamname.add(mteamname);
            highesttotal.add(mhighesttotal);
            lowesttotal.add(mlowesttotal);
            mostruns.add(mmostruns);
            mostwickets.add(mmostwickets);
            bowlername.add(mbowlername);
            average.add(maverage);
        }
        cursor.close();
        return average;
    }


 */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

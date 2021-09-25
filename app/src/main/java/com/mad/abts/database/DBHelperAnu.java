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

public class DBHelperAnu extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LPLT20Anu.db";
    public DBHelperAnu(@Nullable Context context) { super(context, DATABASE_NAME, null, 2); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE "+PlayerProfile.Player.TABLE_NAME+
                " ("+PlayerProfile.Player._ID+" INTEGER PRIMARY KEY,"+
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_PHOTO+" BLOB,"+
                PlayerProfile.Player.COLUMN_NAME_TEAMNAME+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_DOB+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_COUNTRY+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_ROLE+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_BATSTYLE+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_BOWLSTYLE+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_MATCHES+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_RUNS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_HUNDREDS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_BOUNDARIES+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_OVERS+" REAL,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_ECONOMY+" REAL,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETHAULS+" INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Long addPlayer(byte [] photo , String playername, String teamname, String dob, String country, String role, String battingstyle, String bowlingstyle, int matches,
                          int runs, int fiftieshundreds, int boundaries, double overs, int wickets, double economy, int wickethauls){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();
        values.put(PlayerProfile.Player.COLUMN_NAME_PHOTO,photo);
        values.put(PlayerProfile.Player.COLUMN_NAME_PLAYERNAME,playername);
        values.put(PlayerProfile.Player.COLUMN_NAME_TEAMNAME,teamname);
        values.put(PlayerProfile.Player.COLUMN_NAME_DOB,dob);
        values.put(PlayerProfile.Player.COLUMN_NAME_COUNTRY,country);
        values.put(PlayerProfile.Player.COLUMN_NAME_ROLE,role);
        values.put(PlayerProfile.Player.COLUMN_NAME_BATSTYLE,battingstyle);
        values.put(PlayerProfile.Player.COLUMN_NAME_BOWLSTYLE,bowlingstyle);
        values.put(PlayerProfile.Player.COLUMN_NAME_MATCHES,matches);
        values.put(PlayerProfile.Player.COLUMN_NAME_RUNS,runs);
        values.put(PlayerProfile.Player.COLUMN_NAME_HUNDREDS,fiftieshundreds);
        values.put(PlayerProfile.Player.COLUMN_NAME_BOUNDARIES,boundaries);
        values.put(PlayerProfile.Player.COLUMN_NAME_OVERS,overs);
        values.put(PlayerProfile.Player.COLUMN_NAME_WICKETS,wickets);
        values.put(PlayerProfile.Player.COLUMN_NAME_ECONOMY,economy);
        values.put(PlayerProfile.Player.COLUMN_NAME_WICKETHAULS,wickethauls);


        return db.insert(PlayerProfile.Player.TABLE_NAME,null, values);
    }

    public void updatePlayer(byte [] photo , String playername, String teamname, String dob, String country, String role, String battingstyle, String bowlingstyle, int matches,
                             int runs, int fiftieshundreds, int boundaries, double overs, int wickets, double economy, int wickethauls){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(PlayerProfile.Player.COLUMN_NAME_PHOTO,photo);
        values.put(PlayerProfile.Player.COLUMN_NAME_PLAYERNAME,playername);
        values.put(PlayerProfile.Player.COLUMN_NAME_TEAMNAME,teamname);
        values.put(PlayerProfile.Player.COLUMN_NAME_DOB,dob);
        values.put(PlayerProfile.Player.COLUMN_NAME_COUNTRY,country);
        values.put(PlayerProfile.Player.COLUMN_NAME_ROLE,role);
        values.put(PlayerProfile.Player.COLUMN_NAME_BATSTYLE,battingstyle);
        values.put(PlayerProfile.Player.COLUMN_NAME_BOWLSTYLE,bowlingstyle);
        values.put(PlayerProfile.Player.COLUMN_NAME_MATCHES,matches);
        values.put(PlayerProfile.Player.COLUMN_NAME_RUNS,runs);
        values.put(PlayerProfile.Player.COLUMN_NAME_HUNDREDS,fiftieshundreds);
        values.put(PlayerProfile.Player.COLUMN_NAME_BOUNDARIES,boundaries);
        values.put(PlayerProfile.Player.COLUMN_NAME_OVERS,overs);
        values.put(PlayerProfile.Player.COLUMN_NAME_WICKETS,wickets);
        values.put(PlayerProfile.Player.COLUMN_NAME_ECONOMY,economy);
        values.put(PlayerProfile.Player.COLUMN_NAME_WICKETHAULS,wickethauls);
        String selection = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" LIKE ?";
        String[] selectionArgs = {String.valueOf(playername)};
        int count = db.update(
                PlayerProfile.Player.TABLE_NAME, values, selection, selectionArgs
        );
    }

    public void deletePlayer(String playername){
        SQLiteDatabase db = getReadableDatabase();
        String selection = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" LIKE ?";
        String[] selectionArgs = {playername};
        db.delete(MatchStats.MStats.TABLE_NAME,selection,selectionArgs);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

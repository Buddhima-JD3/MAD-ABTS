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
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+"TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_PHOTO+"BLOB,"+
                PlayerProfile.Player.COLUMN_NAME_TEAMNAME+"TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_DOB+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_COUNTRY+"TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_ROLE+"TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_BATSTYLE+"TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_BOWLSTYLE+"TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_MATCHES+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_RUNS+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_HUNDREDS+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_BOUNDARIES+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_OVERS+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETS+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_ECONOMY+"INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETHAULS+"INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL("CREATE TABLE "+ PlayerProfile.Player.TABLE_NAME+
                " ("+PlayerProfile.Player._ID+" INTEGER PRIMARY KEY,"+
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_PHOTO+" BLOB,"+
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_TEAMNAME+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_DOB+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_COUNTRY+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_ROLE+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_BATSTYLE+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_BOWLSTYLE+" TEXT,"+
                PlayerProfile.Player.COLUMN_NAME_MATCHES+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_RUNS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_HUNDREDS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_BOUNDARIES+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_OVERS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_ECONOMY+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETHAULS+" INTEGER)");
    }

    public Long addPlayer(byte [] photo , String playername, String teamname, int dob, String country, String role, String battingstyle, String bowlingstyle, int matches,
                          int runs, int fiftieshundreds, int boundaries, int overs, int wickets, double economy, int wickethauls){
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

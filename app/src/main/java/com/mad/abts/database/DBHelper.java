package com.mad.abts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LPLT20.db";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE "+MatchStats.MStats.TABLE_NAME+
                " ("+MatchStats.MStats._ID+" INTEGER PRIMARY KEY,"+
                MatchStats.MStats.COLUMN_NAME_TEAM+" TEXT,"+
                MatchStats.MStats.COLUMN_NAME_MATCHES+" TEXT,"+
                MatchStats.MStats.COLUMN_NAME_WON+" TEXT,"+
                MatchStats.MStats.COLUMN_NAME_LOST+" TEXT,"+
                MatchStats.MStats.COLUMN_NAME_NR+" TEXT,"+
                MatchStats.MStats.COLUMN_NAME_POINTS+" TEXT,"
                +MatchStats.MStats.COLUMN_NAME_WINPERC+" TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public Long addMatchStats(String team, String matches,String won, String lost,String nr,String points, String winperc ){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();
        values.put(MatchStats.MStats.COLUMN_NAME_TEAM,team);
        values.put(MatchStats.MStats.COLUMN_NAME_MATCHES,matches);
        values.put(MatchStats.MStats.COLUMN_NAME_WON,won);
        values.put(MatchStats.MStats.COLUMN_NAME_LOST,lost);
        values.put(MatchStats.MStats.COLUMN_NAME_NR,nr);
        values.put(MatchStats.MStats.COLUMN_NAME_POINTS,points);
        values.put(MatchStats.MStats.COLUMN_NAME_WINPERC,winperc);

        return db.insert(MatchStats.MStats.TABLE_NAME,null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

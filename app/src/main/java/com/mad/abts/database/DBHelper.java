package com.mad.abts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
                MatchStats.MStats.COLUMN_NAME_MATCHES+" INTEGER,"+
                MatchStats.MStats.COLUMN_NAME_WON+" INTEGER,"+
                MatchStats.MStats.COLUMN_NAME_LOST+" INTEGER,"+
                MatchStats.MStats.COLUMN_NAME_NR+" INTEGER,"+
                MatchStats.MStats.COLUMN_NAME_POINTS+" INTEGER,"
                +MatchStats.MStats.COLUMN_NAME_WINPERC+" DOUBLE)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public Long addMatchStats(String team, int matches,int won, int lost,int nr,int points, double winperc ){
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
    public void updateStats(String team, int matches,int won, int lost,int nr,int points, double winperc ){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MatchStats.MStats.COLUMN_NAME_MATCHES,matches);
        cv.put(MatchStats.MStats.COLUMN_NAME_WON,won);
        cv.put(MatchStats.MStats.COLUMN_NAME_LOST,lost);
        cv.put(MatchStats.MStats.COLUMN_NAME_NR,nr);
        cv.put(MatchStats.MStats.COLUMN_NAME_POINTS,points);
        cv.put(MatchStats.MStats.COLUMN_NAME_WINPERC,winperc);
        String selection = MatchStats.MStats.COLUMN_NAME_TEAM+" LIKE ?";
        String[] selectionArgs = {team};
        int count = db.update(
                MatchStats.MStats.TABLE_NAME, cv, selection, selectionArgs
        );
    }
    public void deleteStats(String team){
        SQLiteDatabase db = getReadableDatabase();
        String selection = MatchStats.MStats.COLUMN_NAME_TEAM+" LIKE ?";
        String[] selectionArgs = {team};
        db.delete(MatchStats.MStats.TABLE_NAME,selection,selectionArgs);
    }
    public List readStats1(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";
        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder             // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String team = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_TEAM));
            teams.add(team);
        }
        cursor.close();
        return teams;

    }
    public List readStats2(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";
        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String match = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_MATCHES));
            matches.add(match);
        }
        cursor.close();
        return matches;

    }
    public List readStats3(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";

        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String won = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_WON));
            wons.add(won);
        }
        cursor.close();
        return wons;

    }
    public List readStats4(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";

        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String lost = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_LOST));
            losts.add(lost);
        }
        cursor.close();
        return losts;

    }
    public List readStats5(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";

        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String nr = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_NR));
            nrs.add(nr);
        }
        cursor.close();
        return nrs;

    }
    public List readStats6(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";

        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String point = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_POINTS));
            points.add(point);
        }
        cursor.close();
        return points;

    }
    public List readStats7(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MatchStats.MStats._ID,
                MatchStats.MStats.COLUMN_NAME_TEAM,
                MatchStats.MStats.COLUMN_NAME_MATCHES,
                MatchStats.MStats.COLUMN_NAME_WON,
                MatchStats.MStats.COLUMN_NAME_LOST,
                MatchStats.MStats.COLUMN_NAME_NR,
                MatchStats.MStats.COLUMN_NAME_POINTS,
                MatchStats.MStats.COLUMN_NAME_WINPERC
        };
        String sortOrder = MatchStats.MStats.COLUMN_NAME_WINPERC+" DESC";

        Cursor cursor = db.query(
                MatchStats.MStats.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List teams = new ArrayList<>();
        List matches = new ArrayList<>();
        List wons = new ArrayList<>();
        List losts = new ArrayList<>();
        List nrs = new ArrayList<>();
        List points = new ArrayList<>();
        List winpercs = new ArrayList<>();
        while(cursor.moveToNext()){
            String winperc = cursor.getString(cursor.getColumnIndexOrThrow(MatchStats.MStats.COLUMN_NAME_WINPERC));
            winpercs.add(winperc);
        }
        cursor.close();
        return winpercs;

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

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
        super(context, DATABASE_NAME, null, 2);
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
                +MatchStats.MStats.COLUMN_NAME_WINPERC+" REAL)";

        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL("CREATE TABLE "+Matches.Match.TABLE_NAME+
                " ("+Matches.Match._ID+" INTEGER PRIMARY KEY,"+
                Matches.Match.COLUMN_NAME_TEAM1+" TEXT,"+
                Matches.Match.COLUMN_NAME_TEAM2+" TEXT,"+
                Matches.Match.COLUMN_NAME_MATCHNO+" INTEGER,"+
                Matches.Match.COLUMN_NAME_MATCHDATE+" TEXT,"+
                Matches.Match.COLUMN_NAME_BATTING+" TEXT,"+
                Matches.Match.COLUMN_NAME_RUNS1+" INTEGER,"+
                Matches.Match.COLUMN_NAME_RUNS2+" INTEGER,"+
                Matches.Match.COLUMN_NAME_WICKETS1+" INTEGER,"+
                Matches.Match.COLUMN_NAME_WICKETS2+" INTEGER,"+
                Matches.Match.COLUMN_NAME_OVERS1+" REAL,"
                +Matches.Match.COLUMN_NAME_OVERS2+" REAL)");


    }
    public Long addMatch(String team1, String team2,int matchno, String matchdate, int runs1,int runs2,int wickets1, int wickets2, double overs1, double overs2){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();
        values.put(Matches.Match.COLUMN_NAME_TEAM1,team1);
        values.put(Matches.Match.COLUMN_NAME_TEAM2,team2);
        values.put(Matches.Match.COLUMN_NAME_MATCHNO,matchno);
        values.put(Matches.Match.COLUMN_NAME_MATCHDATE,matchdate);
        values.put(Matches.Match.COLUMN_NAME_BATTING,"");
        values.put(Matches.Match.COLUMN_NAME_RUNS1,runs1);
        values.put(Matches.Match.COLUMN_NAME_RUNS2,runs2);
        values.put(Matches.Match.COLUMN_NAME_WICKETS1,wickets1);
        values.put(Matches.Match.COLUMN_NAME_WICKETS2,wickets2);
        values.put(Matches.Match.COLUMN_NAME_OVERS1,overs1);
        values.put(Matches.Match.COLUMN_NAME_OVERS2,overs2);

        return db.insert(Matches.Match.TABLE_NAME,null, values);
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
    public void updateMatch(int matchno,String batting, int runs1,int runs2,int wickets1, int wickets2, double overs1, double overs2){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Matches.Match.COLUMN_NAME_BATTING,batting);
        values.put(Matches.Match.COLUMN_NAME_RUNS1,runs1);
        values.put(Matches.Match.COLUMN_NAME_RUNS2,runs2);
        values.put(Matches.Match.COLUMN_NAME_WICKETS1,wickets1);
        values.put(Matches.Match.COLUMN_NAME_WICKETS2,wickets2);
        values.put(Matches.Match.COLUMN_NAME_OVERS1,overs1);
        values.put(Matches.Match.COLUMN_NAME_OVERS2,overs2);
        String selection = Matches.Match.COLUMN_NAME_MATCHNO+" LIKE ?";
        String[] selectionArgs = {String.valueOf(matchno)};
        int count = db.update(
                Matches.Match.TABLE_NAME, values, selection, selectionArgs
        );
    }
    public void deleteStats(String team){
        SQLiteDatabase db = getReadableDatabase();
        String selection = MatchStats.MStats.COLUMN_NAME_TEAM+" LIKE ?";
        String[] selectionArgs = {team};
        db.delete(MatchStats.MStats.TABLE_NAME,selection,selectionArgs);
    }
    public void deleteMatch(int matchno){
        SQLiteDatabase db = getReadableDatabase();
        String selection = Matches.Match.COLUMN_NAME_MATCHNO+" LIKE ?";
        String[] selectionArgs = {String.valueOf(matchno)};
        db.delete(Matches.Match.TABLE_NAME,selection,selectionArgs);
    }
    public List readspecMatch(int matchno){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Matches.Match._ID,
                Matches.Match.COLUMN_NAME_TEAM1,
                Matches.Match.COLUMN_NAME_TEAM2
        };
        String selection = Matches.Match.COLUMN_NAME_MATCHNO+" LIKE ?";
        String[] selectionArgs = {String.valueOf(matchno)};
        Cursor cursor = db.query(
                Matches.Match.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        List team1 = new ArrayList<>();
        List team2 = new ArrayList<>();
        while(cursor.moveToNext()){
            String team11 = cursor.getString(cursor.getColumnIndexOrThrow(Matches.Match.COLUMN_NAME_TEAM1));
            String team22 = cursor.getString(cursor.getColumnIndexOrThrow(Matches.Match.COLUMN_NAME_TEAM2));
            team1.add(team11);
            team2.add(team22);
        }
        cursor.close();
        return team1;

    }
    public List readspecMatch2(int matchno){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Matches.Match._ID,
                Matches.Match.COLUMN_NAME_TEAM1,
                Matches.Match.COLUMN_NAME_TEAM2
        };
        String selection = Matches.Match.COLUMN_NAME_MATCHNO+" LIKE ?";
        String[] selectionArgs = {String.valueOf(matchno)};
        Cursor cursor = db.query(
                Matches.Match.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        List team1 = new ArrayList<>();
        List team2 = new ArrayList<>();
        while(cursor.moveToNext()){
            String team11 = cursor.getString(cursor.getColumnIndexOrThrow(Matches.Match.COLUMN_NAME_TEAM1));
            String team22 = cursor.getString(cursor.getColumnIndexOrThrow(Matches.Match.COLUMN_NAME_TEAM2));
            team1.add(team11);
            team2.add(team22);
        }
        cursor.close();
        return team2;

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

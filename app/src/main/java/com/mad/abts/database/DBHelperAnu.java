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
                PlayerProfile.Player.COLUMN_NAME_AVERAGE+" REAL,"+
                PlayerProfile.Player.COLUMN_NAME_OVERS+" REAL,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETS+" INTEGER,"+
                PlayerProfile.Player.COLUMN_NAME_ECONOMY+" REAL,"+
                PlayerProfile.Player.COLUMN_NAME_WICKETHAULS+" INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);

        db.execSQL("CREATE TABLE "+AllPlayers.Players.TABLE_NAME+
                " ("+AllPlayers.Players._ID+" INTEGER PRIMARY KEY,"+
                AllPlayers.Players.COLUMN_NAME_IMAGE+" BLOB,"+
                AllPlayers.Players.COLUMN_NAME_PLAYERID+" TEXT,"+
                AllPlayers.Players.COLUMN_NAME_NAME+" TEXT,"+
                AllPlayers.Players.COLUMN_NAME_TEAMS+" TEXT)"
        );
    }

    public Long addPlayer(byte [] photo , String playername, String teamname, String dob, String country, String role, String battingstyle, String bowlingstyle, int matches,
                          int runs, int fiftieshundreds, double average, double overs, int wickets, double economy, int wickethauls){
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
        values.put(PlayerProfile.Player.COLUMN_NAME_AVERAGE,average);
        values.put(PlayerProfile.Player.COLUMN_NAME_OVERS,overs);
        values.put(PlayerProfile.Player.COLUMN_NAME_WICKETS,wickets);
        values.put(PlayerProfile.Player.COLUMN_NAME_ECONOMY,economy);
        values.put(PlayerProfile.Player.COLUMN_NAME_WICKETHAULS,wickethauls);


        return db.insert(PlayerProfile.Player.TABLE_NAME,null, values);
    }

    public Long addPlayers(byte[] playerimage, String playernumber,
                           String playersname, String teamsname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllPlayers.Players.COLUMN_NAME_IMAGE,playerimage);
        values.put(AllPlayers.Players.COLUMN_NAME_PLAYERID, playernumber);
        values.put(AllPlayers.Players.COLUMN_NAME_NAME, playersname);
        values.put(AllPlayers.Players.COLUMN_NAME_TEAMS, teamsname);
        return db.insert(AllPlayers.Players.TABLE_NAME, null, values);
    }


    public void updatePlayer(byte [] photo , String playername, String teamname, String dob, String country, String role, String battingstyle, String bowlingstyle, int matches,
                             int runs, int fiftieshundreds, double average, double overs, int wickets, double economy, int wickethauls){

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
        values.put(PlayerProfile.Player.COLUMN_NAME_AVERAGE,average);
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

    public void updatePlayers(byte[] playerimage, String playernumber,
                           String playersname, String teamsname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllPlayers.Players.COLUMN_NAME_IMAGE,playerimage);
        values.put(AllPlayers.Players.COLUMN_NAME_PLAYERID, playernumber);
        values.put(AllPlayers.Players.COLUMN_NAME_NAME, playersname);
        values.put(AllPlayers.Players.COLUMN_NAME_TEAMS, teamsname);
        String selection = AllPlayers.Players.COLUMN_NAME_PLAYERID+" LIKE ?";
        String[] selectionArgs = {String.valueOf(playernumber)};
        int count = db.update(AllPlayers.Players.TABLE_NAME, values, selection, selectionArgs);
    }


    public void deletePlayer(String playername){
        SQLiteDatabase db = getReadableDatabase();
        String selection = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" LIKE ?";
        String[] selectionArgs = {playername};
        db.delete(PlayerProfile.Player.TABLE_NAME,selection,selectionArgs);
    }

    public void deletePlayers(String playernumber){
        SQLiteDatabase db = getReadableDatabase();
        String selection = AllPlayers.Players.COLUMN_NAME_PLAYERID+" LIKE ?";
        String[] selectionArgs = {playernumber};
        db.delete(AllPlayers.Players.TABLE_NAME,selection,selectionArgs);
    }

    public List readuserPlayer(String playername) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                PlayerProfile.Player._ID,

                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME,

    };
        String selection = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" LIKE ?";
        String[] selectionArgs = {String.valueOf(playername)};
        Cursor cursor = db.query(
                PlayerProfile.Player.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        List player1 = new ArrayList<>();

        while(cursor.moveToNext()){
            String player11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PLAYERNAME));
            player1.add(player11);
        }
        cursor.close();
        return player1;
    }

    public List readPlayer1(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                PlayerProfile.Player._ID,
                PlayerProfile.Player.COLUMN_NAME_PHOTO,
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME,
                PlayerProfile.Player.COLUMN_NAME_TEAMNAME
    };
        String sortOrder = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" DESC";
        Cursor cursor = db.query(
                PlayerProfile.Player.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder,
                "3"// The sort order
        );

        List photo = new ArrayList();
        List playername = new ArrayList<>();
        List teamname = new ArrayList();

        while(cursor.moveToNext()){
            String photoanu11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PHOTO));
            String playername11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PLAYERNAME));
            String teamname11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_TEAMNAME));
            photo.add(photoanu11);
            playername.add(playername11);
            teamname.add(teamname11);
        }
        cursor.close();
        return photo;
    }

    public List readPlayer2(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                PlayerProfile.Player._ID,
                PlayerProfile.Player.COLUMN_NAME_PHOTO,
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME,
                PlayerProfile.Player.COLUMN_NAME_TEAMNAME
        };
        String sortOrder = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" DESC";
        Cursor cursor = db.query(
                PlayerProfile.Player.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder,
                "3"// The sort order
        );

        List photo = new ArrayList();
        List playername = new ArrayList<>();
        List teamname = new ArrayList();

        while(cursor.moveToNext()){
            String photoanu11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PHOTO));
            String playername11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PLAYERNAME));
            String teamname11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_TEAMNAME));
            photo.add(photoanu11);
            playername.add(playername11);
            teamname.add(teamname11);
        }
        cursor.close();
        return playername;
    }

    public List readPlayer3(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                PlayerProfile.Player._ID,
                PlayerProfile.Player.COLUMN_NAME_PHOTO,
                PlayerProfile.Player.COLUMN_NAME_PLAYERNAME,
                PlayerProfile.Player.COLUMN_NAME_TEAMNAME
        };
        String sortOrder = PlayerProfile.Player.COLUMN_NAME_PLAYERNAME+" DESC";
        Cursor cursor = db.query(
                PlayerProfile.Player.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder,
                "3"// The sort order
        );

        List photo = new ArrayList();
        List playename = new ArrayList<>();
        List teamname = new ArrayList();

        while(cursor.moveToNext()){
            String photoanu11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PHOTO));
            String playername11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_PLAYERNAME));
            String teamname11 = cursor.getString(cursor.getColumnIndexOrThrow(PlayerProfile.Player.COLUMN_NAME_TEAMNAME));
            photo.add(photoanu11);
            playename.add(playername11);
            teamname.add(teamname11);
        }
        cursor.close();
        return teamname;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

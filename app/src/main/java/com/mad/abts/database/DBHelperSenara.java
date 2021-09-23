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
                AllTeams.Teams.COLUMN_NAME_LOGOIMAGE1+" BLOB,"+
                AllTeams.Teams.COLUMN_NAME_TNAME+" TEXT,"+
                AllTeams.Teams.COLUMN_NAME_LOGOIMAGE2+" BLOB,"+
                AllTeams.Teams.COLUMN_NAME_TNAMEEDIT2+" TEXT,"+
                AllTeams.Teams.COLUMN_NAME_LOGOIMAGE3+" BLOB,"+
                AllTeams.Teams.COLUMN_NAME_TNAMEEDIT3+" TEXT,"+
                AllTeams.Teams.COLUMN_NAME_LOGOIMAGE4+" BLOB,"+
                AllTeams.Teams.COLUMN_NAME_TNAMEEDIT4+" TEXT,"+
                AllTeams.Teams.COLUMN_NAME_LOGOIMAGE5+" BLOB,"+
                AllTeams.Teams.COLUMN_NAME_TNAMEEDIT5+" TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);

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
    }

    public Long addTeams(byte[] logoimage1, String tname, byte[] logoimage2, String tnameedit2, byte[] logoimage3, String tnameedit3, byte[] logoimage4, String tnameedit4, byte[] logoimage5, String tnameedit5){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllTeams.Teams.COLUMN_NAME_LOGOIMAGE1,logoimage1);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAME, tname);
        values.put(AllTeams.Teams.COLUMN_NAME_LOGOIMAGE2, logoimage2);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT2, tnameedit2);
        values.put(AllTeams.Teams.COLUMN_NAME_LOGOIMAGE3, logoimage3);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT3, tnameedit3);
        values.put(AllTeams.Teams.COLUMN_NAME_LOGOIMAGE4, logoimage4);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT4, tnameedit4);
        values.put(AllTeams.Teams.COLUMN_NAME_LOGOIMAGE5, logoimage5);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT5, tnameedit5);

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

    public void updateTeams(String tname, String tnameedit2, String tnameedit3, String tnameedit4, String tnameedit5){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(AllTeams.Teams.COLUMN_NAME_TNAME,tname);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT2,tnameedit2);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT3,tnameedit3);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT4,tnameedit4);
        values.put(AllTeams.Teams.COLUMN_NAME_TNAMEEDIT5,tnameedit5);
        //String selection = AllTeams.Teams.COLUMN_NAME_???+" LIKE ?";
        //String[] selectionArgs = {String.valueOf(???)};
        //int count = db.update(
               // AllTeams.Teams.TABLE_NAME, values, selection, selectionArgs);
       // );
    }

    public void deleteTeams(){

    }

    public void deleteVenues(){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

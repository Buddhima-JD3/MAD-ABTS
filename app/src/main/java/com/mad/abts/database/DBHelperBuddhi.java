package com.mad.abts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelperBuddhi extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LPLT20B.db";

    public DBHelperBuddhi(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE "+Products.product.TABLE_NAME+
                " ("+Products.product._ID+" INTEGER PRIMARY KEY,"+
                Products.product.COLUMN_NAME_PRODUCTNAME+" TEXT,"+
                Products.product.COLUMN_NAME_DESCRIPTION+" TEXT,"+
                Products.product.COLUMN_NAME_QUANTITY+" INTEGER,"+
                Products.product.COLUMN_NAME_PRICE+" REAL,"+
                Products.product.COLUMN_NAME_CATEGORY+" TEXT,"+
                Products.product.COLUMN_NAME_IMAGE+" BLOB)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public Long addProductShop(String name, String desc, int qty, double price, String category, byte[] img ){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();
        values.put(Products.product.COLUMN_NAME_PRODUCTNAME,name);
        values.put(Products.product.COLUMN_NAME_DESCRIPTION,desc);
        values.put(Products.product.COLUMN_NAME_QUANTITY,qty);
        values.put(Products.product.COLUMN_NAME_PRICE,price);
        values.put(Products.product.COLUMN_NAME_CATEGORY,category);
        values.put(Products.product.COLUMN_NAME_IMAGE,img);

        return db.insert(Products.product.TABLE_NAME,null, values);
    }
    public List readProductUserShirt1(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Shirt")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List prices = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_PRODUCTNAME));
            names.add(name);
        }
        cursor.close();
        return names;

    }

    public List readProductUserShirt2(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Shirt")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List prices = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            String price = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_PRICE));
            prices.add(price);
        }
        cursor.close();
        return prices;

    }

    public List readProductUserShirt3(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Shirt")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List prices = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            byte[] img = cursor.getBlob(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_IMAGE));
            imgs.add(img);
        }
        cursor.close();
        return imgs;

    }
    public List readProductUserShirt4(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Shirt")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List qty = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            String qtys = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_QUANTITY));
            qty.add(qtys);
        }
        cursor.close();
        return qty;

    }

    public List readProductUserShirt5(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Shirt")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List ids = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(Products.product._ID)));
            ids.add(id);
        }
        cursor.close();
        return ids;

    }

    public List readProductUserCap1(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Cap")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List prices = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_PRODUCTNAME));
            names.add(name);
        }
        cursor.close();
        return names;

    }

    public List readProductUserCap2(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Cap")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List prices = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            String price = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_PRICE));
            prices.add(price);
        }
        cursor.close();
        return prices;

    }

    public List readProductUserCap3(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Cap")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List prices = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            byte[] img = cursor.getBlob(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_IMAGE));
            imgs.add(img);
        }
        cursor.close();
        return imgs;

    }
    public List readProductUserCap4(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Cap")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List qty = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            String qtys = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_QUANTITY));
            qty.add(qtys);
        }
        cursor.close();
        return qty;

    }
    public List readProductUserCap5(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_CATEGORY,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String sortOrder = Products.product._ID+" DESC";
        String selection = Products.product.COLUMN_NAME_CATEGORY+" LIKE ?";
        String[] selectionArgs = {("Cap")};
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );
        List names = new ArrayList<>();
        List ids = new ArrayList<>();
        List imgs = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(Products.product._ID)));
            ids.add(id);
        }
        cursor.close();
        return ids;

    }
    public void updateProduct(int id, int qty){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Products.product.COLUMN_NAME_QUANTITY,qty);

        String selection = Products.product._ID+" LIKE ?";
        String[] selectionArgs = {String.valueOf(id)};
        int count = db.update(
                Products.product.TABLE_NAME, cv, selection, selectionArgs
        );
    }
    public void deleteProduct(int id){

        SQLiteDatabase db = getReadableDatabase();
        String selection = Products.product._ID+" LIKE ?";
        String[] selectionArgs = {String.valueOf(id)};
        db.delete(Products.product.TABLE_NAME,selection,selectionArgs);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

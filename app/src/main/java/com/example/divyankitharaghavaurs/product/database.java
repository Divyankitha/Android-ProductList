package com.example.divyankitharaghavaurs.product;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by divyankithaRaghavaUrs on 3/30/17.
 */

public class database extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "ProductDB.db";
    public static final String TABLE_NAME = "ProductDetails";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_REVIEW = "Review";


    public database(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("create table ProductDetails " + "(id integer primary key, Name text,Description text,Price integer, Review text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS ProductDetails");
        onCreate(db);
    }

    public boolean insertProduct (String name, String description, int price, String review)
    {

        Log.d("Debug -->", "inside insert product of insert database class");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Description", description);
        contentValues.put("Price", price);
        contentValues.put("Review", review);

        db.insert("ProductDetails", null, contentValues);
        return true;
    }

    public Cursor getData(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String key = "%" +name+ "%";
        String[] args={key, key, key, key};
        //Cursor res =  db.rawQuery( "select * from ProductDetails where Name like'" +name+"' or Description like'" +name+"'" , null );
        Cursor res =  db.rawQuery( "select * from ProductDetails where Name like ? or Description like ? or Review like ? or Price like ?" , args );

        return res;
    }


    public int numberOfRows()
    {
        Log.d("Debug -->", "inside number of rows of insert database class");
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public Integer deleteContact (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("ProductDetails", "id = ? ", new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllCotacts()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        Log.d("Debug -->", "inside get all of insert database class");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from ProductDetails", null );
        res.moveToFirst();

        while(res.isAfterLast() == false)
        {
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

}


package com.example.puppy.p1610861_8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "friends.db";
    private static final int DATABASE_VERSION = 2;

    public dbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE friends( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, tel TEXT, birth Text);");
        db.execSQL("CREATE TABLE IF NOT EXISTS friends( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, tel TEXT, birth Text);");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS friends");
        onCreate(db);
    }
}

package com.example.darsihmadapp.SQLITE.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.darsihmadapp.SQLITE.Table.TableSites;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "DarSiHmad.db";
    public static final int DATABASE_VERSION = 3;

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Helper", "Database created successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableSites.Create_Query);
        Log.d("Database ", "Table created ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(TableSites.Drop_Query);
    onCreate(db);
    }
}

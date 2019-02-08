package com.example.darsihmadapp.SQLITE;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.darsihmadapp.R;
import com.example.darsihmadapp.SQLITE.Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);
        myDB.getWritableDatabase();
    }
}

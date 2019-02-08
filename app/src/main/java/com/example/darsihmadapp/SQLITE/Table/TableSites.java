package com.example.darsihmadapp.SQLITE.Table;

import android.provider.BaseColumns;

public class TableSites implements BaseColumns {
    public TableSites(){

    }

    public static final String TABLE_NAME="sites";
    public static final String ID_SITE="site_id";
    public static final String NAME_SITE="site_name";

    public static final String Create_Query="create table " + TABLE_NAME + " (" +
            _ID + " Integer, " +
            ID_SITE + " Integer, " +
            NAME_SITE + " Text " + ");";

    public static final String Drop_Query="drop table if exists " + TABLE_NAME;
    public static final String Select_Query="select * from " + TABLE_NAME;

}

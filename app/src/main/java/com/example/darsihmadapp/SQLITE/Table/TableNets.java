package com.example.darsihmadapp.SQLITE.Table;

import android.provider.BaseColumns;

public class TableNets implements BaseColumns {
    public TableNets(){

    }

    public static final String TABLE_NAME="nets";
    public static final String ID_NET="net_id";
    public static final String NAME_NET="net_name";

    public static final String Create_Query="create table " + TABLE_NAME + " (" +
            _ID + " Integer, " +
            ID_NET + " Integer, " +
            NAME_NET + " Text " + ");";

    public static final String Drop_Query="drop table if exists " + TABLE_NAME;
    public static final String Select_Query="select * from " + TABLE_NAME;

}

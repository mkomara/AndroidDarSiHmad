package com.example.darsihmadapp.SQLITE.Table;

import android.provider.BaseColumns;

public class TableData implements BaseColumns {
    public static final String TABLE_NAME="data";
    public static final String ID_DATA="data_id";
    public static final String MM_PRECIPITATION_DATA="data_name";
    public static final String RH_DATA="data_rh";
    public static final String TEMPERATURE_CELSUS_DATA="data_temperature";
    public static final String MIN_WET450_DATA="data_minWet450";
    public static final String MIN_WET460_DATA="data_minWet460";
    public static final String IWSCOUNTS_DATA="data_iwsCounts";
    public static final String PULSE_COUNTS_PORT4="data_PulseCountsPort4";
    public static final String PULSE_COUNTS_PORT5="data_PulseCountsPort5";
    public static final String MEASUREMENT_TIME_DATA="data_MeasurementTime";
    public static final String NETS_ID_DATA="data_TableNETS_ID";
    public static final String CREATED_AT_DATA="data_created_at";
    public static final String UPDATED_AT_DATA="data_updated_at";



    public static final String Create_Query="create table " + TABLE_NAME + " (" +
            _ID + " Integer, "
            + ID_DATA + " Integer, "
            + MM_PRECIPITATION_DATA + " double, "
            + RH_DATA + " double, "
            + TEMPERATURE_CELSUS_DATA + " double, "
            + MIN_WET450_DATA + " double, "
            + MIN_WET460_DATA + " double, "
            + IWSCOUNTS_DATA + "  double, "
            + PULSE_COUNTS_PORT4 + "  double, "
            + PULSE_COUNTS_PORT5 + "  double, "
            +MEASUREMENT_TIME_DATA + "  datetime, "
            + NETS_ID_DATA + " Integer, "
            + CREATED_AT_DATA + " timestamp, "
            + UPDATED_AT_DATA + " timestamp, "
            + "constraint " + "FK_table_nets_id" +" foreign "+ "key "+ "("+ NETS_ID_DATA +")"
            + "references " + TableNets.ID_NET +" ("+ "ID_NETS "+");";

            

    public static final String Drop_Query="drop table if exists " + TABLE_NAME;
    public static final String Select_Query="select * from " + TABLE_NAME;

}

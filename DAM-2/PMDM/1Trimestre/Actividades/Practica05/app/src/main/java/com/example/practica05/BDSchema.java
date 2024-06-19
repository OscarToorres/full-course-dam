package com.example.practica05;

import android.provider.BaseColumns;

public class BDSchema {

    private BDSchema(){

    }

    public static class Cita implements BaseColumns{
        public static final String TABLE_NAME ="citas";
        public static final String COL_ID ="id";
        public static final String COL_FECHA ="fecha";
        public static final String COL_HORA ="hora";
        public static final String COL_ASUNTO ="asunto";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +  Cita.TABLE_NAME + " (" +
                    Cita.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Cita.COL_FECHA + " DATE,"+
                    Cita.COL_HORA + " DATETIME," +
                    Cita.COL_ASUNTO + " TEXT)";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Cita.TABLE_NAME;
}


package com.example.c0753560_mad3125_midterm.JavaClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME = "dbUser";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String UserTable = "CREATE TABLE " + DbUser.TABLE_NAME
            + "(" + DbUser.USER_ID + " INT,"
            + DbUser.USER_EMAIL + " TEXT,"
            + DbUser.USER_PASSWORD + " TEXT)";

    sqLiteDatabase.execSQL(UserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + DbUser.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

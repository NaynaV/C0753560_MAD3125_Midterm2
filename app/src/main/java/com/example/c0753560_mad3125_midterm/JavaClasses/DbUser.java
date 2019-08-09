package com.example.c0753560_mad3125_midterm.JavaClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbUser {

    public static final String TABLE_NAME = "tblUser";
    public static final String USER_ID = "uid";
    public static final String USER_EMAIL = "uemail";
    public static final String USER_PASSWORD = "upass";
    private DbHelper dbHelper;
    public DbUser(Context context)
    {
        dbHelper = new DbHelper(context);
    }

    public void insert(User user)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(USER_ID, user.getUserId());
        cv.put(USER_EMAIL, user.getUserEmail());
        cv.put(USER_PASSWORD, user.getUserPassword());

        db.insert(TABLE_NAME, null,cv);

        db.close();

    }

    public void update(User user)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(USER_ID, user.getUserId());
        cv.put(USER_EMAIL, user.getUserEmail());
        cv.put(USER_PASSWORD, user.getUserPassword());

        db.update(TABLE_NAME,cv,
                USER_ID + "=?",
                new String[]
                        {
                                String.valueOf(user.getUserId())
                        });

        db.close();

    }

    public void updateByEmail(User user)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(USER_ID, user.getUserId());
        cv.put(USER_EMAIL, user.getUserEmail());
        cv.put(USER_PASSWORD, user.getUserPassword());

        db.update(TABLE_NAME,cv,
                USER_EMAIL + "=?",
                new String[]
                        {
                                user.getUserEmail()
                        });

        db.close();

    }

    public void deleteByID(int userID)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, USER_ID + "=?",
                new String[]
                        {
                                String.valueOf(USER_ID)
                        });
        db.close();
    }

    public void deleteByEmail(String studentEmail)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, USER_EMAIL + "=?",
                new String[]
                        {
                                studentEmail
                        });
        db.close();
    }

    public ArrayList<User> getAllUsers()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<User> mUsers = new ArrayList<>();
        if(mCursor != null)
        {
            if(mCursor.getCount() != 0)
            {
                mCursor.moveToFirst();
                while (!mCursor.isAfterLast())
                {
                    User mUser = new User();
                    mUser.setUserId(Integer.parseInt(mCursor.getString(0)));
                    mUser.setUserEmail(mCursor.getString(1));
                    mUser.setUserPassword(mCursor.getString(2));

                    mUsers.add(mUser);

                    mCursor.moveToNext();
                }
            }
        }

        db.close();
        return mUsers;
    }

    public ArrayList<User> getUserByEmail(String userEmail)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        Cursor mCursor = db.query(TABLE_NAME, null, USER_EMAIL + "=?", new String[]{String.valueOf(userEmail)}, null, null, null, null);

        ArrayList<User> mUsers = new ArrayList<>();
        if(mCursor != null)
        {
            if(mCursor.getCount() != 0)
            {
                mCursor.moveToFirst();
                while (!mCursor.isAfterLast())
                {
                    User mUser = new User();
                    mUser.setUserEmail(mCursor.getString(1));
                    mUser.setUserPassword(mCursor.getString(2));

                    mUsers.add(mUser);

                    mCursor.moveToNext();
                }
            }
        }

        db.close();
        return mUsers;
    }
}

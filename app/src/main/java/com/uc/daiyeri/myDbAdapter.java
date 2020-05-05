package com.uc.daiyeri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String title, String note)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.TITLE, title);
        contentValues.put(myDbHelper.NOTE, note);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

//

    public List<User> allPlayers() {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM user";
        SQLiteDatabase db = myhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null){

        }
        else if(cursor!=null){
            if (cursor.moveToFirst()) {
                do {
//                Log.e("title", cursor.getString(1));
                    User user = new User(cursor.getString(1),cursor.getString(2));

                    users.add(user);
                } while (cursor.moveToNext());
            }
        }


        db.close();
        Log.e("list", users.toString());
        return users;
    }


    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "user";   // Table Name
        private static final int DATABASE_Version = 1;   // Database Version
        private static final String UID="_id";
        private static final String TITLE = "title";
        private static final String NOTE = "note";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TITLE+" VARCHAR(255) ,"+ NOTE+" TEXT);";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}


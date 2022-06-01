package com.example.sqllistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "MyDB";
    private static final String TB_NAME = "Users";

    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_PASSWORD = "password";

    public DBHandler(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_NAME + "(" + KEY_ID +
                " INTEGER PRIMARY KEY," + KEY_NAMA + " TEXT," +
                KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(db);
    }

    public boolean insertUser(DataModel user) {
        Log.d("SQLITE", "INSERTING USER");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAMA, user.getNama());
        cv.put(KEY_PASSWORD, user.getPassword());
        db.insert(TB_NAME, null, cv);
        db.close();
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM" + TB_NAME + "WHERE id =" + id, null);
        return result;
    }

    public ArrayList getAll() {
        ArrayList userList = new ArrayList();
        String query = "SELECT * FROM " + TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                userList.add("\n"+c.getString(0)+"\t\tNAMA:  " +c.getString(1)+"\t PASSWORD:  "+c.getString(2));

            } while (c.moveToNext());
        }
        return userList;
    }


}

package com.example.khalid.safarwayz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by khalid on 13/9/17.
 */

public class DatabaseOperation extends SQLiteOpenHelper {

    Cursor cursor;
    public static final int DATABASE_VERSION = 1;
    public String CREATE_QUERY = "create table "+ TableData.TableInfo.TABLE_NAME+"("+ TableData.TableInfo.name+" text,"
            + TableData.TableInfo.contact+"integer,"+ TableData.TableInfo.username+" text,"+ TableData.TableInfo.password+" text);";

    public DatabaseOperation(Context context)
    {
        super(context, TableData.TableInfo.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DATABASE OPERATIONS", "DATABASE CREATED");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL(CREATE_QUERY);
        Log.d("DATABASE OPERATIONS", "TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperation dop, String name, int contact, String username, String password)
    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.name, name);
        cv.put(TableData.TableInfo.contact, contact);
        cv.put(TableData.TableInfo.username, username);
        cv.put(TableData.TableInfo.password, password);

        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database Operations" , "One Row Inserted");
    }

    public Cursor getInformation(DatabaseOperation dop)
    {
        SQLiteDatabase sq = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.username, TableData.TableInfo.password};
        Cursor cr = sq.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cr;
    }
}

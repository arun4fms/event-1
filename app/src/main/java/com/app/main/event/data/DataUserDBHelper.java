package com.app.main.event.data;

/**
 * Created by bima on 08/12/17.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.main.event.data.DataUser.*;

public class DataUserDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data_user.db";

    private static final int DATABASE_VERSION = 1;

    // Constructor
    public DataUserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // COMPLETED (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold waitlist data
        final String SQL_CREATE_DATAUSER_TABLE = "CREATE TABLE " + DataUserEntry.TABLE_NAME + " (" +
                DataUserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DataUserEntry.COLUMN_USERNAME + " TEXT NOT NULL, " +
                DataUserEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
                DataUserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, " +
                DataUserEntry.COLUMN_CREATETIME + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                "); ";

        // COMPLETED (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        sqLiteDatabase.execSQL(SQL_CREATE_DATAUSER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DataUserEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

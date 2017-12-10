package com.app.main.event.data;

/**
 * Created by bima on 10/12/17.
 */
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "PMB Univ X 2018");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "Registrasion new students");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Scholarship Univ A 2019");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "Registrasion Scholarship 2019");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "DotA 2 contest 2019");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "DotA 2 contest 2019 Indonesian");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Web developer PT. X");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "CodeIgniter, bootstrap, MySQL");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Scholarship Dikti 2019");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "Dikti Scholarship 2019");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Futsal competition 2018");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "Semarang at XXX Banyumanik");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Seminar nasional VR");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "VR and implementation for hospital");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Scholarship Univ A 2016");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "-");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Scholarship Univ X 2017");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "-");
        list.add(cv);

        cv = new ContentValues();
        cv.put(Event.EventEntry.COLUMN_NAME, "Test Event");
        cv.put(Event.EventEntry.COLUMN_DESCRIPTION, "Test event");
        list.add(cv);


        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (Event.EventEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(Event.EventEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            System.out.println("TOO BAD!!");
        }
        finally
        {
            db.endTransaction();
        }

    }
}
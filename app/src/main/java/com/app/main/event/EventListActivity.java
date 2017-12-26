package com.app.main.event;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.main.event.data.TestUtil;
import com.app.main.event.data.Event;
import com.app.main.event.data.EventDBHelper;

public class EventListActivity extends AppCompatActivity {
    private EventListAdapter eAdapter;
    private SQLiteDatabase eD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        // Set local attributes to corresponding views
        RecyclerView EventListRecyclerView;
        EventListRecyclerView = (RecyclerView) this.findViewById(R.id.all_events_list_view);

        // Set layout for the RecyclerView, because it's a list we are using the linear layout
        EventListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // COMPLETED (2) Create a WaitlistDbHelper instance, pass "this" to the constructor
        // Create a DB helper (this will create the DB if run for the first time)
        EventDBHelper dbHelper = new EventDBHelper(this);

        // COMPLETED (3) Get a writable database reference using getWritableDatabase and store it in mDb
        // Keep a reference to the mDb until paused or killed. Get a writable database
        // because you will be adding restaurant customers
        // COMPLETED (4) call insertFakeData in TestUtil and pass the database reference mDb
        //Fill the database with fake data
        TestUtil.insertFakeData(eD);
        eD = dbHelper.getWritableDatabase();

        // COMPLETED (7) Run the getAllGuests function and store the result in a Cursor variable
        Cursor cursor = getAllGuests();

        // COMPLETED (12) Pass the resulting cursor count to the adapter
        // Create an adapter for that cursor to display the data
        eAdapter = new EventListAdapter(this, cursor.getCount());

        // Link the adapter to the RecyclerView
        EventListRecyclerView.setAdapter(eAdapter);
    }

    private Cursor getAllGuests() {
        // COMPLETED (6) Inside, call query on mDb passing in the table name and projection String [] order by COLUMN_TIMESTAMP
        return eD.query(
                Event.EventEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                Event.EventEntry.COLUMN_NAME
        );
    }
}

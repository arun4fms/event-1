package com.app.main.event.data;

import android.provider.BaseColumns;

/**
 * Created by bima on 10/12/17.
 */

public class Event {
    public static final class EventEntry implements BaseColumns {
        public static final String TABLE_NAME = "event";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
    }
}

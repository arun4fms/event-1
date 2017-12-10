package com.app.main.event.data;

/**
 * Created by bima on 07/12/17.
 */
import android.provider.BaseColumns;


public class DataUser {
    public static final class DataUserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_CREATETIME = "create_time";
    }
}

package com.example.khalid.safarwayz;

import android.provider.BaseColumns;

/**
 * Created by khalid on 13/9/17.
 */

public class TableData {

    public TableData() {}

    public static abstract class TableInfo implements BaseColumns
    {

        public static final String name = "name";
        public static final String contact = "contact";
        public static final String username = "username";
        public static final String password = "password";
        public static final String DATABASE_NAME = "deadlock";
        public static final String TABLE_NAME = "users";
    }

}

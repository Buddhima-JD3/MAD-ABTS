package com.mad.abts.database;

import android.provider.BaseColumns;

public class AllTeams {

    public AllTeams(){

    }

    public static class Teams implements BaseColumns {
        public static final String TABLE_NAME = "allteams";
        public static final String COLUMN_NAME_LOGOIMAGE1 = "logoimage1";
        public static final String COLUMN_NAME_TNAME = "tname";
        public static final String COLUMN_NAME_LOGOIMAGE2 = "logoimage2";
        public static final String COLUMN_NAME_TNAMEEDIT2 = "tnameedit2";
        public static final String COLUMN_NAME_LOGOIMAGE3 = "logoimage3";
        public static final String COLUMN_NAME_TNAMEEDIT3 = "tnameedit3";
        public static final String COLUMN_NAME_LOGOIMAGE4 = "logoimage4";
        public static final String COLUMN_NAME_TNAMEEDIT4 = "tnameedit4";
        public static final String COLUMN_NAME_LOGOIMAGE5 = "logoimage5";
        public static final String COLUMN_NAME_TNAMEEDIT5 = "tnameedit5";
    }
}

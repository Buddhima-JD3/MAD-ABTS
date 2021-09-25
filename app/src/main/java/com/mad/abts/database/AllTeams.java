package com.mad.abts.database;

import android.provider.BaseColumns;

public class AllTeams {

    public AllTeams(){

    }

    public static class Teams implements BaseColumns {
        public static final String TABLE_NAME = "allteams";
        public static final String COLUMN_NAME_LOGO = "logo";
        public static final String COLUMN_NAME_TEAM = "team";

    }
}

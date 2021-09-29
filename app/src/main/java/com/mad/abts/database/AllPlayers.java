package com.mad.abts.database;

import android.provider.BaseColumns;

public class AllPlayers {

    public AllPlayers(){

    }

    public static class Players implements BaseColumns {
        public static final String TABLE_NAME = "allplayers";
        public static final String COLUMN_NAME_IMAGE = "playerimage";
        public static final String COLUMN_NAME_PLAYERID = "playernumber";
        public static final String COLUMN_NAME_NAME = "playersname";
        public static final String COLUMN_NAME_TEAMS = "teamsname";

    }
}

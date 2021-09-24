package com.mad.abts.database;

import android.provider.BaseColumns;

public class PlayerProfile {
    public PlayerProfile () {
    }
    public static class Player implements BaseColumns {
        public static final String TABLE_NAME = "playerprofiles";
        public static final String COLUMN_NAME_PHOTO = "photo";
        public static final String COLUMN_NAME_PLAYERNAME = "playername";
        public static final String COLUMN_NAME_TEAMNAME = "teamname";
        public static final String COLUMN_NAME_DOB = "dob";
        public static final String COLUMN_NAME_COUNTRY = "country";
        public static final String COLUMN_NAME_ROLE = "role";
        public static final String COLUMN_NAME_BATSTYLE = "battingstyle";
        public static final String COLUMN_NAME_BOWLSTYLE = "bowlingstyle";
        public static final String COLUMN_NAME_MATCHES = "matches";
        public static final String COLUMN_NAME_RUNS = "runs";
        public static final String COLUMN_NAME_HUNDREDS = "fiftieshundreds";
        public static final String COLUMN_NAME_BOUNDARIES = "boundaries";
        public static final String COLUMN_NAME_OVERS = "overs";
        public static final String COLUMN_NAME_WICKETS = "wickets";
        public static final String COLUMN_NAME_ECONOMY = "economy";
        public static final String COLUMN_NAME_WICKETHAULS = "wickethauls";
    }
}

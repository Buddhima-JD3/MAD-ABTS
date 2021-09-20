package com.mad.abts.database;

import android.provider.BaseColumns;

public class Matches {
    public Matches() {
    }
    public static class Match implements BaseColumns {
        public static final String TABLE_NAME = "matches";
        public static final String COLUMN_NAME_TEAM1 = "team1";
        public static final String COLUMN_NAME_TEAM2 = "team2";
        public static final String COLUMN_NAME_MATCHNO = "match_no";
        public static final String COLUMN_NAME_MATCHDATE = "match_date";
        public static final String COLUMN_NAME_RUNS1 = "runs1";
        public static final String COLUMN_NAME_WICKETS1 = "wickets1";
        public static final String COLUMN_NAME_OVERS1 = "overs1";
        public static final String COLUMN_NAME_RUNS2 = "runs2";
        public static final String COLUMN_NAME_WICKETS2 = "wickets2";
        public static final String COLUMN_NAME_OVERS2 = "overs2";
        public static final String COLUMN_NAME_BATTING = "batting";
    }
}

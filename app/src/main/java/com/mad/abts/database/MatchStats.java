package com.mad.abts.database;
import android.provider.BaseColumns;
public class MatchStats {
    public MatchStats() {
    }
    public static class MStats implements BaseColumns{
        public static final String TABLE_NAME = "match_stats";
        public static final String COLUMN_NAME_TEAM = "team";
        public static final String COLUMN_NAME_MATCHES = "matches";
        public static final String COLUMN_NAME_WON = "won";
        public static final String COLUMN_NAME_LOST = "lost";
        public static final String COLUMN_NAME_NR = "nr";
        public static final String COLUMN_NAME_POINTS = "points";
        public static final String COLUMN_NAME_WINPERC = "win_perc";
    }
}

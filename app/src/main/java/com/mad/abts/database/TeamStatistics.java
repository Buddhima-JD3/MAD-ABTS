package com.mad.abts.database;

import android.provider.BaseColumns;

public class TeamStatistics {

    public TeamStatistics(){

    }

    public static class TeamStat implements BaseColumns{
        public static final String TABLE_NAME = "teamStatistics";
        //public static final String COLUMN_NAME_TEAMLOGO = "teamlogo";
        public static final String COLUMN_NAME_TEAMNAME = "teamname";
        public static final String COLUMN_NAME_HIGHESTTOTAL = "highesttotal";
        public static final String COLUMN_NAME_LOWESTTOTAL = "lowesttotal";
        public static final String COLUMN_NAME_MOSTRUNS = "mostruns";
        public static final String COLUMN_NAME_MOSTWICKETS = "mostwickets";
        public static final String COLUMN_NAME_BOWLERNAME = "bowlername";
        public static final String COLUMN_NAME_AVERAGE = "average";
    }
}

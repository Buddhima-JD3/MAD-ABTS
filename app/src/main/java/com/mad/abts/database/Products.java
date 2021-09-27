package com.mad.abts.database;

import android.provider.BaseColumns;

public class Products {
    public Products() {
    }
    public static class product implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME_PRODUCTNAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_QUANTITY = "qty";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_TOTPOFIT = "totprofit";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_IMAGE = "img";
    }
}

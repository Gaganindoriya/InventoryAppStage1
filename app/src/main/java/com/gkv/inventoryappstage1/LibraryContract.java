package com.gkv.inventoryappstage1;

import android.provider.BaseColumns;

public class LibraryContract {

    public static class BookEntry implements BaseColumns {
        public static final String TABLE_NAME="books";

        public static final String COLUMN_NAME="name";
        public static final String COLUMN_PRICE="price";
        public static final String COLUMN_QUANTITY="quantity";
        public static final String COLUMN_SUPLIER_NAME="suplier_name";
        public static final String COLUMN_SUPLIER_CONTACT="suplier_contact";



    }
}

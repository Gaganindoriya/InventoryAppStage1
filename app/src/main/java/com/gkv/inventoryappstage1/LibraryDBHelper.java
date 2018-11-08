package com.gkv.inventoryappstage1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_NAME;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_PRICE;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_QUANTITY;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_SUPLIER_CONTACT;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_SUPLIER_NAME;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.TABLE_NAME;

public class LibraryDBHelper extends SQLiteOpenHelper {

    public static final String  DATABASE_NAME="books_db";
    public static final int DTABASE_VERSION=1;

    //create query
    public static final String CREATE_QUERY="CREATE TABLE " +
            TABLE_NAME+"("+
            _ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," +
            COLUMN_NAME+" TEXT, "+
            COLUMN_PRICE+" TEXT,"+
            COLUMN_QUANTITY+" TEXT,"+
            COLUMN_SUPLIER_NAME+" TEXT,"+
            COLUMN_SUPLIER_CONTACT+" TEXT"+
            ")";
    public static final String DROP_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;



    public LibraryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DTABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_QUERY);
        onCreate(db);
    }
}

package com.gkv.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_NAME;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_PRICE;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_QUANTITY;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_SUPLIER_CONTACT;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.COLUMN_SUPLIER_NAME;
import static com.gkv.inventoryappstage1.LibraryContract.BookEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    TextView tv_data;
   LibraryDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_data=findViewById(R.id.data);
        dbHelper=new LibraryDBHelper(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.insert:
                ContentValues contentValues=new ContentValues();
                contentValues.put(COLUMN_NAME,"JAVA");
                contentValues.put(COLUMN_PRICE,"200");
                contentValues.put(COLUMN_QUANTITY,"2");
                contentValues.put(COLUMN_SUPLIER_NAME,"GURUDEV");
                contentValues.put(COLUMN_SUPLIER_CONTACT,"98978464");


                SQLiteDatabase database=dbHelper.getWritableDatabase();
                database.insert(TABLE_NAME,null,contentValues);
                Toast.makeText(this, "1 row inserted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.refresh:
                 displayData();
                 break;

        }
        return true;
    }

    private void displayData() {
        tv_data.setText(null);
        SQLiteDatabase database=dbHelper.getReadableDatabase();
       Cursor cursor= database.query(TABLE_NAME,null,null,null,null,null,null);
       if(cursor.moveToFirst()){
           do{
               String name=cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
               String price=cursor.getString(cursor.getColumnIndex(COLUMN_PRICE));
               String quantity=cursor.getString(cursor.getColumnIndex(COLUMN_QUANTITY));
               String suplier_name=cursor.getString(cursor.getColumnIndex(COLUMN_SUPLIER_NAME));
               String suplier_contact=cursor.getString(cursor.getColumnIndex(COLUMN_SUPLIER_CONTACT));


               String data=name+"\t"+price+"\t"+quantity+"\t"+suplier_name+"\t"+suplier_contact+"\n";

               tv_data.append(data);
           }while (cursor.moveToNext());
       }
       cursor.close();

        Toast.makeText(this, "Refreshed..", Toast.LENGTH_SHORT).show();
    }
}

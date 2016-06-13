package com.example.tanishka.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.text.Editable;
import android.widget.Toast;

import java.net.PasswordAuthentication;

/**
 * Created by Tanishka on 09-03-2016.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "Admission_number";
    public static final String COl_2 = "Name";
    public static final String COL_3 = "Address";
    public static final String COL_4 = "Phone";
    public static final String COL_5 = "Blood_group";
    public static final String COL_6 = "Password";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (Admission_number TEXT PRIMARY KEY   ,Name TEXT ,Address TEXT ,Phone TEXT ,Blood_group TEXT ,Password TEXT  ); ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }

    public boolean insertData(String name, String address, String phone, String admn, String bld, String p) {           //we call it when we register
        SQLiteDatabase db = this.getWritableDatabase();
        long r;

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,admn);
        contentValues.put(COl_2, name);
        contentValues.put(COL_3, address);
        contentValues.put(COL_4, phone);
        contentValues.put(COL_5, bld);
        contentValues.put(COL_6, p);


             r = db.insert(TABLE_NAME, null, contentValues);        //here r will be -1 if it can't be inserted

            db.close();
            if (r == -1)
                return false;
            else
                return true;



        }
      public Cursor getData(String us,String p)              //reading the table

      {
          SQLiteDatabase db=this.getWritableDatabase();               //again we use this function
          Cursor res;


           res=db.rawQuery("SELECT Admission_number,Name,Address,Phone,Blood_group FROM " + TABLE_NAME+" WHERE Admission_number=? AND Password=?", new String[]{String.valueOf(us),String.valueOf(p)});
     return res; }                //rawquery returns a cursor object which contains the rows read
}
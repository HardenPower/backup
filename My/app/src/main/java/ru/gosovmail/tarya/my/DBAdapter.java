package ru.gosovmail.tarya.my;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Администратор on 05.06.2016.
 */
public class DBAdapter {
    private static  final String TAG = "DBAdapter";
    //field names
    public static final String Key_RowID = "_id";
    public static final String Key_TASK = "task";
    public  static final String Key_Date = "date";

    public static final String[] ALL_KEY = new String[]{Key_RowID,Key_TASK,Key_Date};

    //Column Numbers for each Field name
    public static final int COL_ROWID = 0;
    public static final int COL_TASK = 1;
    public static final int COL_DATE = 2;

    //DateBAse info
    public static final String DATABASE_NAME="dbToDo";
    public static final String DATABASE_TABLE= "MAIN TODO";
    public static final int DATABASE_VERSION = 2;

    //SGL STATMENT TO CREATE DATABASE
    public static final String DATABASE_CREATE_SQL = "CREATE TABLE"+DATABASE_TABLE
            +"(" + Key_RowID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    + Key_TASK + "TEXT NOT NULL," + Key_Date + "TEXT" + ");";

    private final Context context3;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx){
        this.context3 = ctx;
        myDBHelper = new DatabaseHelper(context3);
    }

    public  DBAdapter open(){
       // myDBHelper= new DBHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHelper.close();
    }
    //add a new of values to be inserted ito the database
    public long insertRow(String task,String date){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Key_TASK,task);
        initialValues.put(Key_Date,date);
        //insert the data into the database
        return db.insert(DATABASE_TABLE,null,initialValues);
    }
    public boolean deleteRow(long rowID){
        String where = Key_RowID + "=" + rowID;
        return db.delete(DATABASE_TABLE,where,null) !=0;
    }
    public void deleteAll(){
        Cursor c = getAllRows();
        long rowID  = c.getColumnIndexOrThrow(Key_RowID);
        if (c.moveToFirst()){
            do{
                deleteRow(c.getLong((int) rowID));
            } while (c.moveToNext());
        }
        c.close();
    }

// returns all data in the database
    public Cursor getAllRows(){
        String where = null;
        Cursor c = db.query(true,DATABASE_TABLE,ALL_KEY,where,null,null,null,null,null);
                if (c !=null){
                    c.moveToFirst();
                }
        return c;
    }

    public Cursor getRow(long rowID){
        String where = Key_RowID + "=" + rowID;
        Cursor c = db.query(true,DATABASE_TABLE,ALL_KEY,where,null,null,null,null,null);
        if (c != null){
            c.moveToFirst();
        }
        return c;
    }
    public boolean updateRow(long rowID, String task, String date){
        String where = Key_RowID + "=" + rowID;
        ContentValues newValues = new ContentValues();
        newValues.put(Key_TASK,task);
        newValues.put(Key_TASK,date);
        //insert it into the database
        return  db.update(DATABASE_TABLE,newValues,where,null) !=0;
    }

    public void insertRow(String s) {
    }

    public class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading application's database from version" + oldVersion + "to" + newVersion + ",which will destroe all data!");
            //destroy old database
            db.execSQL("Drop Table if exists" + DATABASE_TABLE);
            //recreate new database
            onCreate(db);
        }
    }
}



package com.example.akb_uts_10117216_if7.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, DbContact.DB_NAME, null, DbContact.DB_VERSION);
//        context.deleteDatabase(AppDbHelper.DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String sqlQuery = "CREATE TABLE "+ DbContact.TABLE +" (" +
                DbContact.Columns.C_NIM+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                DbContact.Columns.C_NAMA +" TEXT, "+
                DbContact.Columns.C_KELAS+" TEXT, " +
                DbContact.Columns.C_TELEPON+" TEXT, " +
                DbContact.Columns.C_EMAIL+" TEXT, " +
                DbContact.Columns.C_SOSMED + " TEXT);";
        Log.d("DataHelper","Query to form table: "+sqlQuery);
        sqlDB.execSQL(sqlQuery);
//        sqlDB.execSQL(AppDbHelper.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS "+ DbContact.TABLE);
        Log.d("DataHelper","table: "+sqlDB);
        onCreate(sqlDB);
    }

    public boolean insertData(String nim, String nama, String kelas, String telp, String email, String sosmed){
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContact.Columns.C_NIM, nim);
        contentValues.put(DbContact.Columns.C_NAMA, nama);
        contentValues.put(DbContact.Columns.C_KELAS, kelas);
        contentValues.put(DbContact.Columns.C_TELEPON, telp);
        contentValues.put(DbContact.Columns.C_EMAIL, email);
        contentValues.put(DbContact.Columns.C_SOSMED, sosmed);

        long result = db.insert(DbContact.TABLE, null, contentValues);

        if (result == -1){ return false; }else{ return true; }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM "+ DataContact.TABLE ;
//        Cursor data = db.rawQuery(query + "ORDER BY " + DataContact.Columns._ID + " DESC", null);
        Cursor data = db.query(DbContact.TABLE,
                null,
                null,
                null,
                null,
                null,
                DbContact.Columns.C_NIM);
        return data;
    }

    public Cursor getData(String nim){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("Select * from "+ DbContact.TABLE +" where "+
                DbContact.Columns.C_NIM +"=" + nim + "", null);
        return data;
    }

    public void deleteData(String nim){
        String query = "DELETE FROM " + DbContact.TABLE + " WHERE nim = '"+nim+"'";
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        sqlDB.execSQL(query);
    }

    public void updateData(String nim, String nama, String kelas, String telp, String email, String sosmed){
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DbContact.Columns.C_NAMA, nama);
        cv.put(DbContact.Columns.C_KELAS, kelas);
        cv.put(DbContact.Columns.C_TELEPON, telp);
        cv.put(DbContact.Columns.C_EMAIL, email);
        cv.put(DbContact.Columns.C_SOSMED, sosmed);
        db.update(DbContact.TABLE, cv, DbContact.Columns.C_NIM+ "=" +nim, null);
    }
}

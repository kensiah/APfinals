package com.example.apfinals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AccountDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase.db";

    public AccountDBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + Account.TABLE_NAME + " ("
        + Account.COLUMN_USERNAME + "TEXT, "+Account.COLUMN_PASSWORD + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Account.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertAccount(Account account){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Account.COLUMN_USERNAME,account.getUsername());
        values.put(Account.COLUMN_PASSWORD,account.getPassword());
        db.insert(Account.TABLE_NAME,null,values);
        return true;
    }

    public void updateAccount(Account account){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Account.COLUMN_USERNAME,account.getUsername());
        values.put(Account.COLUMN_PASSWORD,account.getPassword());
        db.update(Account.TABLE_NAME,values,Account.COLUMN_USERNAME + " = ?",
                new String[]{(account.getUsername())});
    }

    public void deleteAccount(String username){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Account.TABLE_NAME,Account.COLUMN_USERNAME + " = ?",
                new String[]{username});
    }

    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> accountArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Account.TABLE_NAME,null);
        res.moveToFirst();

        while(!res.isAfterLast()){
            Account account = new Account();
            account.setUsername(res.getString(res.getColumnIndex(Account.COLUMN_USERNAME)));
            account.setPassword(res.getString(res.getColumnIndex(Account.COLUMN_PASSWORD)));
            accountArrayList.add(account);
        }
        res.close();
        return accountArrayList;
    }
}

package com.android.example.aplikacjazdrowotna;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFood extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Food.db";
    public static final String TABLE_NAME = "Macronutrient_table";
    public static final String COL_1 = "ID"
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PROTEIN(G)";
    public static final String COL_4 = "CARBOHYDRATES(G)";
    public static final String COL_5 = "FAT(G)";
    public static final String COL_6 = "GLYCEMIC INDEX";


    public DatabaseFood( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + TABLE_NAME+ "( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PROTEIN INTEGER, " +
                "CARBOHYDRATES INTEGER, FAT INTEGER, GLYCEMIC_INDEX INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String name, int protein, int carbohydrates, int fat, int glycemic_index){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, protein);
        contentValues.put(COL_4, carbohydrates);
        contentValues.put(COL_5, fat);
        contentValues.put(COL_6, glycemic_index);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        } else {
            return true;
        }


    }
}

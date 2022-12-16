package com.example.curatedfoods;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {



    private static  final  String DB_NAME = "CuratedDB";
    private static  final  int DB_VERSION = 1;
    private static  final  String TB_NAME = "ORDERS";
    private static  final  String ITEM_CL = "stdItem";
    private static  final  String AMOUNT_CL = "stdAmount";

   public DBHelper(Context context){
       super(context, DB_NAME, null,DB_VERSION);
   }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query1 = "CREATE TABLE " + TB_NAME+ "(" +
                ITEM_CL +  " TEXT,"+
                AMOUNT_CL +  " REAL)";
        db.execSQL(query1);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //drop table
        String query = "DROP TABLE " + TB_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public void addItem(String stdItem, Double stdAmount){
       SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ITEM_CL, stdItem);
        values.put(AMOUNT_CL, stdAmount);
        db.insert(TB_NAME, null, values);
        db.close();
    }

    public String displayItems(){
        SQLiteDatabase db = this.getReadableDatabase();
        String data= "";
        Cursor cr = db.rawQuery("SELECT stdItem || ',' || stdAmount || ',' || COUNT(stdItem) FROM " + TB_NAME + " GROUP BY stdItem, stdAmount", null);
        cr.moveToFirst();
        if(cr != null && cr.getCount() > 0){
            do{
                for (int i = 0; i < cr.getColumnCount(); i++) {
                    data = data + " " + cr.getString(i);
                }
                data = data + "\n";
            }while (cr.moveToNext());
        }
        else{
            data = "No data found";
        }
        db.close();
        return data;
    }

    public String deleteItem(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TB_NAME+ " WHERE rowid in (SELECT rowid  FROM " + TB_NAME+ " WHERE " + ITEM_CL  + " =  ?  LIMIT 1 )";

        String[] arguments= new String[]{item};
        db.execSQL(query,arguments );
        db.close();
        return "Deleted";
    }

    public String getCartTotal(){
        SQLiteDatabase db = this.getReadableDatabase();
        Double amount= 0.0;
        Cursor cr = db.rawQuery("SELECT SUM(" + AMOUNT_CL +  ") FROM " + TB_NAME, null);
        cr.moveToFirst();
        String data = cr.getString(0);
        db.close();
        return data;
    }

    public String clearCart(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TB_NAME;
        db.execSQL(query);
        db.close();
        return "No data found";
    }
}

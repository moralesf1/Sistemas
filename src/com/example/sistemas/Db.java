package com.example.sistemas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class Db extends SQLiteOpenHelper {
	private static final String DB_NAME="sistema.sqlite";
	private static final int DB_SCHEME_VERSION=5;
	
	
	public Db(Context context) {
		super(context, DB_NAME, null, DB_SCHEME_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(DB_Manager.CREATE_TABLE);
		db.execSQL(DB_Manager.deuda);
		db.execSQL(DB_Manager.tarjetas);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
		db.execSQL("DROP TABLE IF EXISTS " +DB_Manager.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS deudas");
		db.execSQL("DROP TABLE IF EXISTS tarjetas");
		  onCreate(db);
	}

}
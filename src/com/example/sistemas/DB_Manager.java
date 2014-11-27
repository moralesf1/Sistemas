package com.example.sistemas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB_Manager {
	public static final String TABLE_NAME="usuario";
	public static final String CN_ID="_id";
	public static final String CN_USER="usuario";
	public static final String CN_PASS="clave";
	public static final String CN_EMAIL="correo";
	
		
	public static final String CREATE_TABLE="create table "+TABLE_NAME+" ("
			+CN_ID+" integer primary key autoincrement,"
			+CN_USER+" text not null,"
			+CN_PASS+" text,"
			+CN_EMAIL+" text not null);";
	
	private Db helper;
	private SQLiteDatabase db;
	
	public DB_Manager(Context context){
		
		helper = new Db(context);
        db= helper.getWritableDatabase();  
        
        
        
	}
	
	public ContentValues generarContentValues_registro(String nombre,String clave,String correo){
		
		ContentValues valores=new ContentValues();
		EMD5 md5=new EMD5();
		valores.put(CN_USER, nombre);
		valores.put(CN_PASS, md5.encriptadoMD5(clave));
		valores.put(CN_EMAIL,correo);
		return valores;
	}
	
	public void registrar(String usuario,String clave,String correo){
		
		db.insert(TABLE_NAME, null,generarContentValues_registro(usuario, clave, correo)); //si devuelve -1 es porque ocurrio un problema
		
	}
	public Cursor checkin(String usuario,String clave){
		String[] datos=new String[]{CN_ID,CN_USER,CN_PASS};
		
		return db.query(TABLE_NAME, datos,null,null,null,null,null);
	}
}
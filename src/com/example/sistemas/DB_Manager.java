package com.example.sistemas;

import java.util.ArrayList;

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
	public Cursor cursor;
	
		
	public static final String CREATE_TABLE="create table "+TABLE_NAME+" ("
			+CN_ID+" integer primary key autoincrement,"
			+CN_USER+" text not null,"
			+CN_PASS+" text,"
			+CN_EMAIL+" text not null);";
	
	public static final String deuda="create table deudas (" +
									 "_id integer primary key autoincrement," +
									 "id_usuario integer,nombre text not null," +
									 "deuda integer not null," +
									 "prioridad text not null);";
	
	public static final String tarjetas="create table tarjetas ("+
										"_id integer primary key autoincrement,"+
										"id_usuario integer not null,"+
										"numero_tarjeta integer not null);";
	
	private Db helper;
	private SQLiteDatabase db;
	
	public DB_Manager(Context context){
		
		helper = new Db(context);
        db= helper.getWritableDatabase();  
        
        
        
	}
	public void registrar_deuda(String nombre,String monto,String prioridad,String id_user){
		ContentValues valores=new ContentValues();
		valores.put("id_usuario", id_user);
		valores.put("nombre", nombre);
		valores.put("deuda", monto);
		valores.put("prioridad", prioridad);
		db.insert("deudas",null,valores);
		
		
	}
	public ContentValues generarContentValues_registro(String nombre,String clave,String correo){
		
		ContentValues valores=new ContentValues();
		EMD5 md5=new EMD5();
		valores.put(CN_USER, nombre);
		valores.put(CN_PASS, md5.encriptadoMD5(clave));
		valores.put(CN_EMAIL,correo);
		return valores;
	}
	
	public Boolean registrar(String usuario,String clave,String correo){
		cursor=usuario(usuario);
		if(cursor.moveToNext()){
			return true;
		}
		else{
			db.insert(TABLE_NAME, null,generarContentValues_registro(usuario, clave, correo)); //si devuelve -1 es porque ocurrio un problema
			return false;
		}
		
		
	}
	public Cursor usuario(String user){
		
		
		return db.rawQuery("Select _id from usuario where usuario='"+user+"'",null);
	}
	public Cursor checkin(String user,String clave){
		String pass_MD5;
		EMD5 md5=new EMD5();
		pass_MD5=md5.encriptadoMD5(clave);
		
		return db.rawQuery("Select _id,usuario from usuario where usuario='"+user+"' and clave='"+pass_MD5+"'",null);
	}
	public ArrayList<String> deudas(String id){
		Cursor cursor;
		ArrayList<String> rs = new ArrayList<String>();
		cursor=db.rawQuery("Select _id,nombre,deuda from deudas",null);
		while(cursor.moveToNext()){
			rs.add(cursor.getString(0));
			rs.add(cursor.getString(1));
			rs.add(cursor.getString(2));
		}
		return rs;
	}
	public void up_pass(String pass,String id){
		EMD5 md5=new EMD5();
		ContentValues valores=new ContentValues();
		valores.put("clave",md5.encriptadoMD5(pass));
		db.execSQL("Update usuario Set clave='"+valores.get("clave")+"' where _id="+id);
	}
}








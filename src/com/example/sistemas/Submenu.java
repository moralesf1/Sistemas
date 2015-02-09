package com.example.sistemas;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Submenu extends Activity {
	ArrayList<String> rs = new ArrayList<String>();
	
	EditText nombre_edit;
	EditText monto_edit;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submenu);
		DB_Manager manager=new DB_Manager(this);
		EditText nombre_edit=(EditText)findViewById(R.id.nombre_edit);
		EditText monto_edit=(EditText)findViewById(R.id.monto_edit);
		this.nombre_edit=nombre_edit;
		this.monto_edit=monto_edit;
		SharedPreferences pref=getSharedPreferences("session", Context.MODE_PRIVATE);
		SharedPreferences pref2=getSharedPreferences("item_selected", Context.MODE_PRIVATE);
		Spinner prioridad_spinner=(Spinner)findViewById(R.id.prioridad_edit);
		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.prioridad,android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		prioridad_spinner.setAdapter(adapter);
		//Toast.makeText(this.getApplicationContext(),"id aqui---> "+pref.getString("id","vacio"), Toast.LENGTH_SHORT).show();
		String id_item=pref2.getString("id_item", "vacio");
		
		rs=manager.select_deuda(pref.getString("id", ""), id_item,this.getApplicationContext());
		
		
		nombre_edit.setText(rs.get(0));
		monto_edit.setText(rs.get(1));
		prioridad_spinner.setSelection(Integer.parseInt(rs.get(2)));
		
		
	}

	public void atras(View v){
		Intent intent=new Intent(Submenu.this,Info.class);
		startActivity(intent);
		finish();
	}
	public void update_deuda(View v){
		DB_Manager manager=new DB_Manager(this);
		SharedPreferences pref=getSharedPreferences("item_selected",Context.MODE_PRIVATE);
		SharedPreferences pref2=getSharedPreferences("session",Context.MODE_PRIVATE);
		Spinner prioridad=(Spinner)findViewById(R.id.prioridad_edit);
		manager.up_deuda(nombre_edit.getText().toString(),monto_edit.getText().toString(), prioridad.getSelectedItem().toString(), pref.getString("id_item",""),pref2.getString("id",""));
		Intent intent=new Intent(Submenu.this,Info.class);
		startActivity(intent);
		finish();
	}
	public void delete(View v){
		DB_Manager manager=new DB_Manager(this);
		SharedPreferences pref=getSharedPreferences("item_selected",Context.MODE_PRIVATE);
		manager.delete("deudas", pref.getString("id_item",""),this.getApplicationContext());
		Intent intent=new Intent(Submenu.this,Info.class);
		startActivity(intent);
		finish();
	}
}

package com.example.sistemas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Addgastos extends Activity {
	public Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addgastos);
		Spinner prueba = (Spinner) findViewById(R.id.prioridad);
		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.prioridad,android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		prueba.setAdapter(adapter);
	}
	public void deuda(View v){
		Spinner spinner=(Spinner) findViewById(R.id.prioridad);
		Context context = getApplicationContext();
		EditText nombre_gasto=(EditText) findViewById(R.id.nombre_gasto);
		EditText monto=(EditText) findViewById(R.id.monto);
		SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
        String id=Pref.getString("id", "");
      	DB_Manager manager=new DB_Manager(this);
    	manager.registrar_deuda(nombre_gasto.getText().toString(), monto.getText().toString(), spinner.getSelectedItem().toString(), id);
    	intent=new Intent(Addgastos.this,Info.class);
    	startActivity(intent);
    	finish();
    	
	}
	public void atras(View v){
		intent=new Intent(Addgastos.this,Info.class);
		startActivity(intent);
		finish();
	}
}

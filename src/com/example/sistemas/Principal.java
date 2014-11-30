package com.example.sistemas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		
	}
	public void verificar(View v){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast;
		toast = Toast.makeText(context, "opciones", duration);
		toast.show();
	}
	public void salir(View v){
		SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=Pref.edit();
		editor.putString("id", "");
    	editor.putString("usuario", "");
    	editor.commit();
    	Intent intent=new Intent(Principal.this,Inicio.class);
		startActivity(intent);
		finish();
	}
	public void nuevo(View v){
		Intent intent=new Intent(Principal.this,Addgastos.class);
		startActivity(intent);
	}
}

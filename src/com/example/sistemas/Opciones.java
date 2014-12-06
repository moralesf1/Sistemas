package com.example.sistemas;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Opciones extends Activity {
	public String res;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opciones);
		SharedPreferences Pref =getSharedPreferences("Opciones",Context.MODE_PRIVATE);
		String idioma = null;
        String opcion = Pref.getString("idioma", "es");
        Locale locale = new Locale(opcion);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, 
        getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_opciones); 
        
        if(opcion.equals("en")){
        	idioma="es";
        	
        }
        if(opcion.equals("es")){
        	idioma="en";
        }
        res=idioma;
	}

	public void idioma(View v){
		
		SharedPreferences Pref =getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=Pref.edit();
		editor.putString("idioma", res);
		editor.commit();
	
	
    //creacion del objeto de tipo locate para cambiar el recurso
    Locale locale = new Locale(res);
    Locale.setDefault(locale);
    Configuration config = new Configuration();
    config.locale = locale;
    getBaseContext().getResources().updateConfiguration(config, 
    getBaseContext().getResources().getDisplayMetrics());
    setContentView(R.layout.activity_opciones); 
	}
	public void salir(View v){
		SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=Pref.edit();
		editor.putString("id", "");
    	editor.putString("usuario", "");
    	editor.commit();
    	Intent intent=new Intent(Opciones.this,Inicio.class);
		startActivity(intent);
		finish();
		
	}
	public void atras(View v){
		Intent intent=new Intent(Opciones.this,Principal.class);
		startActivity(intent);
		finish();
		
	}
	public void controls(View v){
		Intent intent=new Intent(Opciones.this,Control.class);
		startActivity(intent);
		finish();
	}
}

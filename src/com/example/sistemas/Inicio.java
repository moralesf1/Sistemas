package com.example.sistemas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class Inicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        SharedPreferences Pref =getPreferences(Context.MODE_PRIVATE);
        String idioma = null;
        final String res;
        String opcion = Pref.getString("idioma", "false");
        final TextView opc=(TextView)findViewById(R.id.opcion);
        Locale locale = new Locale(opcion);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, 
        getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_inicio); 
        opc.setText("esto: "+opcion);
        if(opcion.equals("en")){
        	idioma="es";
        	
        }
        if(opcion.equals("es") || opcion.equals("false")){
        	idioma="en";
        }
        res=idioma;
        
        final Button button = (Button) findViewById(R.id.idioma);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
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
			        setContentView(R.layout.activity_inicio); 
			}
		});  
       
        	
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

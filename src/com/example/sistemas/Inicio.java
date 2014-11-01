package com.example.sistemas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Inicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        String archivo="idioma";
        
        final TextView opc=(TextView)findViewById(R.id.opcion);
        try {
			opc.setText("esto: "+openFileInput(archivo));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        final Button button = (Button) findViewById(R.id.idioma);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 String languageToLoad  = "en";
			        //creacion del objeto de tipo locate para cambiar el recurso
			        Locale locale = new Locale(languageToLoad);
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

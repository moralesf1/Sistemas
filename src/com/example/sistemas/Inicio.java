package com.example.sistemas;




import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class Inicio extends Activity {
	public String res;
	private DB_Manager manager;
	public Cursor cursor;
	public Intent intent;
	private NotificationManager nm; 
	private static final int ID_NOTIFICACION_CREAR = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_inicio);
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Context context = getApplicationContext();
        Intent notificationIntent = new Intent(this, Inicio.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Noti obj=new Noti(nm,contentIntent,context,System.currentTimeMillis());
        
        
        manager=new DB_Manager(this);
        SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
        String id=Pref.getString("id", "");
        SharedPreferences pref =getSharedPreferences("Opciones",Context.MODE_PRIVATE);
		String idioma = null;
        String opcion = pref.getString("idioma", "es");
        
        Locale locale = new Locale(opcion);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, 
        getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_inicio);
        if(!id.equals("")){
        	intent=new Intent(Inicio.this,Principal.class);
    		startActivity(intent);
    		finish();
        }
    	   
       
        	
        
    }
    public void registro(View v){
    	intent=new Intent(Inicio.this,Registro.class);
    	startActivity(intent);
		finish();
    }
    public void ingresar(View v){
    	EditText user=(EditText)findViewById(R.id.user);
    	EditText pass=(EditText)findViewById(R.id.pass);
    	Context context = getApplicationContext();
    	int duration = Toast.LENGTH_SHORT;
    	Toast toast;
    	cursor=manager.checkin(user.getText().toString(),pass.getText().toString());
    	if(cursor.moveToNext()){
    		SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
        	SharedPreferences.Editor editor=Pref.edit();
        	editor.putString("id", cursor.getString(0));
        	editor.putString("usuario", cursor.getString(1));
        	editor.commit();
    		intent=new Intent(Inicio.this,Principal.class);
    		startActivity(intent);
    		finish();
        	

        	
    	}
    	else{
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle(getText(R.string.dialog_important));
    		builder.setMessage(getText(R.string.not_session));
    		builder.setPositiveButton("OK",null);
    		builder.create();
            builder.show();     
    	}
    	
    }
    
}

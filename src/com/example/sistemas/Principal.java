package com.example.sistemas;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends Activity {
	public TextView fecham;
	AlertDialog.Builder DialogBuilder;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		Intent service = new Intent(this, Servicio_noti.class);
		startService(service);
		
		NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent notificationIntent = new Intent(getApplicationContext(),Principal.class);
		PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
		Noti obj=new Noti(nm,contentIntent,getApplicationContext(),System.currentTimeMillis());
		//new Thread().start();
		
		
	}
	public void verificar(View v){
		Intent intent=new Intent(Principal.this,Opciones.class);
		startActivity(intent);
		finish();
	}
	
	
	public void ver(View v){
		Intent intent=new Intent(Principal.this,Info.class);
		startActivity(intent);
		finish();
	}
	
	
	public void ver_tarjeta(View v){
		startActivity(new Intent(Principal.this,Ver_tarjetas.class));
		finish();
	}
	public void ver_mes(View v){
		Manejo_fecha fecha=new Manejo_fecha(this);
		String var;
		var=fecha.get_mes(this, System.currentTimeMillis());
		Toast.makeText(this,"esto "+var, Toast.LENGTH_LONG).show();
	}
}

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

public class Principal extends Activity {
	public TextView fecham;
	AlertDialog.Builder DialogBuilder;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		/*Intent service = new Intent(this, Servicio_noti.class);
		startService(service);*/
		/*Manejo_fecha manager_fecha=new Manejo_fecha(getApplicationContext());
		manager_fecha.fecha_mili(getApplicationContext());*/
		NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent notificationIntent = new Intent(getApplicationContext(),Principal.class);
		PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
		Noti obj=new Noti(nm,contentIntent,getApplicationContext(),System.currentTimeMillis());
		
		
		
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
	
	public void dialog(View v){
		dialog dial=new dialog();
		
		dial.show(getFragmentManager(),null);
	}
	public void ver_tarjeta(View v){
		startActivity(new Intent(Principal.this,Ver_tarjetas.class));
		finish();
	}
}

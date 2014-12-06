package com.example.sistemas;



import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends Activity {
	public TextView fecham;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		Intent service = new Intent(this, Servicio_noti.class);
		startService(service);
		Manejo_fecha manager_fecha=new Manejo_fecha(getApplicationContext());
		 manager_fecha.fecha_mili(getApplicationContext());
		
		
		
		
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
	public void verfecha(View v){
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}
}

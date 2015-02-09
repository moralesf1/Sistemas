package com.example.sistemas;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pagar extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagar);
	}

	public void select_tarjeta(View v){
		final Spinner spinner=(Spinner)findViewById(R.id.spinner_pagar);
		
		spinner.setClickable(true);
		TextView pagar=(TextView)findViewById(R.id.edit_pagar);
		ArrayList<Lista_Tarjeta> datos = new ArrayList<Lista_Tarjeta>();
		pagar.setEnabled(false);
		RadioButton radio1=(RadioButton)findViewById(R.id.radio_dinero);
		SharedPreferences pref=getSharedPreferences("session", Context.MODE_PRIVATE);
		DB_Manager manager=new DB_Manager(this);
		ArrayList<String> rs=new ArrayList<String>();
		rs=manager.ver_tarjetas(this,pref.getString("id",""));
		Toast.makeText(this.getApplicationContext(),"id aqui---> "+rs.get(1), Toast.LENGTH_SHORT).show();
		radio1.setChecked(false);
		if(!rs.isEmpty()){
			for(int i=0; i<rs.size()-2; i=i+3)
			{    
					//Nuevo elemento a la lista
				
					datos.add(new Lista_Tarjeta(rs.get(i),rs.get(i+1),rs.get(i+2),""));
				
				
        	}
		}
		
		
		
		
		spinner.setAdapter(new Adapter(this,R.layout.formatospinner_pagar_tarjeta,datos) {
			
			@Override
			public void onEntrada(Object entrada, View view) {
				// TODO Auto-generated method stub
				TextView texto1=(TextView)view.findViewById(R.id.banco_pagar_tarjeta);
				texto1.setText(((Lista_Tarjeta)entrada).getBanco());
				TextView texto2=(TextView)view.findViewById(R.id.tarjeta_num_pagar);
				texto2.setText(((Lista_Tarjeta)entrada).getNumero());
				TextView texto3=(TextView)view.findViewById(R.id.id_tarjeta_paga);
				texto3.setText(((Lista_Tarjeta)entrada).getId());
				
			}
		});
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Lista_Tarjeta lista=(Lista_Tarjeta) parent.getItemAtPosition(position);
				TextView texto=(TextView)findViewById(R.id.id_tarjeta_apagar);
				texto.setText(lista.getId());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void select_dinero(View v){
		RadioButton radio2=(RadioButton)findViewById(R.id.radio_tarjeta);
		radio2.setChecked(false);
		Spinner spinner=(Spinner)findViewById(R.id.spinner_pagar);
		spinner.setClickable(false);
		spinner.setAdapter(null);
		TextView pagar=(TextView)findViewById(R.id.edit_pagar);
		pagar.setEnabled(true);
	}
	public void pagar_tarjeta(View v){
		TextView texto=(TextView)findViewById(R.id.id_tarjeta_apagar);
		ArrayList<String> rs2=new ArrayList<String>();
		String rs1;
		SharedPreferences pref=getSharedPreferences("session",Context.MODE_PRIVATE);
		Spinner spinner=(Spinner)findViewById(R.id.spinner_pagar);
		DB_Manager manager=new DB_Manager(this);
		rs1=manager.ver_tarjeta_pagar(pref.getString("id",""),texto.getText().toString());
		SharedPreferences pref2=getSharedPreferences("item_selected",Context.MODE_PRIVATE);
		rs2=manager.select_deuda(pref.getString("id",""),pref2.getString("id_item",""),this);
	}
}

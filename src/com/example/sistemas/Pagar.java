package com.example.sistemas;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
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
		
		ArrayList<Lista_Tarjeta> datos = new ArrayList<Lista_Tarjeta>();
		
		RadioButton radio1=(RadioButton)findViewById(R.id.radio_dinero);
		SharedPreferences pref=getSharedPreferences("session", Context.MODE_PRIVATE);
		DB_Manager manager=new DB_Manager(this);
		ArrayList<String> rs=new ArrayList<String>();
		rs=manager.ver_tarjetas(this,pref.getString("id",""));
		//Toast.makeText(this.getApplicationContext(),"id aqui---> "+rs.get(1), Toast.LENGTH_SHORT).show();
		radio1.setChecked(false);
		if(!rs.isEmpty()){
			for(int i=0; i<rs.size()-2; i=i+4)
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
		
		
	}
	public void pagar_tarjeta(View v){
		RadioButton radio1=(RadioButton)findViewById(R.id.radio_tarjeta);
		SharedPreferences pref=getSharedPreferences("session",Context.MODE_PRIVATE);
		SharedPreferences pref2=getSharedPreferences("item_selected",Context.MODE_PRIVATE);
		DB_Manager manager=new DB_Manager(this);
		if(radio1.isChecked()){
			TextView texto=(TextView)findViewById(R.id.id_tarjeta_apagar);
			ArrayList<String> rs2=new ArrayList<String>();
			String rs1;
			int deuda_total;
			
			
			
			rs1=manager.ver_tarjeta_pagar(pref.getString("id",""),texto.getText().toString());
			
			rs2=manager.select_deuda(pref.getString("id",""),pref2.getString("id_item",""),this);
			deuda_total=Integer.parseInt(rs1)+Integer.parseInt(rs2.get(1).toString());
			//Toast.makeText(this.getApplicationContext(),"id aqui---> "+rs2.get(1), Toast.LENGTH_SHORT).show();
			manager.up_deuda_tarjeta(pref.getString("id",""),texto.getText().toString(),Integer.toString(deuda_total),pref2.getString("id_item",""),this,radio1.isChecked());
		}
		if(!radio1.isChecked()){
			manager.up_deuda_tarjeta(pref.getString("id",""),"0","0",pref2.getString("id_item",""),this,radio1.isChecked());
		}
		startActivity(new Intent(Pagar.this,Info.class));
		finish();
	}
	public void cancelar(View v){
		startActivity(new Intent(Pagar.this,Info.class));
		finish();
	}
}

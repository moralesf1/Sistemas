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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Ver_tarjetas extends Activity {
	ArrayList<Lista_Tarjeta> datos = new ArrayList<Lista_Tarjeta>();
	
	ArrayList<String> rs = new ArrayList<String>();
	ListView lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		SharedPreferences pref=getSharedPreferences("session", Context.MODE_PRIVATE);
		String id=pref.getString("id", "");
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		DB_Manager manager=new DB_Manager(this);
		rs=manager.ver_tarjetas(this,pref.getString("id", ""));
		
		
		if(!rs.isEmpty()){
			for(int i=0; i<rs.size()-2; i=i+3)
			{    
					//Nuevo elemento a la lista
				
					datos.add(new Lista_Tarjeta(rs.get(i),rs.get(i+1),rs.get(i+2),rs.get(i+3)));
				
				
        	}
		}
		
		
		
		
		
		
		
		lista=(ListView)findViewById(R.id.lista);
		
    	lista.setAdapter(new Adapter(this, R.layout.formatolista_tarjeta, datos){
		@Override
			public void onEntrada(Object entrada, View view) {
				// ve esto  mas corto  Toast.makeText(arg0.getContext(), "FUNCIONO :): " + arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
			TextView banco=(TextView)view.findViewById(R.id.banco_pagar_tarjeta);
			banco.setText(((Lista_Tarjeta)entrada).getBanco());
            TextView texto1 = (TextView) view.findViewById(R.id.tarjeta_num_pagar); 
            texto1.setText(((Lista_Tarjeta) entrada).getNumero()); 
            TextView texto2=(TextView)view.findViewById(R.id.id_tarjeta);
            texto2.setText(((Lista_Tarjeta) entrada).getId());
            TextView texto3=(TextView)view.findViewById(R.id.deuda_en_tarjeta);
            texto3.setText(((Lista_Tarjeta)entrada).getDeuda());
				
	            

	            
			}
		});	
    	lista.setOnItemClickListener(new OnItemClickListener() { 
    		
      		 public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
         	 Lista_Tarjeta item = (Lista_Tarjeta) pariente.getItemAtPosition(posicion);
         	 //Toast.makeText(getApplicationContext(), "Milliseconds= "+item.getId(), Toast.LENGTH_SHORT).show();
         	SharedPreferences pref=getSharedPreferences("tarjeta", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            editor.putString("id_tarjeta", item.getId());
            editor.putString("nombre_Banco", item.getBanco());
            editor.putString("numero", item.getNumero());
            editor.commit();
            
            
             
		             
       	}
   	 });
		
	}
	public void nuevo(View v){
		
	}
	public void atras(View v){
		
	}
	
	
}

package com.example.sistemas;

import java.util.ArrayList;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterViewFlipper;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class Info extends Activity {
	ArrayList<Lista_E> datos = new ArrayList<Lista_E>();
	
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
		rs=manager.deudas(id);
		Toast toast;
		
		if(!rs.isEmpty()){
			for(int i=0; i<rs.size()-2; i=i+3)
			{    
					//Nuevo elemento a la lista
				
					datos.add(new Lista_E(rs.get(i),rs.get(i+1),rs.get(i+2)));
				
				
        	}
		}
		
		
		
		
		
		
		
		lista=(ListView)findViewById(R.id.lista);
		
    	lista.setAdapter(new Adapter(this, R.layout.formatolista, datos){
		@Override
			public void onEntrada(Object entrada, View view) {
				// ve esto  mas corto  Toast.makeText(arg0.getContext(), "FUNCIONO :): " + arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
		   
				TextView textoid=(TextView)view.findViewById(R.id.id_item);
				textoid.setText(((Lista_E)entrada).getId());
	            TextView texto1 = (TextView) view.findViewById(R.id.banco); 
	            texto1.setText(((Lista_E) entrada).getNombre()); 
	            TextView texto2=(TextView)view.findViewById(R.id.tarjeta_num);
	            texto2.setText(((Lista_E) entrada).getDeuda());
	            

	            
			}
		});	
    	lista.setOnItemClickListener(new OnItemClickListener() { 
    		
      		 public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
         	 Lista_E item = (Lista_E) pariente.getItemAtPosition(posicion); 
         	 //Toast.makeText(getApplicationContext(), "Milliseconds= "+item.getId(), Toast.LENGTH_SHORT).show();
         	SharedPreferences pref=getSharedPreferences("item_selected", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            editor.putString("id_item", item.getId());
            editor.putString("nombre_item", item.getNombre());
            editor.putString("monto", item.getDeuda());
            editor.commit();
            Intent intent=new Intent(Info.this,Submenu.class);
            startActivity(intent);
            
             
		             
       	}
   	 });
		
	}
	public void nuevo(View v){
		Intent intent=new Intent(Info.this,Addgastos.class);
		startActivity(intent);
		finish();
	}
	public void atras(View v){
		Intent intent=new Intent(Info.this,Principal.class);
		startActivity(intent);
		finish();
	}
	
	
}

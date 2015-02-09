package com.example.sistemas;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class ver_tarjeta extends DialogFragment {
	ArrayList<Lista_Tarjeta> datos = new ArrayList<Lista_Tarjeta>();
	ListView lista;
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		
		
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		View v = inflater.inflate(R.layout.activity_ver_tarjeta, container, false);
		lista=(ListView)v.findViewById(R.id.ver_tarjetas);
		ArrayList<String> rs = new ArrayList<String>();
		
		DB_Manager manager=new DB_Manager(getActivity().getApplicationContext());
		rs=manager.ver_tarjetas(getActivity().getApplicationContext());
		if(!rs.isEmpty()){
			for(int i=0; i<rs.size()-2; i=i+3)
			{    
					//Nuevo elemento a la lista
				
					datos.add(new Lista_Tarjeta(rs.get(i),rs.get(i+1),rs.get(i+2)));
				
				
        	}
		}
		lista.setAdapter(new Adapter(getActivity().getApplicationContext(), R.layout.activity_ver_tarjeta,datos) {
			
			
			public void onEntrada(Object entrada, View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(),"esto--->"+(TextView)view.findViewById(R.id.banco_tarjeta), Toast.LENGTH_SHORT).show();
				String banco_tarjeta;
				banco_tarjeta=((Lista_Tarjeta)entrada).getBanco();
				/*TextView banco=(TextView)view.findViewById(R.id.banco);
				banco.setText(((Lista_Tarjeta)entrada).getBanco());
				TextView id_tarjeta=(TextView)view.findViewById(R.id.id_tarjeta);
				id_tarjeta.setText(((Lista_Tarjeta)entrada).getId());
				TextView numero=(TextView)view.findViewById(R.id.numero_tarjeta);
				numero.setText(((Lista_Tarjeta)entrada).getNumero());*/
				
				
			}
		});
		return v;
		
	}
	
	
}

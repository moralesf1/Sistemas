package com.example.sistemas;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class dialog extends DialogFragment {

	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		
		
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		 View v = inflater.inflate(R.layout.activity_dialog, container, false);
		Button agregar=(Button)v.findViewById(R.id.agregar_tar);
		Button cancelar=(Button)v.findViewById(R.id.cancel_tar);
		final EditText tarjeta=(EditText)v.findViewById(R.id.edit_tarjeta);
		final EditText numero=(EditText)v.findViewById(R.id.numero_tarjeta);
		agregar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Context context=getActivity().getApplicationContext();
				DB_Manager manager=new DB_Manager(context);
				SharedPreferences pref=getActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
				//Toast.makeText(context,"entro y mando esto "+pref.getString("id", ""), Toast.LENGTH_SHORT).show();
				manager.registrar_tarjeta(context, tarjeta.getText().toString(),numero.getText().toString(),pref.getString("id",""));
				
			}
		});
		cancelar.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				Toast.makeText(getActivity().getApplicationContext(),"cancelar", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		return v;
		
	}
	
	
}

package com.example.sistemas;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class Registro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		final EditText usuario=(EditText)findViewById(R.id.user_reg);
		usuario.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				usuario.setError(Html.fromHtml("<font color='black'>holis</font>"));
				
			}
		});
	}
	public void registrar(View v){
		DB_Manager manager=new DB_Manager(this);
		Boolean opc=true,ret=true;
		EditText usuario=(EditText)findViewById(R.id.user_reg);
		EditText pass=(EditText)findViewById(R.id.pass_reg);
		EditText correo=(EditText)findViewById(R.id.correo);
		if(usuario.getText().length()==0){
			usuario.setError(Html.fromHtml("<font color='black'>Debe escribir un usuario</font>"));
			opc=false;
		}
		if(pass.getText().length()==0){
			pass.setError(Html.fromHtml("<font color='black'>Debe escribir una clave</font>"));
			opc=false;
		}
		if(correo.getText().length()==0){
			correo.setError(Html.fromHtml("<font color='black'>Debe escribir un correo</font>"));
			opc=false;
		}
		if(opc){
			ret=manager.registrar(usuario.getText().toString(), pass.getText().toString(), correo.getText().toString());
		}
		if(ret){
			usuario.setError(Html.fromHtml("<font color='black'>el usuario ya existe</font>"));
		}
		
		
	}
}

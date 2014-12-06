package com.example.sistemas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;

public class Registro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		
		
			
			
			
	}
	public void registrar(View v){
		DB_Manager manager=new DB_Manager(this);
		Boolean opc=true,ret=false;
		EditText usuario=(EditText)findViewById(R.id.user_reg);
		EditText pass=(EditText)findViewById(R.id.pass_reg);
		EditText correo=(EditText)findViewById(R.id.correo);
		if(usuario.getText().length()==0){
			usuario.setError(Html.fromHtml("<font color='red'>"+getText(R.string.empty_user)+"</font>"));
			opc=false;
		}
		if(pass.getText().length()==0){
			pass.setError(Html.fromHtml("<font color='red'>"+getText(R.string.empty_pass)+"</font>"));
			opc=false;
		}
		if(correo.getText().length()==0){
			correo.setError(Html.fromHtml("<font color='red'>"+getText(R.string.empty_email)+"</font>"));
			opc=false;
		}
		if(opc){
			ret=manager.registrar(usuario.getText().toString(), pass.getText().toString(), correo.getText().toString());
		}
		if(ret){
			usuario.setError(Html.fromHtml("<font color='red'>el usuario ya existe</font>"));
		}
		
		
	}
	public void cancelar(View v){
		Intent intent=new Intent(Registro.this,Inicio.class);
		startActivity(intent);
		finish();
	}
}

package com.example.sistemas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Control extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);
	}

	public void atras(View v){
		Intent intent=new Intent(Control.this,Opciones.class);
		startActivity(intent);
		finish();
	}
	public void update(View v){
		DB_Manager manager=new DB_Manager(this);
		SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
        String id=Pref.getString("id", "");
		EditText pass=(EditText)findViewById(R.id.change_pass);
		EditText re_pass=(EditText)findViewById(R.id.re_change);
		Toast.makeText(getApplicationContext(), Boolean.toString(pass.getText().toString().equals(re_pass.getText().toString())), Toast.LENGTH_SHORT).show();
		if(pass.getText().toString().equals(re_pass.getText().toString())){
			manager.up_pass(pass.getText().toString(),id);
			SharedPreferences.Editor editor=Pref.edit();
			editor.putString("id", "");
	    	editor.putString("usuario", "");
	    	editor.commit();
	    	Intent intent=new Intent(Control.this,Inicio.class);
			startActivity(intent);
			finish();
		}
		else if(!pass.getText().toString().equals(re_pass.getText().toString())){
			re_pass.setError("<font color='red'>"+getText(R.string.notmatch)+"</font>");
		}
		
	}
}

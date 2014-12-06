package com.example.sistemas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Submenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submenu);
	}

	public void atras(View v){
		Intent intent=new Intent(Submenu.this,Info.class);
		startActivity(intent);
		finish();
	}
}

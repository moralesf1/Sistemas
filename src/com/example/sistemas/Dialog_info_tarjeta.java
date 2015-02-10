package com.example.sistemas;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class Dialog_info_tarjeta extends DialogFragment {

public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		
		
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		View v = inflater.inflate(R.layout.activity_dialog_info_tarjeta, container, false);
		 
		 
		 return v;
}
}

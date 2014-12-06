package com.example.sistemas;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

public class Fragment1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Importante");
        builder.setMessage("Este es un programa solo de prueba y no la versión completa");
        builder.setPositiveButton("OK",null);
        builder.create();
        builder.show();        
    }
}
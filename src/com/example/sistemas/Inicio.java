package com.example.sistemas;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class Inicio extends Activity {
	public String res;
	private DB_Manager manager;
	public Cursor cursor;
	public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        manager=new DB_Manager(this);
        SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
        String id=Pref.getString("id", "");
        String usuario=Pref.getString("usuario", "");
        if(!id.equals("")){
        	intent=new Intent(Inicio.this,Principal.class);
    		startActivity(intent);
    		finish();
        }
    	   
       
        	
        
    }
    public void registro(View v){
    	intent=new Intent(Inicio.this,Registro.class);
    	startActivity(intent);
    }
    public void ingresar(View v){
    	EditText user=(EditText)findViewById(R.id.user);
    	EditText pass=(EditText)findViewById(R.id.pass);
    	Context context = getApplicationContext();
    	int duration = Toast.LENGTH_SHORT;
    	Toast toast;
    	cursor=manager.checkin(user.getText().toString(),pass.getText().toString());
    	if(cursor.moveToNext()){
    		SharedPreferences Pref =getSharedPreferences("session",Context.MODE_PRIVATE);
        	SharedPreferences.Editor editor=Pref.edit();
        	editor.putString("id", cursor.getString(0));
        	editor.putString("usuario", cursor.getString(1));
        	editor.commit();
    		intent=new Intent(Inicio.this,Principal.class);
    		startActivity(intent);
    		finish();
        	CharSequence text = "ENTROO!";
        	

        	toast = Toast.makeText(context, text, duration);
        	toast.show();
        	toast=Toast.makeText(context,cursor.getString(1), duration);
        	toast.show();
    	}
    	else{
    		toast=Toast.makeText(context,"no entro", duration);
    		toast.show();
    	}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

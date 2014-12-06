package com.example.sistemas;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Servicio_noti extends Service {

	 private Timer mTimer = null; 
	 @Override
	 public IBinder onBind(Intent arg0) {
	  return null;
	 }
	 
	 @Override
	 public void onCreate(){
	  super.onCreate();
	  this.mTimer = new Timer();
	  this.mTimer.scheduleAtFixedRate(
	    new TimerTask(){
	     @Override
	     public void run() {
	      ejecutarTarea();
	     }      
	    }
	    , 0, 1000*60);
	 }
	 
	 private void ejecutarTarea(){
	  Thread t = new Thread(new Runnable() {
	   public void run() {
	    NotifyManager notify = new NotifyManager();
	    notify.playNotification(getApplicationContext(),
	      Principal.class, "Hola"
	      , "Budget Family", R.drawable.ic_launcher); 
	    
	   }
	  });  
	  t.start();
	 }

	}
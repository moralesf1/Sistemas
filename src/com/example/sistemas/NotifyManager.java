package com.example.sistemas;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class NotifyManager {
	 
	public void playNotification(Context context, Class<?> cls, String textNotification, String titleNotification, int drawable){
	   
		/*NOTIFICATION VARS*/
		 NotificationManager mNotificationManager;
		 int SIMPLE_NOTIFICATION_ID = 1; 
		 Notification notifyDetails;
		 /*NOTIFICATION INICIO*/
		 mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		 notifyDetails = new Notification(drawable,titleNotification,System.currentTimeMillis());
		
		     
		 /*NOTIFICATION FIN*/ 
		  
		 CharSequence contentTitle = titleNotification;
		 CharSequence contentText = textNotification;
		 
		 Intent notifyIntent = new Intent(context, cls );
		 
		 notifyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		     
		 PendingIntent intent = PendingIntent.getActivity(context, 0, notifyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
		     
		 notifyDetails.tickerText = textNotification;
		 notifyDetails.setLatestEventInfo(context, contentTitle, contentText, intent);
		    
		 try{
			 mNotificationManager.notify(SIMPLE_NOTIFICATION_ID, notifyDetails);     
		 } catch(Exception e){
		      
		 }
	}
 
}
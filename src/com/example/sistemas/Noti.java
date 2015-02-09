package com.example.sistemas;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.Toast;

public class Noti {
	private static final int ID_NOTIFICACION_CREAR = 1;
	public Noti(NotificationManager nm,PendingIntent contentIntent, Context context,long when) {
		int icon=R.drawable.ic_launcher;
        CharSequence ticket="Muestra 1";
		Notification notification = new Notification(icon, ticket, when);
		
		int duration = Toast.LENGTH_SHORT;
		//Toast toast;
		//toast = Toast.makeText(context, Integer.toString((int) when), duration);
		//toast.show();
        CharSequence contentTitle = "Muestra 2";
        CharSequence contentText = "muestra 3";
        // = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        nm.notify(ID_NOTIFICACION_CREAR,notification);
	}
	
}

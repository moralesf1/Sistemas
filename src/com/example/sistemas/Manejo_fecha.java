package com.example.sistemas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class Manejo_fecha {
	String ret;
	public Manejo_fecha(Context context) {
		
		
	}
	public String fecha_mili(Context context,long fech){
		Long fecha=fech;
		//Toast.makeText(context, "min= "+fecha, Toast.LENGTH_SHORT).show();
		String fechaInicio;
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(fecha);
		final SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
		 fechaInicio=formato.format(c.getTime());
		 
		 
				
		
		return fechaInicio;
	}
	public String get_mes(Context context,long fech){
		Long fecha=fech;
		//Toast.makeText(context, "min= "+fecha, Toast.LENGTH_SHORT).show();
		String fechaInicio;
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(fecha);
		final SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
		 fechaInicio=formato.format(c.getTime());
		 String[] array=fechaInicio.split("/");
		 return array[1];
	}
}

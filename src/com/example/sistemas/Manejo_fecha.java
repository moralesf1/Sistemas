package com.example.sistemas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class Manejo_fecha {

	public Manejo_fecha(Context context) {
		
		
	}
	public long fecha_mili(Context context){
		String fecha="02/12/2014";
		Date fechaInicio = null;
		Calendar calendarInicio = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 try {
			fechaInicio = formato.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendarInicio.setTime(fechaInicio);
		long milisegundos1 = calendarInicio.getTimeInMillis();
		long milisegundosactual=System.currentTimeMillis();
		long dif=milisegundos1-milisegundosactual;
		long dif_h=dif/(60*60*1000);
		long dif_m=dif/(60*1000);
		Toast.makeText(context, "Milliseconds= "+dif, Toast.LENGTH_SHORT).show();
		Toast.makeText(context, "min= "+dif_m, Toast.LENGTH_SHORT).show();
		
		return milisegundos1;
	}

}

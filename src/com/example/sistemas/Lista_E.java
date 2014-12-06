package com.example.sistemas;

public class Lista_E {
	private String nombre;
	private String deuda;
	private String id;
	public Lista_E(String id,String nombre,String deuda) {
		this.id=id;
		this.nombre=nombre;
		this.deuda=deuda;
	}
	public String getNombre(){
		return nombre;
	}
	public String getDeuda(){
		return deuda;
	}
	public String getId(){
		return id;
	}

}

package com.example.sistemas;

public class Lista_E {
	private String nombre;
	private String deuda;
	private String id;
	private String estado;
	private String mes;
	public Lista_E(String id,String nombre,String deuda,String estado,String mes) {
		this.id=id;
		this.nombre=nombre;
		this.deuda=deuda;
		this.estado=estado;
		this.mes=mes;
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
	public String getEstado(){
		return estado;
	}
	public String getMes() {
		return mes;
	}
	
}

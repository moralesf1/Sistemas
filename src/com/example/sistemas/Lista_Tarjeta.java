package com.example.sistemas;

public class Lista_Tarjeta {
	private String banco;
	private String numero;
	private String id;
	public Lista_Tarjeta(String id,String banco,String numero) {
		this.id=id;
		this.banco=banco;
		this.numero=numero;
	}
	public String getBanco(){
		return banco;
	}
	public String getNumero(){
		return numero;
	}
	public String getId(){
		return id;
	}

}

package com.example.sistemas;

public class Lista_Tarjeta {
	private String banco;
	private String numero;
	private String id;
	private String deuda_tarjeta;
	public Lista_Tarjeta(String id,String banco,String numero,String deuda_tarjeta) {
		this.id=id;
		this.banco=banco;
		this.numero=numero;
		this.deuda_tarjeta=deuda_tarjeta;
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
	public String getDeuda(){
		return deuda_tarjeta;
	}

}

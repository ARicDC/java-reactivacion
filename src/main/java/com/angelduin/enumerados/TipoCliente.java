package com.angelduin.enumerados;

public enum TipoCliente {
	
	ESTANDAR("Estandar"), SILVER("Silver"), GOLD("Gold"), PLATINUM("Platinum");
	
	private String identificador;
	
	TipoCliente(String identificador){
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
	
}

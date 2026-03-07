package com.angelduin.entidades;

import com.angelduin.clasesabstractas.Persona;
import com.angelduin.interfaces.Exportable;
import com.angelduin.enumerados.TipoCliente;

public class Cliente extends Persona implements Exportable{
	
	private TipoCliente tipoCliente;
	private String idCliente;
	private static int id;
	
	public Cliente(String nombre, String email, String dir, int edad, TipoCliente tipoCliente){
		super(nombre, email, dir, edad);
		this.tipoCliente = tipoCliente;
		this.idCliente = id++ + "-" + tipoCliente.getIdentificador().substring(0, 1) + "-" + nombre.split(" ")[0].substring(0,1) + 
						 nombre.split(" ")[1].substring(0, 1);
	}
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	@Override
	public void presentarse() {
		System.out.printf("Hola mi nombre es %s. Tengo %d años y vivo en %s. \nSoy un cliente %s y mi Id de cliente es %s\n", 
						  super.getNombre(), super.getEdad(),super.getDir(), getTipoCliente().getIdentificador(), getIdCliente());
	}
	
	@Override
	public void exportarDatos() {
		System.out.printf("%s,%s,%s,%d,%s,%s\n", super.getNombre(), super.getEmail(), super.getDir(), super.getEdad(),
												   getTipoCliente().getIdentificador(), getIdCliente());
	}
	
	
}

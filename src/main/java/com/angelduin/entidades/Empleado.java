package com.angelduin.entidades;

import com.angelduin.clasesabstractas.Persona;
import com.angelduin.interfaces.Exportable;

public class Empleado extends Persona implements Exportable {
	
	private String cargo;
	private double salario;
	
	public Empleado(String nombre, String email, String dir, int edad, String cargo, double salario){
		super(nombre, email, dir, edad);
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public String getCargo() {
		return this.cargo;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	
	@Override
	public void presentarse() {
		System.out.printf("Hola mi nombre es %s. Tengo %d años y vivo en %s.\n", getNombre(), getEdad(), getDir());
		System.out.printf("Ocupo el cargo de %s y percibo un ingreso de %.2f\n", getCargo(), getSalario());
	}
	
	@Override
	public void exportarDatos() {
		System.out.printf("%s,%s,%s,%d,%s,%.2f\n", getNombre(), getEmail(), getDir(), getEdad(),
												   getCargo(),getSalario());
	}
	
	
}

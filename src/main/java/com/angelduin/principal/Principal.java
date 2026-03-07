package com.angelduin.principal;
import java.util.ArrayList;
import java.util.Scanner;

import com.angelduin.clasesabstractas.Persona;
import com.angelduin.enumerados.TipoCliente;
import com.angelduin.entidades.*;
import com.angelduin.interfaces.Exportable;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Persona> lista = new ArrayList<>();
		ArrayList<Exportable> listaExportable = new ArrayList<>();
		System.out.println("\n---------------------------------------EMPLEADO-------------------------------------------\n");
		Empleado empleado_1 = crearEmpleado();
		System.out.println("\n----------------------------------------CLIENTE-------------------------------------------\n");
		Cliente cliente_1 = crearCliente();
		System.out.println("\n------------------------------------------------------------------------------------------\n");
		
		lista.add(empleado_1);
		lista.add(cliente_1);
		
		listaExportable.add(empleado_1);
		listaExportable.add(cliente_1);
		for(Persona p: lista) {
			p.presentarse();		
		}
		
		for(Exportable p: listaExportable) {
			p.exportarDatos();
		}
		
		sc.close();
	}
	
	/*public static Persona crearPersona() {
		
		String nombre="", email="", direccion="", edadS="";
		int edad = 0;
		final int edadMin = 0, edadMax = 120;
		String regexNombre = "^[A-Z][A-Za-z]+\\s[A-Z][A-Za-z]+$";
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String regexDireccion = "^[\\w.]+(?:\\s[\\w.]+)+$";
		String regexEdad = "^[\\d]{1,3}$";
		
		do {
			System.out.print("Ingrese el nombre de la persona: ");
			nombre = sc.nextLine().trim();
		}while(!validarCampo(nombre, regexNombre));

		do{
			System.out.print("Ingrese el email de la persona: ");
			email = sc.nextLine().trim();
		}while(!validarCampo(email, regexEmail));

		do {
			System.out.print("Ingrese la direccion de la persona: ");
			direccion = sc.nextLine();
		}while(!validarCampo(direccion, regexDireccion));

		do{
			System.out.print("Ingrese la edad de la persona: ");
			edadS = sc.nextLine();
		}while(!validarCampo(edadS, regexEdad, edadMin, edadMax));

		edad = Integer.parseInt(edadS);
		
		return new Persona(nombre, email, direccion, edad);
	}*/
	
	public static Cliente crearCliente() {
		PersonaDTO dto = pedirDatos();
		return new Cliente(dto.nombre, dto.email, dto.direccion, dto.edad, pedirTipoCliente());
	}
	
	public static Empleado crearEmpleado() {
		
		PersonaDTO dto = pedirDatos();
		//String cargo= pedirCargo(); 
		//double salario = pedirSalario();
		return new Empleado(dto.nombre, dto.email, dto.direccion, dto.edad, pedirCargo(), pedirSalario());
	}
	
	public static PersonaDTO pedirDatos() {
		
		PersonaDTO dto = new PersonaDTO();
		dto.nombre = pedirNombre();
		dto.email = pedirEmail();
		dto.direccion = pedirDireccion();
		dto.edad = pedirEdad();
		
		return dto;
	}
	
	public static String pedirNombre() {
		
		String nombre  = "";
		String regexNombre = "^[A-Z][A-Za-z]+\\s[A-Z][A-Za-z]+$";
		do {
			System.out.print("Ingrese el nombre de la persona: ");
			nombre = sc.nextLine().trim();
		}while(!validarCampo(nombre, regexNombre));
		
		return nombre;
	}
	
	public static String pedirEmail() {
		String email = "";
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		
		do{
			System.out.print("Ingrese el email de la persona: ");
			email = sc.nextLine().trim();
		}while(!validarCampo(email, regexEmail));
		
		return email;
	}
	
	public static String pedirDireccion() {
		
		String direccion = "";
		String regexDireccion = "^[\\w.]+(?:\\s[\\w.]+)+$";
		
		do {
			System.out.print("Ingrese la direccion de la persona: ");
			direccion = sc.nextLine();
		}while(!validarCampo(direccion, regexDireccion));
		
		return direccion;
	}
	
	public static int pedirEdad() {
		String edadS = "";
		int edad = 0;
		final int edadMin = 0, edadMax = 120;
		String regexEdad = "^[\\d]{1,3}$";
		
		do{
			System.out.print("Ingrese la edad de la persona: ");
			edadS = sc.nextLine();
		}while(!validarCampo(edadS, regexEdad, edadMin, edadMax));
		
		edad = Integer.parseInt(edadS);
		return edad;
	}
	
	public static String pedirCargo() {
		
		String cargo="";
		String regexCargo = "^[A-Z][a-zA-Z]+((?:\\s[a-zA-Z]+)+)?$";
		
		do {
			System.out.print("Ingrese el cargo del empleado: ");
			cargo = sc.nextLine();
		}while(!validarCampo(cargo, regexCargo));
		
		return cargo;
	}

	public static double pedirSalario() {
		double salario;
		String salarioS = "";
		final double salarioMin = 1500000d; //Se asume este valor como un posible salario mínimo
		final double salarioMax = 999999999d;
		String regexSalario = "^[\\d]+(?:\\.\\d{1,2})?$";
		
		do {
			System.out.print("Ingrese el salario del empleado: ");
			salarioS = sc.nextLine();
		}while(!validarCampo(salarioS, regexSalario, salarioMin, salarioMax));
		
		salario = Double.parseDouble(salarioS);
		
		return salario;
	}
	
	public static TipoCliente pedirTipoCliente() {
		
		TipoCliente tipoCliente = null;
		String seleccion;
		String regexSeleccion = "[ESGPesgp]";
		
		do {
			System.out.println("Indique el tipo de cliente:\nE-ESTANDAR\nS-SILVER\nG-GOLD\nP-PLATINUM");
			seleccion = sc.nextLine().trim().substring(0, 1);
		}while(!validarCampo(seleccion, regexSeleccion));
		
		tipoCliente = switch(seleccion.toUpperCase()) {
			case "E" -> TipoCliente.ESTANDAR;
			case "S" -> TipoCliente.SILVER;
			case "G" -> TipoCliente.GOLD;
			case "P" -> TipoCliente.PLATINUM;
			default -> null;
		};
			
		return tipoCliente;
	}
	
	public static void presentarse(Persona persona) {
		persona.presentarse();
	}
	
	public static boolean validarCampo(String campo, String regex) {
			
		try {
			if(campo == null || campo.isEmpty() || !campo.matches(regex))
				throw new IllegalArgumentException("Campo invalido. Por favor ingrese un valor correcto");			
			return true;
		}
		catch(IllegalArgumentException e) {
			System.err.print(e.getMessage()+ "\n");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
				
		return false;
	}
	
	public static boolean validarCampo(String campo, String regex, int min, int max) {
		
		if(!validarCampo(campo, regex)) return false;
			
		try {
			if(Integer.parseInt(campo) <= min || Integer.parseInt(campo) > max)
				throw new IllegalArgumentException("El valor debe estar entre " + min + " y " + max);			
			return true;
		}
		catch(IllegalArgumentException e) {
			System.err.print(e.getMessage()+ "\n");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
				
		return false;
	}
	
	public static boolean validarCampo(String campo, String regex, double min, double max) {
		
		if(!validarCampo(campo, regex)) return false;
		
		double valor = Double.parseDouble(campo);
			
		try {
			if(valor <= min || valor > max)
				throw new IllegalArgumentException("El valor debe estar entre " + min + " y " + max);			
			return true;
		}
		catch(IllegalArgumentException e) {
			System.err.print(e.getMessage()+ "\n");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
				
		return false;
	}

}

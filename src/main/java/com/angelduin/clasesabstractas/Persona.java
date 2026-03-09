package com.angelduin.clasesabstractas;

public abstract class Persona {
	
	private String nombre;
	private String  email;
	private String dir;
	private int edad;
	
	public Persona(String nombre, String email, String dir, int edad){
		
	
		if(nombre == null || nombre.isEmpty() || !nombre.matches("^[A-Za-z]+\\s[A-Za-z]+$"))
			throw new IllegalArgumentException("El nombre es nulo o tiene valores incorrectos");

		if(email== null || email.isEmpty() || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
			throw new IllegalArgumentException("El email es nulo o tiene valores incorrectos");

		if(dir == null || dir.isEmpty() || !dir.matches("^[a-zA-Z0-9.]+(?:\\s[a-zA-Z0-9.]+)+$"))
			throw new IllegalArgumentException("La dirección es nula o tiene valores incorrectos");

		if(edad <= 0 || edad > 120)
			throw new IllegalArgumentException("La edad es cero o tiene valores incorrectos");

		this.nombre = nombre.trim();
		this.email = email.trim();
		this.dir = dir.trim();
		this.edad = edad;	
	}
	
	public abstract void presentarse();
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	
	public String getDir() {
		return this.dir;
	}
	
	
	public int getEdad() {
		return this.edad;
	}
	
	
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nEmail: " + getEmail() + "\nDireccion: " + getDir();
	}
	
}

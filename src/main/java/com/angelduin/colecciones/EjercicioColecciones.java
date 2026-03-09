package com.angelduin.colecciones;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.angelduin.entidades.*;
import com.angelduin.clasesabstractas.*;
import com.angelduin.clasesgenericas.*;

public class EjercicioColecciones {
	
	static ArrayList<Empleado> lista1 = new ArrayList<>();
	static LinkedList<Empleado> lista2 = new LinkedList<>();
	static HashMap<Double, Empleado> mapa1 = new HashMap<>();
	static HashSet<String> conjunto1 = new HashSet<>();

	public static void main(String[] args) {
		
		
		
		Empleado empleado1 = new Empleado("Angel Duin", "a-ricardo_dc@hotmail.com", "Av. Belgrano 4200", 33, "Desarrollador", 5000000);
		Empleado empleado2 = new Empleado("Gley Nieto", "gleynieto@hotmail.com", "Av. Rivadavia 3159", 25, "Medico", 7000000);
		Empleado empleado3 = new Empleado("Betzabeth Duin", "betzabethduin@gmail.com", "calle San Martin 1500", 39, "Odontologo", 6000000);
		Empleado empleado4 = new Empleado("Bugs Bunny", "bugsbunny@yahoo.com", "Av. Cabildo 2886", 32, "Mecanico", 3000000);
		Empleado empleado5 = new Empleado("Alicia Piniero", "aliciap@frba.utn.edu.ar", "Venezuela 625", 23, "Pasante", 1500000);
		
		System.out.println("\n##########################################-ARRAY LIST-####################################################\n");
		lista1.add(empleado1);
		lista1.add(empleado2);
		lista1.add(empleado3);
		lista1.add(empleado4);
		lista1.add(empleado5);
		
		imprimirLista(lista1);
		
		
		System.out.println("\n##########################################-LINKED LIST-####################################################\n");
		lista2.offer(empleado1);
		lista2.offer(empleado2);
		lista2.offer(empleado3);
		
		imprimirLista(lista2);
		
		Empleado unEmpleado = eliminarExtraer(lista2);
		System.out.println("\n#####LINKEDLIST sin el primer elemento#####\n");
		imprimirLista(lista2);
		System.out.println("\n####PRIMER ELEMENTO####\n");
		unEmpleado.exportarDatos();
		
		System.out.println("\n##########################################-HASH MAP-####################################################\n");
		mapa1.put(empleado1.getSalario(), empleado1);
		mapa1.put(empleado2.getSalario(), empleado2);
		mapa1.put(empleado3.getSalario(), empleado3);
		mapa1.put(empleado4.getSalario(), empleado4);
		
		Empleado otroEmpleado = mapa1.get(empleado2.getSalario());
		
		System.out.println("\n##### EMPLEADO OBTENIDO POR CLAVE ####\n");
		otroEmpleado.exportarDatos();
		
		System.out.println("\n#### ITERANDO VALORES ####\n");
		for(Entry<Double, Empleado> entrada : mapa1.entrySet()) {
			entrada.getValue().exportarDatos();
		}
		
		
		System.out.println("\n##########################################-HASH SET-####################################################\n");
		conjunto1.add(empleado1.getEmail());
		conjunto1.add(empleado2.getEmail());
		conjunto1.add(empleado3.getEmail());
		conjunto1.add(empleado4.getEmail());
		conjunto1.add(empleado1.getEmail());
		
		Iterator<String> iterador = conjunto1.iterator();
		
		while(iterador.hasNext()) {
			String auxiliar = iterador.next();
			System.out.print("ELEMENTO DEL CONJUNTO: " + auxiliar + "\n");
		}
		
		System.out.println("\n######################################-REPOSITORIO EMPLEADO-################################################\n");
		Repositorio <Empleado> empleados = new Repositorio<>();
		empleados.agregar(empleado1);
		empleados.agregar(empleado2);
		empleados.agregar(empleado3);
		empleados.agregar(empleado4);
		empleados.agregar(empleado5);
		
		empleados.listar();
		
		Empleado empleado6 = empleados.eliminar(4);
		System.out.println("\nEmpleado eliminado:");
		empleado6.exportarDatos();
		System.out.println("\n");
		
		System.out.println("-------------------Empleados aun en lista-------------------");
		for(int i = 0; i<empleados.tamanio(); i++) {
			empleados.obtener(i).exportarDatos();
			System.out.println("\n");
		}
		
		System.out.println("\n######################################-REPOSITORIO STRING-################################################\n");
		
		Repositorio <String> emails = new Repositorio<>();
		emails.agregar(empleado1.getEmail());
		emails.agregar(empleado2.getEmail());
		emails.agregar(empleado3.getEmail());
		emails.agregar(empleado4.getEmail());
		emails.agregar(empleado5.getEmail());
		
		emails.listar();
	}
	
	public static void eliminarEntrada(ArrayList<Persona> lista, int indice) {
		lista.remove(indice);
	}
	
	public static void elimnarEntada(ArrayList<Persona> lista, Persona persona) {
		lista.remove(persona);
	}
	
	public static Empleado eliminarExtraer(LinkedList<Empleado> lista) {
		
		return lista.poll();
	}
	
	public static void imprimirLista(List<Empleado> lista) {
		
		for(Empleado e: lista) {
			e.exportarDatos();
		}
	}

}

package com.angelduin.clasesgenericas;

import java.util.ArrayList;

public class Repositorio <T> {
	
	private ArrayList<T> lista = new ArrayList<>();
	
	public Repositorio(){}
	
	public void agregar(T elemento) {
		lista.add(elemento);
	}
	
	public T obtener(int indice) {
		return lista.get(indice);
	}
	
	public T eliminar(int indice) {
		return lista.remove(indice);
	}
	
	public void listar() {
		for(T elemento : lista) {
			System.out.println(elemento);
		}
	}
	
	public int tamanio() {
		return lista.size();
	}

}


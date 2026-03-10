package com.angelduin.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.Map.Entry;

import com.angelduin.entidades.Empleado;


public class EjercicioStreams {

	static ArrayList<Empleado> lista1 = new ArrayList<>();
	public static void main(String[] args) {
		
		Consumer<String> imprimir = s-> System.out.println(s);
		
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
		
		/*System.out.println("\n#########################-Personas con salarios superiores a 4 millones-###################################\n");
		List<Empleado> salariosSuperioresA = lista1.stream().filter((e->e.getSalario()>=4000000)).toList();
		
		imprimirLista(salariosSuperioresA);
		
		System.out.println("\n########################################-Lista de nombres-###################################################\n");
		List<String> nombres = lista1.stream().map(Empleado::getNombre).toList();
		System.out.println(nombres);
		
		
		System.out.println("\n###################################-Personas mayores a 30 anios-#############################################\n");
		List<Empleado> personasMayoresA = lista1.stream().filter(e->e.getEdad()>30).toList();
		imprimirLista(personasMayoresA);
		
		System.out.println("\n###################################-Cargos en mayuscula-####################################################\n");
		List<String> cargos = lista1.stream().map(e->e.getCargo().toUpperCase()).toList();
		System.out.println(cargos);*/
		
		/*System.out.println("\n##########################################-LISTA ORDENADA-####################################################\n");
		imprimirLista(lista1.stream().sorted(Comparator.comparingDouble(Empleado::getSalario).reversed()).toList());
		
		System.out.println("\n########################################-SALARIO PROMEDIO-####################################################\n");
		OptionalDouble salarioPromedio = lista1.stream().mapToDouble(Empleado::getSalario).average();
		System.out.println(salarioPromedio.getAsDouble());
		
		System.out.println("\n##################################-Empleado con el salario más alto-############################################\n");
		Optional<Empleado> mejorPagado = lista1.stream().max(Comparator.comparingDouble(e->e.getSalario()));
		mejorPagado.get().exportarDatos();
		
		System.out.println("\n##########################################-SUMA SALARIOS-####################################################\n");
		double sumaTotalSalarios = lista1.stream().map(Empleado::getSalario).reduce(0.0, Double::sum);
		System.out.println(sumaTotalSalarios);*/
		
		/*System.out.println("\n################################-MAP EMPLEADOS SEPARADOS POR CARGO-##########################################\n");
		Map<String, List<Empleado>> empleadosPorCargo = lista1.stream().collect(Collectors.groupingBy(Empleado::getCargo));
		
		for(Entry<String, List<Empleado>> lista : empleadosPorCargo.entrySet()) {
			imprimir.accept(lista.getKey());
			imprimirLista(lista.getValue());
		}
		
		System.out.println("\n################################-MAP CANT EMPLEADOS POR CARGO-##########################################\n");
		Map<String, Long> cantEmpleadosPorCargo = lista1.stream().collect(Collectors.groupingBy(Empleado::getCargo, Collectors.counting()));
		
		for(Entry<String, Long> entrada : cantEmpleadosPorCargo.entrySet()) {
			
			imprimir.accept(entrada.getKey());
			imprimir.accept(entrada.getValue().toString());
		}
		
		System.out.println("\n################################-STRING CON TODOS LOS NOMBRES-##########################################\n");
		
		String nombres = lista1.stream().map(Empleado::getNombre).collect(Collectors.joining(","));
		imprimir.accept(nombres);
		
		System.out.println("\n##############################-EMPLEADOS CON SALARIOS MAYORES A-########################################\n");
		int salarioAComparar = 3000000;
		Set<Empleado> empleados = lista1.stream().filter(e->e.getSalario()>salarioAComparar).collect(Collectors.toSet());
		imprimirLista(empleados);*/
		
		System.out.println("\n##############################-EJERCICIO INTEGRADOR-########################################\n");
		String listaFinal = lista1.stream().filter(e->e.getEdad()>30).sorted(Comparator.comparing(Empleado::getSalario).reversed())
				.map(Empleado::getNombre).collect(Collectors.joining("|"));
		
		imprimir.accept(listaFinal);
	}
	
	public static void imprimirLista(Collection<Empleado> lista) {
		
		for(Empleado e: lista) {
			e.exportarDatos();
		}
	}

}

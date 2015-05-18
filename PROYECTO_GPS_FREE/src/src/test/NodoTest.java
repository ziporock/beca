package src.test;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.gpsfree.Algoritmos;
import ungs.edu.gpsfree.Coordenada;
import ungs.edu.gpsfree.Grafo;
import ungs.edu.gpsfree.Nodo;

public class NodoTest {

	private Nodo nodoActual = new Nodo("N1");
	private Coordenada coordenadaEsperada=new Coordenada(2.0, -4.0);
	private Grafo grafo=new Grafo();
	
	
	// Eje y normal
	@Test
	public void casoATest() {
		Coordenada n2_coordenada = new Coordenada(1.0, 1.0);
		Coordenada n5_coordenada = new Coordenada(3.0, 2.0);
		Coordenada n3_coordenada = new Coordenada(2.0, 4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void casoBTest() {
		Coordenada n2_coordenada = new Coordenada(1.0, 2.0);
		Coordenada n5_coordenada = new Coordenada(3.0, 1.0);
		Coordenada n3_coordenada = new Coordenada(2.0, 4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void casoCTest() {
		Coordenada n2_coordenada = new Coordenada(3.0, 2.0);
		Coordenada n5_coordenada = new Coordenada(1.0, 1.0);
		Coordenada n3_coordenada = new Coordenada(2.0, 4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void casoDTest() {
		Coordenada n2_coordenada = new Coordenada(3.0, 1.0);
		Coordenada n5_coordenada = new Coordenada(1.0, 2.0);
		Coordenada n3_coordenada = new Coordenada(2.0, 4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	// Eje y opuesto

	@Test
	public void casoETest() {
		Coordenada n2_coordenada = new Coordenada(1.0, 1.0);
		Coordenada n5_coordenada = new Coordenada(3.0, 2.0);
		Coordenada n3_coordenada = new Coordenada(2.0, -4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void casoFTest() {
		Coordenada n2_coordenada = new Coordenada(1.0, 2.0);
		Coordenada n5_coordenada = new Coordenada(3.0, 1.0);
		Coordenada n3_coordenada = new Coordenada(2.0, -4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void casoGTest() {
		Coordenada n2_coordenada = new Coordenada(3.0, 1.0);
		Coordenada n5_coordenada = new Coordenada(1.0, 2.0);
		Coordenada n3_coordenada = new Coordenada(2.0, -4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void casoHTest() {
		Coordenada n2_coordenada = new Coordenada(3.0, 2.0);
		Coordenada n5_coordenada = new Coordenada(1.0, 1.0);
		Coordenada n3_coordenada = new Coordenada(2.0, -4.0);
		Coordenada n4_coordenada = new Coordenada(4.0, 2.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
	}

	@Test
	public void pruebaValores(){
		
		Coordenada n2_coordenada = new Coordenada(-3.0, -1.0);
		Coordenada n5_coordenada = new Coordenada(-5.0, 5.0);
		Coordenada n3_coordenada = new Coordenada(10.0, -7.0);
		Coordenada n4_coordenada = new Coordenada(0.0, -6.0);
		nodoActual.calcularCoordenadaNuevo(n2_coordenada, n5_coordenada,
				n3_coordenada, n4_coordenada);
		Assert.assertEquals(n4_coordenada, nodoActual.getCoordenada());
		
	}
	
	@Test
	public void pruebaEjeYOpuesto(){
		Coordenada c1=new Coordenada(-1.0, -1.0);
		Coordenada c2=new Coordenada(-2.0, 2.0);
		Coordenada c3=new Coordenada(10.0, -15.0);
		Algoritmos.esEjeYOpuesto(c1, c2, c3);
	}
	
	
	
	@Test
	public void obtenerVecinosTest() throws Exception{
		Nodo nodo_1=new Nodo("NODO1");
		Coordenada n1_coordenada=new Coordenada(1.0, 1.0);
		nodo_1.setCoordenada(n1_coordenada);
		
		Nodo nodo_2=new Nodo("NODO2");
		Coordenada n2_coordenada=new Coordenada(1.0, 3.0);
		nodo_2.setCoordenada(n2_coordenada);
		
		Nodo nodo_3=new Nodo("NODO3");
		Coordenada n3_coordenada=new Coordenada(4.0, 4.0);
		nodo_3.setCoordenada(n3_coordenada);
		
		
		Nodo nodo_4=new Nodo("NODO4");
		Coordenada n4_coordenada=new Coordenada(2.0, 2.0);
		nodo_4.setCoordenada(n4_coordenada);
		
		
		Nodo nodo_5=new Nodo("NODO5");
		Coordenada n5_coordenada=new Coordenada(-3.0, -2.0);
		nodo_5.setCoordenada(n5_coordenada);
		
		
		Nodo nodo_6=new Nodo("NODO6");
		Coordenada n6_coordenada=new Coordenada(6.0, 2.0);
		
		
		
		grafo.agregarNodo(nodo_1);
		grafo.agregarNodo(nodo_2);
		grafo.agregarNodo(nodo_3);
		grafo.agregarNodo(nodo_4);
		grafo.agregarNodo(nodo_5);
		grafo.agregarNodo(nodo_6);
		
		System.out.println(grafo.toString());
		
			
		nodoActual.agregarVecino(nodo_1.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n1_coordenada));
		nodoActual.agregarVecino(nodo_2.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n2_coordenada));
		nodoActual.agregarVecino(nodo_3.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n3_coordenada));
		nodoActual.agregarVecino(nodo_4.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n4_coordenada));
		nodoActual.agregarVecino(nodo_5.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n5_coordenada));
		
		
		System.out.println("VECINOS");
		HashMap<String, Nodo> univ=(HashMap<String, Nodo>) grafo.getUniversoDeNodos();
		Nodo nodo=null;
		for (String clave : nodoActual.getVecinos().keySet()) {
			nodo=univ.get(clave);
			System.out.println(nodo);
		}
		
		System.out.println("3 VALIDOS");
	    List<Nodo > vecinos=nodoActual.getTresVecinosAdentro();
		for (Nodo vecino : vecinos) {
			System.out.println(vecino);
		}
	}
	
	
	
	@Test
	public void buscarCoordenadas() throws Exception{
		System.out.println("ESPERO "+coordenadaEsperada);
		Nodo nodo_1=new Nodo("NODO1");
		Coordenada n1_coordenada=new Coordenada(7.0, 1.0);
		nodo_1.setCoordenada(n1_coordenada);
		
		Nodo nodo_2=new Nodo("NODO2");
		Coordenada n2_coordenada=new Coordenada(-7.0, 3.0);
		nodo_2.setCoordenada(n2_coordenada);
		
		Nodo nodo_3=new Nodo("NODO3");
		Coordenada n3_coordenada=new Coordenada(-2.0, 4.0);
		nodo_3.setCoordenada(n3_coordenada);
		
		
		Nodo nodo_4=new Nodo("NODO4");
		Coordenada n4_coordenada=new Coordenada(2.0, 2.0);
		nodo_4.setCoordenada(n4_coordenada);
		
		
		Nodo nodo_5=new Nodo("NODO5");
		Coordenada n5_coordenada=new Coordenada(-3.0, -2.0);
		nodo_5.setCoordenada(n5_coordenada);
		
		
		Nodo nodo_6=new Nodo("NODO6");
		Coordenada n6_coordenada=new Coordenada(6.0, 2.0);
			
		grafo.agregarNodo(nodo_1);
		grafo.agregarNodo(nodo_2);
		grafo.agregarNodo(nodo_3);
		grafo.agregarNodo(nodo_4);
		grafo.agregarNodo(nodo_5);
		grafo.agregarNodo(nodo_6);
			
		nodoActual.agregarVecino(nodo_1.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n1_coordenada));
		nodoActual.agregarVecino(nodo_2.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n2_coordenada));
		nodoActual.agregarVecino(nodo_3.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n3_coordenada));
		nodoActual.agregarVecino(nodo_4.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n4_coordenada));
	    nodoActual.agregarVecino(nodo_5.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n5_coordenada));
		nodoActual.agregarVecino(nodo_6.getNombre(), Algoritmos.distanciaEntrePuntos(coordenadaEsperada,  n6_coordenada));
		
		System.out.println("VECINOS");
		 List<Nodo > vecinos=nodoActual.getTresVecinosAdentro();
			for (Nodo vecino : vecinos) {
				System.out.println(vecino);
			}
		
		nodoActual.calcularCoordenada();
	}
	
	
	@Test
	public void generarNodosAleatorios(){
		String nombreNodo;
		int cant=10;
		Random rand = new Random();
		for (int i = 0; i <cant ; i++) {
			Nodo nodo=new Nodo("C"+i);
		    int x = rand.nextInt((100 - 0) + 1) + 0;
		    int y=rand.nextInt((100 - 0) + 1) + 0;
			Coordenada coordenada=new Coordenada(x, y);
			nodo.setCoordenada(coordenada);
			grafo.agregarNodo(nodo);
		}
		
		System.out.println(grafo);
		
	}
	
	@Test
	public void generarGrafo() throws Exception{
		grafo.generarNodosAleatorios(100,100,-100);
		grafo.armarGrafo();
		System.out.println(grafo.toString());
		grafo.borrarCoordenadasAleatoriamente();
		System.out.println(grafo.toString());
		HashMap<String, Nodo> univ=(HashMap<String, Nodo>) grafo.getUniversoDeNodos();
		for (String clave : univ.keySet()) {
			Nodo nodo=univ.get(clave);
			if (nodo.getCoordenada()==null){
				nodo.calcularCoordenada();
			}
		}
		System.out.println(grafo.toString());
	}
	
	
	

}

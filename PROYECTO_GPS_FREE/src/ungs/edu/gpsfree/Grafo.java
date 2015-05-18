package ungs.edu.gpsfree;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class Grafo {

	private static Map<String, Nodo> universoDeNodos;

	public Grafo() {
		this.universoDeNodos = new HashMap<String, Nodo>();
	}

	public static Map<String, Nodo> getUniversoDeNodos() {
		return universoDeNodos;
	}

	public static void setUniversoDeNodos(Map<String, Nodo> universoDeNodos) {
		Grafo.universoDeNodos = universoDeNodos;
	}

	public void agregarNodo(Nodo nodo) {
		this.universoDeNodos.put(nodo.getNombre(), nodo);
	}

	@Override
	public String toString() {
		String result = "GRAFO\n";
		for (String clave : universoDeNodos.keySet()) {
			result += universoDeNodos.get(clave).toString() + "\n";
		}
		return result;
	}

	public void generarNodosAleatorios(int cant,int maximo, int min) {
		Random rand = new Random();
		for (int i = 0; i < cant; i++) {
			Nodo nodo = new Nodo("C" + i);
			int x = rand.nextInt((maximo - min) + 1) + min;
			int y = rand.nextInt((maximo - min) + 1) + min;

			Coordenada coordenada = new Coordenada(x, y);
			nodo.setCoordenada(coordenada);

			this.agregarNodo(nodo);
		}

	}

	public void armarGrafo() {
		for (String clave : universoDeNodos.keySet()) {
			Nodo nodo = universoDeNodos.get(clave);
			for (String clave2 : universoDeNodos.keySet()) {
				if (clave != clave2) {
					Nodo nodo2 = universoDeNodos.get(clave2);
					nodo.agregarVecino(nodo2.getNombre(), Algoritmos
							.distanciaEntrePuntos(nodo.getCoordenada(),
									nodo2.getCoordenada()));
				}

			}

			this.agregarNodo(nodo);
		}
	}

	public void borrarCoordenadasAleatoriamente() {
		for (String clave : universoDeNodos.keySet()) {
			Nodo nodo = universoDeNodos.get(clave);
			int generarCoordenada = (int) (Math.random() + 0.5);
			if (generarCoordenada == 0) {
				nodo.setCoordenada(null);
			}
		}
	}

}

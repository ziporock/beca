package ungs.edu.gpsfree;

import java.util.ArrayList;
import java.util.List;

public class Grafo_ {

	private int numeroNodos;
	private int[][] adyacentes;
	private String[] nodoInformacion;
	private boolean vacio;

	
	
	
	public Grafo_(int cantNodos) {
		nodoInformacion=new String[cantNodos];
		
		for (int i = 0; i < cantNodos; i++) {
			nodoInformacion[i]="[N"+i+"]";
		}
		adyacentes = new int[cantNodos][cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				adyacentes[i][j] = 0;
			}

		}
		vacio = false;

	}
	
	
	
	

	public void MostrarMatrizAdy() {
		System.out.print("NODO\t");
		for (int i = 0; i < nodoInformacion.length; i++) {
			System.out.print("\t");
			System.out.print(nodoInformacion[i]);
		}
		System.out.println();

	
		for (int x = 0; x < adyacentes.length; x++) {
			System.out.print(nodoInformacion[x]);
			System.out.print("\t");
			System.out.print("|");
			System.out.print("\t");
			for (int y = 0; y < adyacentes[x].length; y++) {
				System.out.print(adyacentes[x][y]);
				if (y != adyacentes[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("\t|");
		}
	}

}

package ungs.edu.graficar;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ungs.edu.gpsfree.Algoritmos;
import ungs.edu.gpsfree.Coordenada;

public class Main {

	public static void main(String[] args) {
		Graficador graficador = new Graficador();
		Coordenada coordenada0 = new Coordenada(0.0, 0.0);
		Coordenada coordenada1 = new Coordenada(0.0, 4.0);
		Coordenada coordenada2 = new Coordenada(3.0, 4.0);
		Coordenada coordenada3 = new Coordenada(6.0, 2.0);

		graficador.agregarPunto(coordenada0,"C0");
		
		graficador.agregarPunto(coordenada1,"C1");
		graficador.agregarPunto(coordenada2,"C2");
		graficador.agregarPunto(coordenada3,"C3");

		graficador.dibujar();

		System.out.println("Coordenada c0 " + coordenada0);
		System.out.println("Coordenada c1 " + coordenada1);
		System.out.println("Coordenada c2 " + coordenada2);
		System.out.println("Coordenada c3 " + coordenada3);

		Double dc1c3 = Algoritmos
				.distanciaEntrePuntos(coordenada0, coordenada2);
		Double dc2c3 = Algoritmos
				.distanciaEntrePuntos(coordenada1, coordenada2);
		Double dc1c2 = Algoritmos
				.distanciaEntrePuntos(coordenada0, coordenada1);
		Double dc1c4 = Algoritmos
				.distanciaEntrePuntos(coordenada0, coordenada3);
		Double dc2c4 = Algoritmos
				.distanciaEntrePuntos(coordenada1, coordenada3);
		Double dc3c4 = Algoritmos
				.distanciaEntrePuntos(coordenada2, coordenada3);

		System.out.println("Distancia c0 c1 " + dc1c2);
		System.out.println("Distancia c0 c2 " + dc1c3);
		System.out.println("Distancia c1 c2 " + dc2c3);
		System.out.println("Distancia c0 c3 " + dc1c4);
		System.out.println("Distancia c1 c3 " + dc2c4);
		System.out.println("Distancia c2 c3 " + dc3c4);

		Coordenada c2_calculada = new Coordenada(0.0,
				Algoritmos.distanciaEntrePuntos(coordenada0, coordenada1));

		Double angulo_ghama = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);
		Coordenada c3_calculada = new Coordenada(
				dc1c3 * Math.cos(angulo_ghama), dc1c3 * Math.sin(angulo_ghama));

		System.out.println("Angulo ghama c3 " + angulo_ghama);
		
		Double anguloLanda = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);
		Double anguloBetha = Algoritmos.reglaDelCoceno(dc1c3, dc1c4, dc3c4);
		Double anguloAlpha = Algoritmos.reglaDelCoceno(dc1c4, dc1c2, dc2c4);

		System.out.println("Angulo alpha c4 " + anguloAlpha);

		Coordenada c4_calculada=new Coordenada(0.0, 0.0);
		c4_calculada.setX(dc1c4 * Math.cos(anguloAlpha));
		c4_calculada.setY(dc1c4 * Math.sin(anguloAlpha));
		/*
		if (anguloBetha == Math.abs(anguloAlpha - anguloLanda)) {
			c4_calculada.setY(dc1c4 * Math.sin(anguloAlpha));
		} else {
			c4_calculada.setY(-1 * dc1c4 * Math.sin(anguloAlpha));
		}
*/
		System.out.println("Coordenada c0 " + coordenada0);
		System.out.println("Coordenada c1 " + c2_calculada);
		System.out.println("Coordenada c2 " + c3_calculada);
		System.out.println("Coordenada c3 " + c4_calculada);
		
		Graficador graficador2=new Graficador();
		graficador2.agregarPunto(coordenada0,"C0_calculado");
		graficador2.agregarPunto(c2_calculada,"C1_calculado");
		graficador2.agregarPunto(c3_calculada,"C2_calculado");
		graficador2.agregarPunto(c4_calculada,"C3_calculado");
		graficador2.dibujar();
		
	}

	public static XYDataset createStepXYDataset() {

		final int feb = 2;
		final XYSeries s1 = new XYSeries("Plan 1", false, true);
		s1.add(0.0, 0.0);
		s1.add(5.0, 0.0);
		s1.add(2.0, 4.0);
		s1.add(7.0, 2.0);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(s1);

		return dataset;
	}

}

package ungs.edu.gpsfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math.util.MathUtils;

public class Nodo {

	private String nombre;
	private Coordenada coordenada;
	private Map<String, Double> vecinos;

	public Nodo(String nombre) {
		super();
		this.nombre = nombre;
		this.vecinos = new HashMap<String, Double>();
	}

	public String getNombre() {
		return nombre;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Map<String, Double> getVecinos() {
		return vecinos;
	}

	public void agregarVecino(String nodo, Double distancia) {
		this.vecinos.put(nodo, distancia);
	}

	public String mostrarVecinos() {
		String vecinos = "Vecinos {";
		for (String vecino : this.vecinos.keySet()) {
			vecinos += vecino + ";";
		}
		vecinos += "}";
		return vecinos;
	}

	@Override
	public String toString() {
		return "Nodo [nombre=" + nombre + ", coordenada=" + coordenada
				+ ", vecinos=" + vecinos.keySet() + "]";
	}

	public List<Nodo> getTresVecinosAdentro() throws Exception {
		List<Nodo> resultado = new ArrayList<Nodo>();
		HashMap<String, Nodo> universo = (HashMap<String, Nodo>) Grafo
				.getUniversoDeNodos();
		Nodo nodo = null;
		boolean valido = false;
		for (String clave : this.vecinos.keySet()) {
			nodo = universo.get(clave);
			if (nodo.getCoordenada() != null) {
				if (resultado.size() > 0) {
						if (resultado.size() == 2  &&(validarCoordenadaX(resultado.get(0).getCoordenada(),
								nodo.getCoordenada())  && validarCoordenadaX(resultado.get(1).getCoordenada(),
										nodo.getCoordenada()))) {
							if (!Algoritmos.coolineales(resultado.get(0)
									.getCoordenada(), resultado.get(1)
									.getCoordenada(), nodo.getCoordenada())) {
								resultado.add(nodo);
							}
						}
						if (resultado.size() == 1&& validarCoordenadaX(resultado.get(0).getCoordenada(),
								nodo.getCoordenada() ) ) {
									resultado.add(nodo);
					}
				} else {
					resultado.add(nodo);
				}

			}
			if (resultado.size() == 3) {
				break;
			}
		}
		if (resultado.size()!=3){
			throw new Exception("NO TIENE 3 VECINOS CON COORDENADAS");
		}
		return resultado;
	}
	
	

	private boolean validarCoordenadaX(Coordenada c1, Coordenada c2) {
		boolean result = true;
		if (c1.getX() == c2.getX()) {
			result = false;
		}
		return result;

	}

	public void calcularCoordenadaNuevo(Coordenada n2_p, Coordenada n5_p,
			Coordenada n3_p, Coordenada n4_p) {

		Nodo n2 = new Nodo("N2");
		Coordenada n2_coordenada = n2_p;
		n2.setCoordenada(n2_coordenada);

		Nodo n5 = new Nodo("N5");
		Coordenada n5_coordenada = n5_p;
		n5.setCoordenada(n5_coordenada);

		Nodo n3 = new Nodo("N3");
		Coordenada n3_coordenada = n3_p;
		n3.setCoordenada(n3_coordenada);

		List<Nodo> tresVecinosAdentro = new ArrayList<Nodo>();
		tresVecinosAdentro.add(n2);
		tresVecinosAdentro.add(n5);
		tresVecinosAdentro.add(n3);

		// asigno nodos
		System.out.println("*******************************");
		System.out.println("TOMO COMO C1 A " + n2);
		Coordenada C1 = new Coordenada(0.0, 0.0);
		System.out.println("TOMO COMO C2 A " + n5);
		Coordenada C2 = new Coordenada(n5.getCoordenada().getX(), n5
				.getCoordenada().getY());
		System.out.println("TOMO COMO C3 A " + n3);
		Coordenada C3 = new Coordenada(n3.getCoordenada().getX(), n3
				.getCoordenada().getY());
		System.out.println("*******************************");
		// calculo las distancias
		Double dc1c2 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n2_coordenada, n5_coordenada),
				4);
		System.out.println("DISTANCIA C1 - C2 " + dc1c2);
		Double dc1c3 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n2_coordenada, n3_coordenada),
				4);
		System.out.println("DISTANCIA C1 - C3 " + dc1c3);
		Double dc2c3 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n5_coordenada, n3_coordenada),
				4);
		System.out.println("DISTANCIA C2 - C3 " + dc2c3);

		// la posicion que busco

		Coordenada n1_coordenada = n4_p;
		System.out.println("C4 ESPERADO " + n1_coordenada);

		Double dc1c4 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n1_coordenada, n2_coordenada),
				4);
		Double dc2c4 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n1_coordenada, n5_coordenada),
				4);
		Double dc3c4 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n1_coordenada, n3_coordenada),
				4);

		System.out.println("DISTANCIA C1 - C4 " + dc1c4);
		System.out.println("DISTANCIA C2 - C4 " + dc2c4);
		System.out.println("DISTANCIA C3 - C4 " + dc3c4);
		System.out.println("*******************************");
		/*
		 * 
		 * Double dc1c4 = vecinos.get(tresVecinosAdentro.get(0)); Double dc2c4 =
		 * vecinos.get(tresVecinosAdentro.get(1)); Double dc3c4 =
		 * vecinos.get(tresVecinosAdentro.get(2));
		 */
		// seteo a c2 sobre el eje x
		C2.setX(dc1c2);
		C2.setY(0.0);

		Double angulo_ghama = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);

		// seteo a la coordenada c3 su x e y
		C3.setX(MathUtils.round(dc1c3 * Math.cos(Math.toRadians(angulo_ghama)),
				4));
		C3.setY(MathUtils.round(dc1c3 * Math.sin(Math.toRadians(angulo_ghama)),
				4));

		// Muestro las nuevas coordenadas
		System.out.println("*******************************");
		System.out.println("C1 " + C1.toString());
		System.out.println("C2 " + C2.toString());
		System.out.println("C3 " + C3.toString());
		System.out.println("*******************************");

		// busco el angulo y genero la coordenada

		Double anguloLanda = MathUtils.round(
				Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3), 4);
		Double anguloBetha = MathUtils.round(
				Algoritmos.reglaDelCoceno(dc1c3, dc1c4, dc3c4), 4);
		Double anguloAlpha = MathUtils.round(
				Algoritmos.reglaDelCoceno(dc1c4, dc1c2, dc2c4), 4);

		System.out.println("************* ANGULOS ******************");
		System.out.println("ANGULO landa (C1 C2 C3) " + anguloLanda);
		System.out.println("ANGULO betha (C1 C4 C3) " + anguloBetha);
		System.out.println("ANGULO alpha (C1 C2 C4) " + anguloAlpha);
		System.out.println("*******************************");

		if (Math.round(anguloBetha) == Math.abs(Math.round(anguloAlpha
				- anguloLanda))) {
			this.coordenada = new Coordenada(MathUtils.round(
					dc1c4 * Math.cos(Math.toRadians(anguloAlpha)), 4),
					MathUtils.round(
							dc1c4 * Math.sin(Math.toRadians(anguloAlpha)), 4));
		} else {
			this.coordenada = new Coordenada(MathUtils.round(
					dc1c4 * Math.cos(Math.toRadians(anguloAlpha)), 4),
					MathUtils.round(
							-1 * dc1c4 * Math.sin(Math.toRadians(anguloAlpha)),
							4));
		}

		System.out.println("*******************************");
		System.out.println("COORDENADA C4 EJE ARMADO " + this.coordenada);
		System.out.println("*******************************");
		// Rotar los vectores
		// supongo la coordenada j de ajuste

		System.out
				.println("*****************************************************");

		double angulo = Algoritmos.anguloDeRotacion(n2.getCoordenada(),
				n5.getCoordenada(), n3.getCoordenada());

		System.out.println("ANGULO: " + angulo);

		C1 = Algoritmos.rotarCoordenada(C1, angulo);
		C2 = Algoritmos.rotarCoordenada(C2, angulo);
		C3 = Algoritmos.rotarCoordenada(C3, angulo);
		this.coordenada = Algoritmos.rotarCoordenada(this.coordenada, angulo);
		System.out.println("C1 R" + C1);
		System.out.println("C2 R" + C2);
		System.out.println("C3 R" + C3);
		System.out.println("C4 R" + this.coordenada);

		if (Algoritmos.esEjeYOpuesto(n2.getCoordenada(),n5.getCoordenada(), n3.getCoordenada())) {

			if (!Algoritmos.esEjeXOpuesto(n2.getCoordenada(),
					n5.getCoordenada())) { // &&n5.getCoordenada().getY() >
											// n2.getCoordenada().getY()) {
				System.out.println("HAGO ESPEJO");
				this.getCoordenada().setY(this.coordenada.getY() * -1);
				C1.setY(-1 * C1.getY());
				C2.setY(-1 * C2.getY());
				C3.setY(-1 * C3.getY());
			}

		} else {
			if (Algoritmos
					.esEjeXOpuesto(n2.getCoordenada(), n5.getCoordenada())) {
				System.out.println("HAGO ESPEJO");
				this.getCoordenada().setY(this.coordenada.getY() * -1);
				C1.setY(-1 * C1.getY());
				C2.setY(-1 * C2.getY());
				C3.setY(-1 * C3.getY());

			}

		}

		Coordenada origen = new Coordenada(0.0, 0.0);

		// Traslado todos los vectores
		Coordenada vectorIK = new Coordenada(n2_coordenada.getX()
				- origen.getX(), n2_coordenada.getY() - origen.getY());

		Coordenada vectorTraslacion = new Coordenada(tresVecinosAdentro.get(0)
				.getCoordenada().getX()
				- origen.getX(), tresVecinosAdentro.get(0).getCoordenada()
				.getY()
				- origen.getY());
		System.out.println("VECTOR TRASLACION " + vectorIK);

		C1 = Algoritmos.translate(C1, vectorIK);
		C2 = Algoritmos.translate(C2, vectorIK);
		C3 = Algoritmos.translate(C3, vectorIK);
		this.coordenada = Algoritmos.translate(this.coordenada, vectorIK);

		System.out.println("C1 T" + C1);
		System.out.println("C2 T" + C2);
		System.out.println("C3 T" + C3);
		System.out.println("C4 T" + this.coordenada);
	}

	public void calcularCoordenada() throws Exception {
		System.out
				.println("\n***********************************************************");
		System.out.println("CALCULO LA COORDENADA PARA " + this.nombre);
		System.out
				.println("\n***********************************************************");
		List<Nodo> tresVecinos = this.getTresVecinosAdentro();

		Nodo v1 = new Nodo(tresVecinos.get(0).getNombre());
		Coordenada n2_coordenada = tresVecinos.get(0).getCoordenada();
		v1.setCoordenada(n2_coordenada);

		Nodo v2 = new Nodo(tresVecinos.get(1).getNombre());
		Coordenada n5_coordenada = tresVecinos.get(1).getCoordenada();
		v2.setCoordenada(n5_coordenada);

		Nodo v3 = new Nodo(tresVecinos.get(2).getNombre());
		Coordenada n3_coordenada = tresVecinos.get(2).getCoordenada();
		v3.setCoordenada(n3_coordenada);

		// asigno nodos
		System.out
				.println("************ ARMO EL NUEVO EJE  *******************");
		System.out.println("TOMO COMO C1 A " + v1);
		Coordenada C1 = new Coordenada(0.0, 0.0);
		System.out.println("TOMO COMO C2 A " + v2);
		Coordenada C2 = new Coordenada(v2.getCoordenada().getX(), v2
				.getCoordenada().getY());
		System.out.println("TOMO COMO C3 A " + v3);
		Coordenada C3 = new Coordenada(v3.getCoordenada().getX(), v3
				.getCoordenada().getY());

		// calculo las distancias
		Double dc1c2 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n2_coordenada, n5_coordenada),
				4);
		Double dc1c3 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n2_coordenada, n3_coordenada),
				4);
		Double dc2c3 = MathUtils.round(
				Algoritmos.distanciaEntrePuntos(n5_coordenada, n3_coordenada),
				4);

		Double dc1c4 = MathUtils.round(vecinos.get(v1.getNombre()), 4);
		Double dc2c4 = MathUtils.round(vecinos.get(v2.getNombre()), 4);
		Double dc3c4 = MathUtils.round(vecinos.get(v3.getNombre()), 4);

		System.out.println("*******************************");
		System.out.println("DISTANCIA C1 - C2 " + dc1c2);
		System.out.println("DISTANCIA C1 - C3 " + dc1c3);
		System.out.println("DISTANCIA C2 - C3 " + dc2c3);
		System.out.println("DISTANCIA C1 - C4 " + dc1c4);
		System.out.println("DISTANCIA C2 - C4 " + dc2c4);
		System.out.println("DISTANCIA C3 - C4 " + dc3c4);
		System.out.println("*******************************");

		// seteo a c2 sobre el eje x
		C2.setX(dc1c2);
		C2.setY(0.0);

		Double angulo_ghama = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);

		// seteo a la coordenada c3 su x e y
		C3.setX(MathUtils.round(dc1c3 * Math.cos(Math.toRadians(angulo_ghama)),
				4));
		C3.setY(MathUtils.round(dc1c3 * Math.sin(Math.toRadians(angulo_ghama)),
				4));

		// Muestro las nuevas coordenadas
		System.out.println("*******************************");
		System.out.println("C1 " + C1.toString());
		System.out.println("C2 " + C2.toString());
		System.out.println("C3 " + C3.toString());
		System.out.println("*******************************");

		// busco el angulo y genero la coordenada

		Double anguloLanda = MathUtils.round(
				Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3), 4);
		Double anguloBetha = MathUtils.round(
				Algoritmos.reglaDelCoceno(dc1c3, dc1c4, dc3c4), 4);
		Double anguloAlpha = MathUtils.round(
				Algoritmos.reglaDelCoceno(dc1c4, dc1c2, dc2c4), 4);

		System.out.println("************* ANGULOS ******************");
		System.out.println("ANGULO landa (C1 C2 C3) " + anguloLanda);
		System.out.println("ANGULO betha (C1 C4 C3) " + anguloBetha);
		System.out.println("ANGULO alpha (C1 C2 C4) " + anguloAlpha);
		System.out.println("*******************************");

		if (Math.round(anguloBetha) == Math.abs(Math.round(anguloAlpha
				- anguloLanda))) {
			this.coordenada = new Coordenada(MathUtils.round(
					dc1c4 * Math.cos(Math.toRadians(anguloAlpha)), 4),
					MathUtils.round(
							dc1c4 * Math.sin(Math.toRadians(anguloAlpha)), 4));
		} else {
			this.coordenada = new Coordenada(MathUtils.round(
					dc1c4 * Math.cos(Math.toRadians(anguloAlpha)), 4),
					MathUtils.round(
							-1 * dc1c4 * Math.sin(Math.toRadians(anguloAlpha)),
							4));
		}

		System.out.println("*******************************");
		System.out.println("COORDENADA C4 EJE ARMADO " + this.coordenada);
		System.out.println("*******************************");
		// Rotar los vectores
		// supongo la coordenada j de ajuste

		System.out
				.println("*********************BUSCO ANGULO DE ROTACION ********************");

		double angulo = Algoritmos.anguloDeRotacion(v1.getCoordenada(),
				v2.getCoordenada(), v3.getCoordenada());

		System.out.println("ANGULO: " + angulo);
		System.out.println("*******************************");

		C1 = Algoritmos.rotarCoordenada(C1, angulo);
		C2 = Algoritmos.rotarCoordenada(C2, angulo);
		C3 = Algoritmos.rotarCoordenada(C3, angulo);
		this.coordenada = Algoritmos.rotarCoordenada(this.coordenada, angulo);

		System.out
				.println("************Coordenadas Rotadas *******************");
		System.out.println("C1 R" + C1);
		System.out.println("C2 R" + C2);
		System.out.println("C3 R" + C3);
		System.out.println("C4 R" + this.coordenada);
		System.out.println("*******************************");

		System.out
				.println("************Verifico si necesita espejo *******************");

		if (Algoritmos.esEjeYOpuesto(v1.getCoordenada(),v2.getCoordenada(), v3.getCoordenada())) {
			if (!Algoritmos.esEjeXOpuesto(v1.getCoordenada(),
					v2.getCoordenada())) {
				System.out.println("HAGO ESPEJO");
				this.getCoordenada().setY(this.coordenada.getY() * -1);
				C1.setY(-1 * C1.getY());
				C2.setY(-1 * C2.getY());
				C3.setY(-1 * C3.getY());
			}

		} else {
			if (Algoritmos
					.esEjeXOpuesto(v1.getCoordenada(), v2.getCoordenada())) {
				System.out.println("HAGO ESPEJO");
				this.getCoordenada().setY(this.coordenada.getY() * -1);
				C1.setY(-1 * C1.getY());
				C2.setY(-1 * C2.getY());
				C3.setY(-1 * C3.getY());
			}

		}

		System.out.println("*******************************");
		System.out
				.println("************* CALCULO TRASLACION ******************");

		Coordenada origen = new Coordenada(0.0, 0.0);

		// Traslado todos los vectores
		Coordenada vectorIK = new Coordenada(v1.getCoordenada().getX()
				- origen.getX(), v1.getCoordenada().getY() - origen.getY());

		Coordenada vectorTraslacion = new Coordenada(v1.getCoordenada().getX()
				- origen.getX(), v1.getCoordenada().getY() - origen.getY());
		System.out.println("VECTOR TRASLACION " + vectorIK);

		C1 = Algoritmos.translate(C1, vectorIK);
		C2 = Algoritmos.translate(C2, vectorIK);
		C3 = Algoritmos.translate(C3, vectorIK);
		this.coordenada = Algoritmos.translate(this.coordenada, vectorIK);
		System.out
				.println("************* COORDENADAS TRASLADADAS ******************");
		System.out.println("C1 T" + C1);
		System.out.println("C2 T" + C2);
		System.out.println("C3 T" + C3);
		System.out.println("C4 T" + this.coordenada);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (vecinos == null) {
			if (other.vecinos != null)
				return false;
		} else if (!vecinos.equals(other.vecinos))
			return false;
		return true;
	}

}

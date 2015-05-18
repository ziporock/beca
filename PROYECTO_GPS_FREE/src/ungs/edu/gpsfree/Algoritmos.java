package ungs.edu.gpsfree;

import org.apache.commons.math.util.MathUtils;
import org.junit.Test;

public class Algoritmos {

	public static double distanciaEntrePuntos(Coordenada c1, Coordenada c2) {
		return Math.sqrt(Math.pow((c2.getX() - c1.getX()), 2)
				+ (Math.pow((c2.getY() - c1.getY()), 2)));

	}

	public static Double reglaDelCoceno(Double Dip, Double Diq, Double Dpq) {
		Double numerando = (Math.pow(Dip, 2) + Math.pow(Diq, 2) - Math.pow(Dpq,
				2));
		Double denominador = 2 * Dip * Diq;
		Double divicion = (numerando / denominador);// (Math.PI/180);
		double result = Math.acos(divicion) * (180 / Math.PI);
		return MathUtils.round(result, 4);

	}

	public static Coordenada translate(Coordenada c1, Coordenada c2) {
		double x = MathUtils.round(c1.getX() + c2.getX(), 2);
		double y = MathUtils.round(c1.getY() + c2.getY(), 2);
		Coordenada coordenada = new Coordenada(x, y);
		return coordenada;

	}

	public static boolean coolineales(Coordenada a, Coordenada b, Coordenada c) {
		boolean result = false;
		Double mab = (b.getY() - a.getY()) / (b.getX() - a.getX());
		Double mac = (c.getY() - a.getY()) / (c.getX() - a.getX());
		if (mab.equals(mac)) {
			result = true;
		}
		return result;
	}

	public static Coordenada rotarCoordenada(Coordenada coordenada,
			Double angulo) {
		Double x = (double) MathUtils.round(
				coordenada.getX() * (Math.cos(Math.toRadians(angulo)))
						- coordenada.getY()
						* (Math.sin(Math.toRadians(angulo))), 2);
		Double y = (double) MathUtils.round(
				coordenada.getX() * (Math.sin(Math.toRadians(angulo)))
						+ coordenada.getY()
						* (Math.cos(Math.toRadians(angulo))), 2);
		Coordenada resultado = new Coordenada(x, y);
		return resultado;

	}

	public static boolean esEjeXOpuesto(Coordenada k, Coordenada kx) {
		boolean result = false;
		if (kx.getX() < k.getX()) {
			System.out.println("ES EJE X OPUESTO");
			result = true;
		}
		return result;
	}

	public static boolean esEjeYOpuesto(Coordenada k, Coordenada kx,
			Coordenada ky) {
		boolean result = false;

		 Coordenada vectorDirector=new Coordenada(kx.getX()-k.getX(),kx.getY()-k.getY());
		 double pendiente=vectorDirector.getY()/vectorDirector.getX();
		 double valorEnY = ( pendiente * ky.getX() )+( pendiente * (-k.getX())) + k.getY();
		
		 
		 
		if (pendiente<0 && ky.getY() < valorEnY || pendiente>0 && ky.getY() < valorEnY ){
			System.out.println("ES EJE Y OPUESTO");
			result = true;
		}
		 /*
		if (kx.getY() > ky.getY() && k.getY() > ky.getY()) {
			System.out.println("ES EJE Y OPUESTO");
			result = true;
		}
		*/
		return result;
	}

	public double resolver(double m, double b, double x) {
		double resultado = 0;
		resultado = m * x + b;
		return resultado;
	}

	public static double anguloDeRotacion(Coordenada k, Coordenada kx,
			Coordenada ky) {
		double result = 0.0;
		double distancia_kx = Algoritmos.distanciaEntrePuntos(k, kx);
		double adyacente = Math.abs((kx.getX() - k.getX()));
		double opuesto = Math.abs((kx.getY() - k.getY()));
		double angulo = Algoritmos.reglaDelCoceno(adyacente, distancia_kx,
				opuesto);

		// Es Eje Y OPUESTO
		if (esEjeYOpuesto(k, kx, ky)) {

			// ES EJE X OPUESTO
			if (esEjeXOpuesto(k, kx)) {
				// KX MAYOR QUE K
				if (kx.getY() > k.getY()) {
					result = 180.0 - angulo;
					System.out.println("CASO G");
					// KX MENOR QUE K
				} else {
					result = -1 * (180.0 - angulo);
					System.out.println("CASO H");
				}
				// ES EJE X NORMAL
			} else {
				// KX.Y ES MAYOR QUE K.Y
				if (kx.getY() > k.getY()) {
					System.out.println("CASO E");
					result = 360.0 - angulo;
					System.out.println("NECESITO ESPEJO");
					// KX.Y ES MENOR QUE K.Y
				} else {
					result = angulo;
					System.out.println("NECESITO ESPEJO");
					System.out.println("CASO F");
				}
			}
			// Es Eje Y NORMAL
		} else {
			// ES EJE X OPUESTO
			if (esEjeXOpuesto(k, kx)) {
				// KX.Y ES MAYOR QUE K.Y
				if (kx.getY() > k.getY()) {
					System.out.println("NECESITO ESPEJO");
					result = Math.toDegrees(Math.PI) + angulo;
					System.out.println("CASO D");
					// KX.Y ES MENOR QUE K.Y
				} else {
					result = Math.toDegrees(Math.PI) - angulo;
					System.out.println("NECESITO ESPEJO");
					System.out.println("CASO C");
				}
				// ES EJE X NORMAL
			} else {
				// KX.Y ES MAYOR QUE K.Y
				if (kx.getY() > k.getY()) {
					result = angulo;
					// KX.Y ES MENOR QUE K.Y
					System.out.println("CASO A");

				} else {
					result = 360.0 - angulo;
					System.out.println("CASO B");
				}
			}

		}

		return result;

	}

}

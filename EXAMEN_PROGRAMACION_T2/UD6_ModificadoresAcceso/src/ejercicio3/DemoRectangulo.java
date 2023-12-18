package ejercicio3;

import ejercicio1.Coche;

public class DemoRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r1 = new Rectangulo(2,3,10,20);
		System.out.println("Rectángulo referenciado por r1: "+ r1.datosRectangulo());
		r1.desplazar(3,2);
		System.out.println("Rectángulo referenciado por r1 desplazado +3 en ejeX y +2 en eje y:" + r1.datosRectangulo());
		Rectangulo r2 = r1.duplicar();
		System.out.println("Rectangulo referenciado por r2, es un duplicado del objeto referenciado por r1 y vale" + r2.datosRectangulo());
		r2.desplazar(-3,2);
		System.out.println("Rectángulo referenciado por r2 fue desplazado -3 en ejeX y +2 en eje y:" + r2.datosRectangulo());
		System.out.println("Rectángulo referenciado por r1 sigue valiendo: " + r1.datosRectangulo());
		r1.setAncho(11);
		System.out.println("Modificamos el ancho de r1 a 11: "+ r1.datosRectangulo());
		System.out.println("Suponemos que dados dos rectángulos el mayor es el de mayor área, ¿el referenciado por r1 es mayor que el referenciado por r2?: "+ r1.esMayor(r2));
		// probamos los modificadores de acceso entre clases y métodos de diferentes paquetes
		Coche coche = new Coche();
		System.out.println(coche.getDeposito());
	}

}

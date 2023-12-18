package unidad_this;

public class MainCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c1= new Cuenta("111-222","Lebron James",50.0);
		System.out.println("El saldo inicial " + c1.getNombre() + " es: " + c1.getSaldo());
		Cuenta c2= new Cuenta("999-888","Stephen Curry",100.0);
		System.out.println("El saldo inicial " + c2.getNombre() + " es: " + c2.getSaldo());
		c1.setSaldo(250.0);
		System.out.println("El nuevo saldo " + c1.getNombre() + " es: " + c1.getSaldo());
		c2.setSaldo(877.5);
		System.out.println("El nuevo saldo " + c2.getNombre() + " es: " + c2.getSaldo());
		Cuenta cuentaMasSaldo = c1.comparaCuenta(c2);
		System.out.println("El titular con más saldo es " + cuentaMasSaldo.getNombre() + " y tiene un saldo " + cuentaMasSaldo.getSaldo() + " €");
	}

}

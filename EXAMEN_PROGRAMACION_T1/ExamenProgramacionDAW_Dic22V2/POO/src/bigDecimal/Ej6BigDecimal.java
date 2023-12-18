package bigDecimal;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ej6BigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal pvp, impuesto;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el precio: ");
		BigDecimal precio = sc.nextBigDecimal();
		System.out.println("Introduzca el impuesto: ");
		BigDecimal tasa = sc.nextBigDecimal();
		sc.close();
		precio = precio.setScale(2, RoundingMode.UP);
		System.out.println("Precio: " + precio);
		tasa = tasa.setScale(2, RoundingMode.UP);
		impuesto = (precio.multiply(tasa)).divide(new BigDecimal("100"));
		System.out.println("Impuesto: " + impuesto.setScale(2, RoundingMode.UP));
		pvp = precio.add(impuesto);
		System.out.println("pvp: " + pvp.setScale(2,RoundingMode.UP));
		

	}

}

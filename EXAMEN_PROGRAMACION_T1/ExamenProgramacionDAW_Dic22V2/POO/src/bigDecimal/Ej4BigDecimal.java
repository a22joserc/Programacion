package bigDecimal;
import java.util.Scanner;
import java.math.BigDecimal;


public class Ej4BigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal pvp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el precio del artículo: ");
		BigDecimal precio = sc.nextBigDecimal();
		System.out.println("Introduzca el impuesto: ");
		BigDecimal impuesto = sc.nextBigDecimal();
		sc.close();
		pvp = precio.add((precio.multiply(impuesto)).divide(new BigDecimal("100")));
		System.out.println(pvp);

	}

}

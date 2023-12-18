package bigDecimal;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DemoBigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal numero1 = new BigDecimal("10.7");
		BigDecimal numero2 = new BigDecimal("5.4");
		System.out.println(numero1.add(numero2).setScale(5));
		System.out.println(numero1.subtract(numero2));
		System.out.println(numero1.multiply(numero2));
		System.out.println(numero1.divide(numero2,RoundingMode.DOWN));

	}

}

package bigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class DemoBigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*long miLong=9223372036854775807l;
		 BigInteger bigInt=new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999");
		 System.out.println(miLong);
		 System.out.println(bigInt);
		 BigInteger suma=bigInt.add(new BigInteger("1"));
		 System.out.println(suma);*/
		//BigInteger numberA = new BigInteger("98765432123456789");
		//BigInteger numberB = BigInteger.TEN;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca BigInteger numberA: ");
		BigInteger numberA = sc.nextBigInteger();
		System.out.println("Introduzca BigInteger numberB: ");
		BigInteger numberB = sc.nextBigInteger();
		sc.close();
		numberA = numberA.add(numberB);
		System.out.println("numberA = " + numberA);
		numberA = numberA.multiply(numberB);
		System.out.println("numberA = " + numberA);
		numberA = numberA.subtract(numberB);
		System.out.println("numberA = " + numberA);
		numberA = numberA.divide(numberB);
		System.out.println("numberA = " + numberA);
		numberA = numberA.mod(numberB);
		System.out.println("numberA = " + numberA);
		numberA = numberA.pow(2);
		System.out.println("numberA = " + numberA);
		numberA = numberA.negate();
		System.out.println("numberA = " + numberA);
		 
	}

}

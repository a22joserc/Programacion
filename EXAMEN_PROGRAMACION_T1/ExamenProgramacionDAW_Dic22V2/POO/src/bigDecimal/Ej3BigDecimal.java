package bigDecimal;
import java.math.BigDecimal;

public class Ej3BigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal bd2 = new BigDecimal("2");
		System.out.println(2.00 - 1.1);
		 System.out.println(2.00 - 1.2);
		 System.out.println(2.00 - 1.3);
		 System.out.println(2.00 - 1.4);
		 System.out.println(2.00 - 1.5);
		 System.out.println(2.00 - 1.6);
		 System.out.println(2.00 - 1.7);
		 System.out.println(2.00 - 1.8);
		 System.out.println(2.00 - 1.9);
		 System.out.println(2.00 - 2);
		 System.out.println("***************************************");
		 BigDecimal bd1 = new BigDecimal("1.1");
		 BigDecimal bdadd = new BigDecimal("0.1");
		 /*System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));
		 bd1 = bd1.add(bdadd);
		 System.out.println(bd2.subtract(bd1));*/
		 //
		 for (int i=0; i<10; i++) {
			 System.out.println(bd2.subtract(bd1));	 
			 bd1 = bd1.add(bdadd);
		 }
		
		
		 
	}

}

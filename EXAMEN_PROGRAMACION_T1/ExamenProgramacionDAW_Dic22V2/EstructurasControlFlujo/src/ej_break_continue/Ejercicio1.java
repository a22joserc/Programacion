package ej_break_continue;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Sentencia BREAK: ");
		 for(int i=1; i<=3;i++){
			 System.out.println("Bucle externo, COMIENZA iteración:"+i);
			 for(int j=1;j<=5;j++){
				 if(j==3)
					 break;
				 System.out.println("\tBucle interno en iteración:"+j);
			 }
			 System.out.println("Bucle externo, FINALIZA iteración:"+i +"\n");
		 }
		 System.out.println("**********************************************");
		 System.out.println("Sentencia CONTINUE: ");
		 for(int q=1; q<=3;q++){
			 System.out.println("Bucle externo, COMIENZA iteración:" + q);
			 for(int k=1;k<=5;k++){
				 if(k==3)
					 continue;
				 System.out.println("\tBucle interno en iteración:" + k);
			 }
		 System.out.println("Bucle externo, FINALIZA iteración:"+ q +"\n");
		 }

	}

}

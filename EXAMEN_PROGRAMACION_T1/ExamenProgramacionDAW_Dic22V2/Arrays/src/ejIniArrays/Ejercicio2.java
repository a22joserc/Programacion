package ejIniArrays;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[][] arrayDosD= new int[3][];
		arrayDosD[0]=new int[4]; 
		arrayDosD[1]=new int[2];
		arrayDosD[2]=new int[3];
		System.out.println("Bucle Anidado");
		int num=11;
	    for (int i=0; i<arrayDosD.length; i++) {
	    	 for(int j=0; j<arrayDosD[i].length; j++) {
	    		 arrayDosD[i][j]=num+j;
	    		 System.out.println("arrayDosD[" + i+ "]["+ j +"]="+ arrayDosD[i][j]);
	    	 }
	    	 num += 10;
	     }
	    
	    System.out.println("***********************************");
	    System.out.println("Otra interpretación");
	    int[][] arrayDosD2 = {{11,12,13,14},{21,22},{31,32,33}};
	    for (int i=0; i<arrayDosD2.length; i++) {
	    	 for(int j=0; j<arrayDosD2[i].length; j++) {
	    		 System.out.print(arrayDosD2[i][j] + " ");
	    	 }
	    	 System.out.println("");
	     }

	}

}

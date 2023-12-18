package ejercicioRecursividadMultiplicar;

public class Multiplicacion {
	 int multiplicar(int a, int b){
		 if(b==1) {
			 return a;
		 }
		 else{
			 return a + multiplicar(a,b-1);
		 }
	 }

	

}

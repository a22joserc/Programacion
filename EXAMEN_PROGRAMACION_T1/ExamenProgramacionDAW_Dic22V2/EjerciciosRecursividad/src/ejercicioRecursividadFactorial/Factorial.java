package ejercicioRecursividadFactorial;

public class Factorial {
	
	public int calculaFactorial(int num) {
		int factorial;
		if (num==0) {
			factorial = 1;
		}
		else {
			factorial = num * calculaFactorial(num-1);
		}
		return factorial;
	}

}

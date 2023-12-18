package ejercicio3;

public class DemoPotencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DemoPotencia.pot(2,1));
		System.out.println(pot(5,3));
		System.out.println(new DemoPotencia().pot(9,0));

	}
	
	public static int pot(int base,int exponente) {
		int resultado=1;
		for (;exponente>0;exponente--){
			resultado=resultado*base;
		}
		return resultado;	
	}

}

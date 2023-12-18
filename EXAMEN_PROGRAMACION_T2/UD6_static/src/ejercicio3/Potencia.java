package ejercicio3;

public class Potencia {
	
	public int elevar(int base,int exponente){
		int resultado=1;
		for(;exponente>0;exponente--){
			resultado=resultado*base;
		}
		return resultado;
	}
}

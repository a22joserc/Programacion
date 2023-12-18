package ejercicio1;


public class MasTres implements Serie{
	
	
	int inicio;
	int val;
	
	public MasTres() {
		inicio = 0;
		val=0;
	}
	
	@Override
	public void establecerInicio(int x) {
		inicio = x;
		val = x;
	}
	
	@Override
	public int obtenerSiguiente() {
		val+=3;
		return val;
	}
	
	@Override
	public void restablecer() {
		inicio = 0 ;
		val = 0;
	}


}

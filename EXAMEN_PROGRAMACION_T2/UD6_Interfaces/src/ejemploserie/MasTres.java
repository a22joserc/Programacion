package ejemploserie;


public class MasTres implements Serie {
	
	int inicio;
	int val;
	
	public MasTres() {
		inicio = 0;
		val=0;
	}
	
	public int obtenerSiguiente() {
		val+=3;
		return val;
	}
	
	public void resetablecer() {
		inicio = 0 ;
		val = 0;
	}
	
	public void establecerInicio(int x) {
		inicio = x;
		val = x;
	}

}

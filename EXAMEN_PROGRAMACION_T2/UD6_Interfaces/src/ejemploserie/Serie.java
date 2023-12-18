package ejemploserie;

public interface Serie {
	int obtenerSiguiente(); //devuelve el siguiente número de la serie,
    void restablecer(); //reinicia
    void establecerInicio(int x);
}

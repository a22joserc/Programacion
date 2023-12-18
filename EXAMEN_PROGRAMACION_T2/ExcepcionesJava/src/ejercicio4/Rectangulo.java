package ejercicio4;

public class Rectangulo {
	
	Punto origen;
    int ancho;
    int alto;
    
    Rectangulo(int x, int y, int w, int h) throws Exception {
        if (x < 0 || y < 0) {
        	throw new Exception("No se pueden generar Rectágulos con coordenadas negativas");
        }
        else {
        	origen = new Punto(x,y);
        	ancho = w;
        	alto = h;
        }
    }
	
}

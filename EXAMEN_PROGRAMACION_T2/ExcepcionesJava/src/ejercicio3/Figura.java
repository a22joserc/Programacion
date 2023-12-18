package ejercicio3;

public abstract class Figura {
	
	protected String color;
	
    public Figura(String color) throws Exception {
    	
    	if (color.equalsIgnoreCase("blanco")) {
    		throw new Exception("No se puede generar figuras de color blanco"); 
    	}
    	else {
    		this.color = color;
    	}
    }
	
    public abstract double area();

}

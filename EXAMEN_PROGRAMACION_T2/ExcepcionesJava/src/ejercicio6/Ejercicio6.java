package ejercicio6;

public class Ejercicio6 {
	public static void main(String[] args) {
		
		try{
            // new Ordenador("DELL122",8,1024,533,(float)2.0,"SATA",7200,"i7",(float)3.3,400);
            System.out.println("ORDENADOR DELL122 OK");
    }catch(OrdenadorException e){
            System.out.println(e.getMessage());
    }
    try{
            // new Ordenador("CLONIC900",8,"DDR2",533,(float)2.0,"SATA3",7200,"i7",(float)3.3,400);
            System.out.println("ORDENADOR CLONIC900 OK");
    }catch(OrdenadorException e){
            System.out.println(e.getMessage());
    }
    try{
            // new Ordenador("HP511",2,"DDR2",533,(float)2.0,"SATA",7200,"i5",(float)3.3,400);
            System.out.println("ORDENADOR HP511 OK");
    }catch(OrdenadorException e){
            System.out.println(e.getMessage());
    }
		
		
	}

}

package ejdni;

public class EjDni {

	public static void main(String[] args) {
		String[] dnis ={"12345678A","123456789A","123456789","0000001R","00000001R","","123abv11a"};	
       	
	   for(String dni:dnis){
		   try{
			   System.out.println("intentando crear "+ dni);
			   DNI d =new DNI(dni);
			   System.out.println(dni+ " ¡creado con exito!");
		   }
		   catch(DNIException e){
			   System.out.println(e.getMessage());
		   }
	   }
	}

}

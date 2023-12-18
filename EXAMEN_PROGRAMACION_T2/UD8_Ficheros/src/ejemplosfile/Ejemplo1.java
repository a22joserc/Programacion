package ejemplosfile;

import java.io.File;

public class Ejemplo1 {

	public static void main(String[] args) {
		File prueba = new File("test.txt");
        if(!prueba.exists())
            System.out.println("test.txt NO existe");
        if(!new File("c:\\midirectorio").exists())
            System.out.println("c:\\midirectorio NO existe");
        if(!new File("m:").exists())
            System.out.println("m: NO existe");
        
        if(new File("l:\\midirectorio\\prueba.txt").exists())
            System.out.println("l:\\midirectorio\\prueba.txt existe");

	}

}

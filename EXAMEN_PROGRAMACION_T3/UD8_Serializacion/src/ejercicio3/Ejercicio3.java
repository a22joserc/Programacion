package ejercicio3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Persona persona = new Persona("Ramón García", "abc123.");
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("persona.dat"));
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("persona.dat"))){
			// Guardamos
			objectOutputStream.writeObject(persona);
			// Leemos
			Persona personaRecuperada = (Persona) objectInputStream.readObject();
			// Imprimimos Info Persona -> Vemos que no se puestra la contraseña
			System.out.println(personaRecuperada.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

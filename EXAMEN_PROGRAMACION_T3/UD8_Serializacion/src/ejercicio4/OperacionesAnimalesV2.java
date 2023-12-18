package ejercicio4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OperacionesAnimalesV2 {
	
	private final static int NUM_MAX_PERROS = 5;
	private final static int NUM_MAX_GATOS = 5;
	private static int numPerros; 
	private static int numGatos; 
	private ArrayList<Animal> animales;
	
	
	public OperacionesAnimalesV2() {
		this.animales = new ArrayList<>();
		numPerros = 0;
		numGatos = 0;
	}
	
	public ArrayList<Animal> getAnimales() {
		return animales;
	}
	
	
	public boolean addAnimal(Animal animal) {
		if (animal instanceof Perro && numPerros == NUM_MAX_PERROS) {
			return false;
		}
		if (animal instanceof Gato && numGatos == NUM_MAX_GATOS) {
			return false;
		}
		if (animal instanceof Perro) {
			this.getAnimales().add(animal);
			numPerros++;
		}
		else {
			this.getAnimales().add(animal);
			numGatos++;
		}
		return true;
	}
	
	public void gardarAnimaisADisco(String fichero) {
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero))){
			objectOutputStream.writeInt(this.getAnimales().size());
			objectOutputStream.writeObject(this.getAnimales());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public ArrayList<Animal> lerAnimaisDisco(String fichero) {
		
		ArrayList<Animal> listaAnimalesRecuperada = new ArrayList<>();
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fichero))){
			int tamano = objectInputStream.readInt();
			System.out.println(tamano);
			listaAnimalesRecuperada = (ArrayList<Animal>) objectInputStream.readObject();
			return listaAnimalesRecuperada;
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return listaAnimalesRecuperada;
	}
}

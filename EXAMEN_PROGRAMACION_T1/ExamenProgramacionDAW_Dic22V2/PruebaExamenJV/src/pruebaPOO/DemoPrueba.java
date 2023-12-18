package pruebaPOO;
import java.util.Random;

public class DemoPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Generamos un array de objetos Rueda
		Rueda[] ruedas = new Rueda[tipoRueda.values().length];
		String[] marcaRuedas = {"Michelin","Michelin","Michelin","Michelin","Hankook"};
		int[] anoRuedas = {2018, 2018, 2020, 2020, 2012};
		double[] precioRuedas = {125.8, 125.8, 85, 85, 54.2};
		for (int i=0; i<ruedas.length; i++) {
			ruedas[i] = new Rueda(marcaRuedas[i],anoRuedas[i],precioRuedas[i],tipoRueda.values()[i]);
		}

		Coche coche = new Coche("3565-DPX","Citroen","C4",1203.5,ruedas,tipoCoche.Diesel);
		coche.mostrarInfoCoche();
		Coche cocheSustitucion = new Coche("4455-LMM","Tesla","Model 3",1900.5,ruedas,tipoCoche.Electrico);
		coche.setCocheSustitucion(cocheSustitucion);
		coche.mostrarInfoCoche();
		Coche cocheMasPesado = coche.comparaCochePeso(cocheSustitucion);
		System.out.println("El coche más pesado tiene matricula: " + cocheMasPesado.getMatricula() + " - Marca: " + cocheMasPesado.getMarca() + " - Modelo: " + cocheMasPesado.getModelo());
		// Creamos persona
		Persona persona = new Persona();
		System.out.println(persona.toString());
		String cadena= "José Víctor|Ramos Castro|87654321H|Travesia 123|45825.5";
		persona.setFromCadena(cadena);
		System.out.println(persona.toString());
		// Creamos Concesionario
		Concesionario concesionario = new Concesionario(persona);
		concesionario.crearFlotaCoches(2);
		concesionario.agregarCoche(cocheSustitucion, 0);
		concesionario.agregarCoche(coche, 1);
		concesionario.eleminarCoche("3565-DPX");
		int[] numTipoCoches = concesionario.contarTipoCoche();
		imprimirArray1D(numTipoCoches);

	}
	
	public static void imprimirArray1D(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println("");
	}

}

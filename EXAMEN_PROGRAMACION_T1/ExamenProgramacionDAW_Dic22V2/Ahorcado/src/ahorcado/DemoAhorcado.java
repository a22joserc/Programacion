package ahorcado;
import java.util.Scanner;

public class DemoAhorcado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		char[] letrasAcertadas = "___________".toCharArray();
		int numFallos = 0;
		String letrasJugadas = "";
		Scanner sc = new Scanner(System.in);
		int intentos = 0;
		int contLetrasActerdas = 0;
		do {
			intentos++;
			System.out.print("Jugar la letra: ");
			String letra = sc.nextLine();
			int posLetra = comprobarLetra(letra,letrasAcertadas);
			if (posLetra != -1) {
				letrasAcertadas[posLetra] = letra.toCharArray()[0];
				contLetrasActerdas++;
			}
			else {
				numFallos++;
				imprimirFallo(numFallos);
			}
			letrasJugadas = letrasJugadas.concat(letra);
			System.out.println("Letras jugadas: " + letrasJugadas);
			System.out.print("Letras acertadas: ");
			imprimirCharArray(letrasAcertadas);	
		}while(!(numFallos >= 10 || contLetrasActerdas == PALABRAOBJETIVO.length));
		sc.close();
		if (contLetrasActerdas == PALABRAOBJETIVO.length) {
			System.out.println("Fin del Juego: Has acertado en " + intentos + " intentos!");
		}
		else {
			System.out.println("Lo sentimos has superado el número de fallos permitidos! Vuelve a intentarlo!");
		}
	}
	
	private static char[] PALABRAOBJETIVO = "PROGRAMANDO".toCharArray();
	
	/*public static int comprobarLetra(String letra) {
		
		for (int i=0; i< PALABRAOBJETIVO.length; i++) {
			if (PALABRAOBJETIVO[i] == letra.toCharArray()[0]) {
				PALABRAOBJETIVO[i] = ' ';
				return i;
			}
		}
		return -1;
	}*/
	
	
	public static int comprobarLetra(String letra, char[] letrasAcertadas) {
		
		for (int i=0; i< PALABRAOBJETIVO.length; i++) {
			if (PALABRAOBJETIVO[i] == letra.toCharArray()[0] && letrasAcertadas[i] == '_') {
				return i;
			}
		}
		return -1;
	}
	
	
	public static void imprimirCharArray(char[] array) {
		for (int i=0; i< array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}
	
	public static void imprimirCharArray2D(char[][] array2D) {
		for (int i=0; i < array2D.length; i++) {
			for (int j=0; j < array2D[i].length; j++) {
				System.out.print(array2D[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void imprimirFallo(int numFallos) {
		switch (numFallos){
			case 1:
				imprimirCharArray2D(array1);
				break;
			case 2:
				imprimirCharArray2D(array2);
				break;
			case 3:
				imprimirCharArray2D(array3);
				break;
			case 4:
				imprimirCharArray2D(array4);
				break;
			case 5:
				imprimirCharArray2D(array5);
				break;
			case 6:
				imprimirCharArray2D(array6);
				break;
			case 7:
				imprimirCharArray2D(array7);
				break;
			case 8:
				imprimirCharArray2D(array8);
				break;
			case 9:
				imprimirCharArray2D(array9);
				break;
			case 10:
				imprimirCharArray2D(array10);
				break;
		}
	}
	
	public static final char[][] array1 = {{' ',' ',' ',' ',' ',' ',' ',' '},
										   {' ',' ',' ',' ',' ',' ',' ',' '},
										   {' ',' ',' ',' ',' ',' ',' ',' '},
										   {' ',' ',' ',' ',' ',' ',' ',' '},
										   {' ',' ',' ',' ',' ',' ',' ',' '},
										   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array2 = {{'+',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array3 = {{'+','-','-','-','-','+',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array4 = {{'+','-','-','-','-','+',' ',' '},
			   							   {'|',' ',' ',' ',' ','|',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array5 = {{'+','-','-','-','-','+',' ',' '},
			   							   {'|',' ',' ',' ',' ','|',' ',' '},
			   							   {'|',' ',' ',' ',' ','(',')',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array6 = {{'+','-','-','-','-','+',' ',' '},
			   							   {'|',' ',' ',' ',' ','|',' ',' '},
			   							   {'|',' ',' ',' ',' ','(',')',' '},
			   							   {'|',' ',' ',' ',' ','[',']',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array7 = {{'+','-','-','-','-','+',' ',' '},
			   							   {'|',' ',' ',' ',' ','|',' ',' '},
			   							   {'|',' ',' ',' ',' ','(',')',' '},
			   							   {'|',' ',' ',' ','/','[',']',' '},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array8 = {{'+','-','-','-','-','+',' ',' '},
			   							   {'|',' ',' ',' ',' ','|',' ',' '},
			   							   {'|',' ',' ',' ',' ','(',')',' '},
			   							   {'|',' ',' ',' ','/','[',']','\\'},
			   							   {'|',' ',' ',' ',' ',' ',' ',' '},
			   							   {'+','-','-','-','-','-','-',' '}};
	public static final char[][] array9 = {{'+','-','-','-','-','+',' ',' '},
										   {'|',' ',' ',' ',' ','|',' ',' '},
										   {'|',' ',' ',' ',' ','(',')',' '},
										   {'|',' ',' ',' ','/','[',']','\\'},
										   {'|',' ',' ',' ',' ','/',' ',' '},
										   {'+','-','-','-','-','-','-',' '}};
	
	public static final char[][] array10 = {{'+','-','-','-','-','+',' ',' '},
											{'|',' ',' ',' ',' ','|',' ',' '},
										    {'|',' ',' ',' ',' ','(',')',' '},
										    {'|',' ',' ',' ','/','[',']','\\'},
										    {'|',' ',' ',' ',' ','/','\\',' '},
										    {'+','-','-','-','-','-','-',' '}};
}

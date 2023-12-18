package democentroacademicoV4final;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public static void menuCrearAlumno(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno = getCodigoAlumno(sc);
		String nombreAlumno = getNombreAlumno(sc);
		centroAcademico.crearAlumno(codigoAlumno, nombreAlumno);
	}
	
	public static void menuCrearAsignatura(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAsignatura = getCodigoAsignatura(sc);
		String nombreAsignatura = getNombreAsignatura(sc);
		String creditos;
		boolean flag = true;
		do {
			System.out.println("Introduzca el número de creditos de la asingatura");
			creditos = sc.nextLine().trim();
			// creditos = sc.nextLine().replaceAll("\\s", "");
			try {
				if (Integer.parseInt(creditos) <= 0) {
					System.out.println("ERROR: El número de créditos tiene que se mayor que cero!");
				}
				else {
					centroAcademico.crearAsignatura(codigoAsignatura, nombreAsignatura, creditos);
					flag = false;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: El número de créditos tiene que ser un número entero!");
			}
		} while(flag);
	}
	
	public static void menuMatricular(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno = getCodigoAlumno(sc);
		String codigoAsignatura = getCodigoAsignatura(sc);
		centroAcademico.matricular(codigoAlumno, codigoAsignatura);
	}
	
	public static void menuImprimirAlumno(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno = getCodigoAlumno(sc);
		centroAcademico.imprimirAlumno(codigoAlumno);
	}
	
	public static void menuAgregarCalificacion(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno = getCodigoAlumno(sc);
		String codigoAsignatura = getCodigoAsignatura(sc);	
		double nota = getNotaAsignatura(sc);
		centroAcademico.agregarCalificacion(codigoAlumno,codigoAsignatura, nota);
	}
	
	public static void menuImprimirAsignatura(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAsignatura = getCodigoAsignatura(sc);	
		try {
			centroAcademico.imprimirAsignatura(codigoAsignatura);
		}
		catch (AsignaturaException e){
			System.out.println("Excepcion capturada -> " + e.getMessage());
		}
	}
	
	public static void menuCompararAlumnos(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno1 = getCodigoAlumno(sc);
		String codigoAlumno2 = getCodigoAlumno(sc);
		centroAcademico.compararAlumno(codigoAlumno1, codigoAlumno2);
	}

	
	public static boolean validarDni (String dni) {
		// return dni.matches("^[0-9]{8}[A-Z]$");
		return dni.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
	}
	
	public static boolean validarCodigoAsignatura(String codigoAsignatura) {
		return codigoAsignatura.matches("^A-[0-9]{3}$");
	}
	
	
	public static String getNombreAlumno(Scanner sc) {
		String nombreAlumno;
		boolean flag;
		do {
			System.out.println("Introduzca el nombre del alumno: ");
			nombreAlumno = sc.nextLine().trim();
			// nombreAlumno = sc.nextLine().replaceAll("\\s", "");
			flag = validarCadena(nombreAlumno);
			if (flag) {
				System.out.println("ERROR: El nombre del estudiante no se puede dejar en blanco!");
			}
		}while(flag);
		return nombreAlumno;
	}
	
	
	public static String getNombreAsignatura(Scanner sc) {
		String nombreAsignatura;
		boolean flag;
		do {
			System.out.println("Introduzca el nombre de la asignatura: ");
			nombreAsignatura = sc.nextLine().trim();
			// nombreAsignatura = sc.nextLine().replaceAll("\\s", "");
			flag = validarCadena(nombreAsignatura);
			if (flag) {
				System.out.println("ERROR: El nombre de la asignatura no se puede dejar en blanco!");
			}
		}while(flag);
		return nombreAsignatura;
	}
	
	
	public static String getCodigoAlumno(Scanner sc) {
		boolean flag;
		String dniAlumno;
		do {
			System.out.println("Introduzca el código del alumno que debe corresponderse con su DNI: ");
			dniAlumno = sc.nextLine().trim();
			// dniAlumno = sc.nextLine().replaceAll("\\s", "");
			flag = validarDni(dniAlumno);
			if (!flag) {
				System.out.println("ERROR: El formato del DNI es erróneo!");
			}
		} while(!flag);
		return dniAlumno;
	}
	
	public static String getCodigoAsignatura(Scanner sc) {
		boolean flag;
		String codigoAsignatura;	
		do {
			System.out.println("Introduzca el código de la asingatura");
			codigoAsignatura = sc.nextLine().trim();
			// codigoAsignatura = sc.nextLine().replaceAll("\\s", "");
			flag = validarCodigoAsignatura(codigoAsignatura);
			if (!flag) {
				System.out.println("ERROR: El código de la Asignatura debe empezar por A- y tener tres números. Ejemplo A-111!");
			}	
		}while(!flag);
		return codigoAsignatura;
	}
	
	public static double getNotaAsignatura(Scanner sc) {
		boolean flag = true;
		double nota;
		do {
			try {
				System.out.println("Introduzca la nota de la asingatura");
				nota = sc.nextDouble();
				if (nota < 0) {
					System.out.println("ERROR: La nota no puede ser menor que 0!");
				}
				else {
					flag = false;
				}
			}
			catch (InputMismatchException e){
				sc.nextLine();
				nota  = 0;
                System.out.println("ERROR: Debe introducir un Double!");
			}
		}while(flag);
		return nota;
	}
	
	
	public static boolean validarCadena(String str) {
		return str.isBlank() || str.isEmpty();
	}

}

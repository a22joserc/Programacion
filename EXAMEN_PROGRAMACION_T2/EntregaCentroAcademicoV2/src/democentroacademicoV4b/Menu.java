package democentroacademicoV4b;

import java.util.InputMismatchException;
import java.util.Scanner;
import centroacademicoexceptions.*;


public class Menu {
	
	
	public static void menuCrearAlumno(Scanner sc, CentroAcademico centroAcademico) {
		String nombreAlumno = getNombreAlumno(sc);
		boolean flag = true;
		do {
			System.out.println("Introduzca el número de expediente del alumno: ");
			String codigoAlumno = sc.nextLine();
			try {
				centroAcademico.crearAlumno(codigoAlumno, nombreAlumno);
				flag = false;
			}
			catch (AlumnoCodigoException e) {
				System.out.println(e.getMessage());
			}
		} while(flag);
	}
	
	
	public static void menuCrearAsignatura(Scanner sc, CentroAcademico centroAcademico) {
		String nombreAsignatura = getNombreAsignatura(sc);
		String creditos = "";
		String codigoAsignatura = "";
		boolean flag = true;
		do {
			if (codigoAsignatura.equals("")) {
				System.out.println("Introduzca el código de la asingatura");
				codigoAsignatura = sc.nextLine().trim();
				// codigoAsignatura = sc.nextLine().replaceAll("\\s","");
			}
			if (creditos.equals("")) {
				System.out.println("Introduzca el número de creditos de la asingatura");
				creditos = sc.nextLine();
				// creditos = sc.nextLine().replaceAll("\\s","");
			}
			try {
				centroAcademico.crearAsignatura(codigoAsignatura, nombreAsignatura, creditos);
				flag = false;
			}
			catch (AsignaturaCodigoException e) {
				System.out.println(e.getMessage());
				codigoAsignatura = "";
			}
			catch (AsignaturaCreditosException e) {
				System.out.println(e.getMessage());
				creditos = "";
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: El número de créditos tiene que ser un número entero!");
				creditos = "";
			}
		} while(flag);
	}
	
	
	public static void menuMatricular(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno = "";
		String codigoAsignatura = "";
		boolean flag = true;
		do {
			if (codigoAlumno.equals("")) {
				System.out.println("Introduzca el número de expediente del alumno: ");
				codigoAlumno = sc.nextLine();
				// codigoAlumno = sc.nextLine().replaceAll("\\s","");
			}
			if (codigoAsignatura.equals("")) {
				System.out.println("Introduzca el código de la asingatura");
				codigoAsignatura = sc.nextLine();
				// codigoAsignatura = sc.nextLine().replaceAll("\\s","");
			}
			try {
				centroAcademico.matricular(codigoAlumno, codigoAsignatura);
				flag = false;
			}
			catch (AlumnoCodigoException e) {
				System.out.println(e.getMessage());
				codigoAlumno = "";
			}
			catch (AsignaturaCodigoException e) {
				System.out.println(e.getMessage());
				codigoAsignatura = "";
			}
		}while(flag);
	}
	
	
	public static void menuImprimirAlumno(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno;
		boolean flag = true;
		do {
			System.out.println("Introduzca el número de expediente del alumno: ");
			codigoAlumno = sc.nextLine();
			// codigoAlumno = sc.nextLine().replaceAll("\\s","");
			try {
				centroAcademico.imprimirAlumno(codigoAlumno);
				flag = false;
			} catch (AlumnoCodigoException e) {
				System.out.println(e.getMessage());
			}
		}while(flag);
	}
	
	
	public static void menuAgregarCalificacion(Scanner sc, CentroAcademico centroAcademico) {		
		double nota = getNotaAsignatura(sc);
		String codigoAlumno = "";
		String codigoAsignatura = "";
		boolean flag = true;
		do {
			if (codigoAlumno.equals("")) {
				System.out.println("Introduzca el número de expediente del alumno: ");
				codigoAlumno = sc.nextLine();
				// codigoAlumno = sc.nextLine().replaceAll("\\s","");
			}
			if (codigoAsignatura.equals("")) {
				System.out.println("Introduzca el código de la asingatura");
				codigoAsignatura = sc.nextLine();
				// codigoAsignatura = sc.nextLine().replaceAll("\\s","");
			}
			try {
				centroAcademico.agregarCalificacion(codigoAlumno,codigoAsignatura, nota);
				flag = false;
			}
			catch (AlumnoCodigoException e) {
				System.out.println(e.getMessage());
				codigoAlumno = "";
			}
			catch (AsignaturaCodigoException e) {
				System.out.println(e.getMessage());
				codigoAsignatura = "";
			}			
		}while(flag);
	}
	
	public static void menuImprimirAsignatura(Scanner sc, CentroAcademico centroAcademico) {
		boolean flag = true;
		String codigoAsignatura = "";
		do {	
			if (codigoAsignatura.equals("")) {
				System.out.println("Introduzca el código de la asingatura");
				codigoAsignatura = sc.nextLine();
				// codigoAsignatura = sc.nextLine().replaceAll("\\s","");
			}
			try {
				centroAcademico.imprimirAsignatura(codigoAsignatura);
				flag = false;
			}
			catch (AsignaturaCodigoException e) {
				System.out.println(e.getMessage());
				codigoAsignatura = "";
			}
			catch (AsignaturaException e) {
				System.out.println("Excepcion capturada -> " + e.getMessage());
				flag = false;
			} 
			
		} while(flag);
	}
	
	public static void menuCompararAlumnos(Scanner sc, CentroAcademico centroAcademico) {
		String codigoAlumno1;
		String codigoAlumno2;
		boolean flag = true;
		do {
			System.out.println("Introduzca el número de expediente del alumno 1: ");
			codigoAlumno1 = sc.nextLine();
			// codigoAlumno1 = sc.nextLine().replaceAll("\\s","");
			System.out.println("Introduzca el número de expediente del alumno 2: ");
			codigoAlumno2 = sc.nextLine();
			// codigoAlumno2 = sc.nextLine().replaceAll("\\s","");
			try {
				centroAcademico.compararAlumno(codigoAlumno1, codigoAlumno2);
				flag = false;
			} catch (AlumnoCodigoException e) {
				System.out.println(e.getMessage());
			}
		}while(flag);
	}
	
	public static String getNombreAlumno(Scanner sc) {
		String nombreAlumno;
		boolean flag;
		do {
			System.out.println("Introduzca el nombre del alumno: ");
			nombreAlumno = sc.nextLine().trim();
			// nombreAlumno = sc.nextLine().replaceAll("\\s","");
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
			// nombreAsignatura = sc.nextLine().replaceAll("\\s","");
			flag = validarCadena(nombreAsignatura);
			if (flag) {
				System.out.println("ERROR: El nombre de la asignatura no se puede dejar en blanco!");
			}
		}while(flag);
		return nombreAsignatura;
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
		sc.nextLine();
		return nota;
	}
	
	
	public static boolean validarCadena(String str) {
		return str.isBlank() || str.isEmpty();
	}

}

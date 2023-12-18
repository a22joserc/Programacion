package democentroacademicoV4;

import java.util.Scanner;

public class DemoCentroAcademico {

	public static void main(String[] args) {
		CentroAcademico centroAcademico = new CentroAcademico();
		Scanner sc = new Scanner(System.in);
		boolean flagAsignaturas = false;
		boolean flagAlumnos = false;
		boolean flagMatricular = false;
		do {
			System.out.println("***************************************************************************************************");
			System.out.println("                                                MENÚ                                               ");
			System.out.println("***************************************************************************************************");
			System.out.println("1: Crear Alumnos");
			System.out.println("2: Crear Asignaturas");
			System.out.println("3: Matricular");
			System.out.println("4: Imprimir Alumno");
			System.out.println("5: Imprimir Alumnos");
			System.out.println("6: Imprimir Asignatura");
			System.out.println("7: Agregar Calificación");
			System.out.println("8: Comparar Alumnos");
			System.out.println("9: Muestra Asignaturas");
			System.out.println("***************************************************************************************************");
			System.out.println("Introduzca por teclado la opción deseada:");
			String menu = sc.nextLine();
			System.out.println("***************************************************************************************************");
			switch(menu) {
				case "1":
					System.out.println("**** Crea y añade un alumno al centro escolar ****");
					// Entrada manual
					do {
						Menu.menuCrearAlumno(sc,centroAcademico);
						System.out.println("Desea añadir más alumnos? SI - NO");
					} while(sc.nextLine().equalsIgnoreCase("si"));
					flagAlumnos = true;
					break;
				case "2":
					System.out.println("**** Crea y añade una asignatura al centro escolar ****");
					// Entrada manual
					do {
						Menu.menuCrearAsignatura(sc,centroAcademico);
						System.out.println("Desea añadir más asignaturas? SI - NO");
					} while(sc.nextLine().equalsIgnoreCase("si"));
					flagAsignaturas = true;
					break;
				case "3":
					if (flagAlumnos && flagAsignaturas) {
						System.out.println("**** Matricula a un alumno en una asigntura con un determinado código ****");
						// Entrada manual
						do {
							Menu.menuMatricular(sc, centroAcademico);
							System.out.println("Desea matricular más alumnos? SI - NO");
						} while(sc.nextLine().equalsIgnoreCase("si"));
						flagMatricular = true;
					}
					else {
						System.out.println("Para probar todas las funcionalidades del método matricular debe dar antes de alta alumnos y asignaturas -> Opciones 1 y 2 del menú");
					}
					break;
				case "4":
					System.out.println("**** Imprime en pantalla la información del alumno ****");
					// Entrada manual
					do {
						Menu.menuImprimirAlumno(sc, centroAcademico);
						System.out.println("Desea imprimir la información de más alumnos? SI - NO");
					} while(sc.nextLine().equalsIgnoreCase("si"));
					break;
				case "5":
					System.out.println("**** Imprime todos los alumnos registrados en el centro ****");
					centroAcademico.imprimirAlumnos();
					break;
				case "6":
					System.out.println("**** Imprime los alumnos de una asignatura y el número total de ellos ****");
					// Entrada manual
					do {
						Menu.menuImprimirAsignatura(sc, centroAcademico);
						System.out.println("Desea imprimir la información de más asignaturas? SI - NO");
					} while(sc.nextLine().equalsIgnoreCase("si"));
					break;
				case "7":
					if (flagMatricular) {
						System.out.println("**** Asigna una nota al alumno correspondiente en la asignatura del codigo ****");
						// Entrada manual
						do {
							Menu.menuAgregarCalificacion(sc, centroAcademico);
							sc.nextLine();
							System.out.println("Desea asignar más calificaciones? SI - NO");
						} while(sc.nextLine().equalsIgnoreCase("si"));
					}
					else {
						System.out.println("Para probar todas las funcionalidades del método agregarCalificacion debe dar antes matricular alumnos en asignaturas -> Opción 3 del menú");
					}
					break;
				case "8":
					System.out.println("**** Indica que alumno tiene mejor nota media ****");
					// Entrada manual
					do {
						Menu.menuCompararAlumnos(sc, centroAcademico);
						System.out.println("Desea comparar más alumnos? SI - NO");
					} while(sc.nextLine().equalsIgnoreCase("si"));
					break;
				case "9":
					System.out.println("**** Muestra las asignaturas ordenadas alfabéticamente ****");
					centroAcademico.imprimirAsignaturas();
					break;
				default:
					System.out.println("ERROR: La opción elegida no se encuentra disponible en las funcionalidades del programa!");
			}			
			System.out.println("***************************************************************************************************");
			System.out.println("Desea salir de Menú? Escriba SI - NO");
			System.out.println("***************************************************************************************************");
		}while(!sc.nextLine().equalsIgnoreCase("SI"));
		sc.close();
		System.out.println("****************************************** FIN DEL MENÚ *******************************************");
		System.out.println("***************************************************************************************************");

	}

}

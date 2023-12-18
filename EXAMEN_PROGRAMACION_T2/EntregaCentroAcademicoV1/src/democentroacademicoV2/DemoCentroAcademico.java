package democentroacademicoV2;

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
					System.out.println("Probamos a añadir nuevos alumnos: ");
					System.out.println(centroAcademico.crearAlumno("DAW_MP-0001", "Sebastián Cabanas Vázquez"));
					System.out.println(centroAcademico.crearAlumno("DAW_MP-0002", "Miguel Álvarez Díaz"));
					System.out.println(centroAcademico.crearAlumno("DAW_MP-0003", "Pablo Abeijón Filgueira"));
					System.out.println("Probamos a añadir un nuevo alumno con el mísmo código que uno ya existente: ");
					System.out.println(centroAcademico.crearAlumno("DAW_MP-0001", "David Calvo Romero"));
					flagAlumnos = true;
					break;
				case "2":
					System.out.println("**** Crea y añade una asignatura al centro escolar ****");
					System.out.println("Probamos añadir asignaturas: ");
					System.out.println(centroAcademico.crearAsignatura("DAW_PRO","Programación","9"));
					System.out.println(centroAcademico.crearAsignatura("DAW_LMSXI","Linguaxes de Marcas e Sistemas de Xestión da Información","5"));
					System.out.println(centroAcademico.crearAsignatura("DAW_BBDD","Bases de Datos","7"));
					System.out.println(centroAcademico.crearAsignatura("DAW_FOL","Formación e Orientación Laboral","4"));
					System.out.println(centroAcademico.crearAsignatura("DAW_SI","Sistemas Informáticos","9"));
					System.out.println(centroAcademico.crearAsignatura("DAW_CD","Contornos de desenvolvemento","5"));
					System.out.println("Probamos a añadir una nueva asignatura con el mísmo código que una ya existente: ");
					System.out.println(centroAcademico.crearAsignatura("DAW_PRO","ProgramaciónII","9"));
					flagAsignaturas = true;
					break;
				case "3":
					if (flagAlumnos && flagAsignaturas) {
						System.out.println("**** Matricula a un alumno en una asigntura con un determinado código ****");
						System.out.println("Probamos a matricular a un alumno de una asignatura: ");
						System.out.println(centroAcademico.matricular("DAW_MP-0001", "DAW_PRO"));
						System.out.println(centroAcademico.matricular("DAW_MP-0001", "DAW_LMSXI"));
						System.out.println(centroAcademico.matricular("DAW_MP-0001", "DAW_SI"));
						System.out.println(centroAcademico.matricular("DAW_MP-0002", "DAW_PRO"));
						System.out.println(centroAcademico.matricular("DAW_MP-0002", "DAW_BBDD"));
						System.out.println(centroAcademico.matricular("DAW_MP-0002", "DAW_FOL"));
						System.out.println(centroAcademico.matricular("DAW_MP-0003", "DAW_PRO"));
						System.out.println("Probamos a matricular a un alumno de una asignatura en la que ya está matriculado: ");
						System.out.println(centroAcademico.matricular("DAW_MP-0001", "DAW_PRO"));
						System.out.println("Probamos a matricular a un alumno con un código erroneo: ");
						System.out.println(centroAcademico.matricular("DAW_MP-0020", "DAW_PRO"));
						System.out.println("Probamos a matricular a un alumno de una asingatura que no existe: ");
						System.out.println(centroAcademico.matricular("DAW_MP-0002", "DAW_PRO_II"));
						flagMatricular = true;
					}
					else {
						System.out.println("Para probar todas las funcionalidades del método matricular debe dar antes de alta alumnos y asignaturas -> Opciones 1 y 2 del menú");
					}
					break;
				case "4":
					System.out.println("**** Imprime en pantalla la información del alumno ****");
					centroAcademico.imprimirAlumno("DAW_MP-0001");
					break;
				case "5":
					System.out.println("**** Imprime todos los alumnos registrados en el centro ****");
					centroAcademico.imprimirAlumnos();
					break;
				case "6":
					System.out.println("**** Imprime los alumnos de una asignatura y el número total de ellos ****");
					centroAcademico.imprimirAsignatura("DAW_PRO");
					break;
				case "7":
					if (flagMatricular) {
						System.out.println("**** Asigna una nota al alumno correspondiente en la asignatura del codigo ****");
						System.out.println("Probamos a asignar la nota a un alumno de una asignatura: ");
						centroAcademico.agregarCalificacion("DAW_MP-0001", "DAW_PRO", 10);
						centroAcademico.agregarCalificacion("DAW_MP-0001", "DAW_LMSXI", 8);
						centroAcademico.agregarCalificacion("DAW_MP-0001", "DAW_SI", 9);
						centroAcademico.agregarCalificacion("DAW_MP-0002", "DAW_PRO", 7);
						centroAcademico.agregarCalificacion("DAW_MP-0002", "DAW_BBDD", 10);
						centroAcademico.agregarCalificacion("DAW_MP-0002", "DAW_FOL", 5);
						centroAcademico.agregarCalificacion("DAW_MP-0003", "DAW_PRO", 6);
						System.out.println("Probamos a asignar la nota a un alumno de una asignatura que no está matriculado: ");
						System.out.println(centroAcademico.agregarCalificacion("DAW_MP-0002", "DAW_LMSXI", 9));
						System.out.println("Probamos a asingnar la nota a un alumno con un código erroneo: ");
						System.out.println(centroAcademico.agregarCalificacion("DAW_MP-0020", "DAW_LMSXI", 9));
						System.out.println("Probamos a asingnar la nota a un alumno de una asignatura que no existe: ");
						System.out.println(centroAcademico.agregarCalificacion("DAW_MP-0001", "DAW_PRO_II", 9));
					}
					else {
						System.out.println("Para probar todas las funcionalidades del método agregarCalificacion debe dar antes matricular alumnos en asignaturas -> Opción 3 del menú");
					}
					break;
				case "8":
					System.out.println("**** Indica que alumno tiene mejor nota media ****");
					centroAcademico.compararAlumno("DAW_MP-0001", "DAW_MP-0002");
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

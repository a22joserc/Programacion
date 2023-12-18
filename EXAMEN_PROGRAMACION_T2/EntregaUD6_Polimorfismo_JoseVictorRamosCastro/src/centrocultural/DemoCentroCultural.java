package centrocultural;

import java.util.Scanner;

public class DemoCentroCultural {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CentroCultural centroCultural = new CentroCultural();		
		do {
			System.out.println("***************************************************************************************************");
			System.out.println("                                                MENÚ                                               ");
			System.out.println("***************************************************************************************************");
			System.out.println("PRESTAMO: Realizar préstamos \nCONSULTA: Consulta préstamos clientes\nCOMPARA: Comparar si dos libros son iguales");
			System.out.println("***************************************************************************************************");
			System.out.println("Introduzca por teclado la opción deseada:");
			String menu = sc.nextLine();
			System.out.println("***************************************************************************************************");
			switch(menu) {
				case "PRESTAMO":
					System.out.println("REALIZAMOS PRÉSTAMOS CLIENTE POR DNI");
					menuPrestamo(centroCultural, sc);
					break;
				case "CONSULTA":
					System.out.println("CONSULTAMOS PRÉSTAMOS CLIENTE POR DNI");
					do {
						centroCultural.monstrarInfoClientes();
						System.out.println("Introduzca el DNI del cliente: ");
						centroCultural.mostrarPrestamoCliente(sc.nextLine());
						System.out.println("Desea consultar más cliente? ? SI - NO");
					} while(sc.nextLine().equalsIgnoreCase("SI") == true);
					break;
				case "COMPARA":
					System.out.println("COMPARAMOS SI DOS LIBROS SON IGUALES (TÍTULO Y NÚM. PÁGINAS)");
					Libro libro1 = (Libro) centroCultural.getCatalogoMateriales()[0];
					Libro libro2 = (Libro) centroCultural.getCatalogoMateriales()[0];
					Libro libro3 = (Libro) centroCultural.getCatalogoMateriales()[1];
					System.out.println("El Libro con título \"" + libro1.getTitulo() + "\" y Núm Pág (" + libro1.getNumPag() + ") es igual al libro con título \"" + libro2.getTitulo() + "\" y Núm Pág (" + libro2.getNumPag() + ") ? "  + libro1.equals(libro2));
					System.out.println("El Libro con título \"" + libro1.getTitulo() + "\" y Núm Pág (" + libro1.getNumPag() + ") es igual al libro con título \"" + libro3.getTitulo() + "\" y Núm Pág (" + libro3.getNumPag() + ") ? "  + libro1.equals(libro3));
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
	
	public static void menuPrestamo(CentroCultural centroCultural, Scanner sc) {
		do {
			centroCultural.monstrarInfoClientes();
			Cliente cliente;
			do {
				System.out.println("Introduzca el DNI del cliente: ");
				cliente = centroCultural.getClienteDni(sc.nextLine());
			} while(cliente == null);
			if ((cliente.getNumDiscoPrestamo() + cliente.getNumLibroPrestamo()) == cliente.getPrestamos().length) {
				System.out.println("El cliente ya ha alcanzado el límite de 6 prestamos!");
			}
			else {
				System.out.println(cliente.toString());
				int numPrestamos;
				do {
					System.out.println("Introduzca cuantas peticiones de préstamo quiere realizar MIN = 0, MAX = : " + (cliente.getPrestamos().length - (cliente.getNumDiscoPrestamo() + cliente.getNumLibroPrestamo())));
					numPrestamos = Integer.parseInt(sc.nextLine());
					if (numPrestamos < 0 || numPrestamos > cliente.getPrestamos().length - (cliente.getNumDiscoPrestamo() + cliente.getNumLibroPrestamo())) {
						System.out.println("Error el número de préstamos permitdo para el cliente está entre 0 y " + (cliente.getPrestamos().length - (cliente.getNumDiscoPrestamo() + cliente.getNumLibroPrestamo())));
					}
				}while(numPrestamos < 0 || numPrestamos > cliente.getPrestamos().length - (cliente.getNumDiscoPrestamo() + cliente.getNumLibroPrestamo()));
				
				int posIni = cliente.getNumDiscoPrestamo() + cliente.getNumLibroPrestamo();		
				for (int i=posIni; i < posIni+numPrestamos; i++) {
					System.out.println("Préstamo " + (i+1) + " de " + cliente.getPrestamos().length + " . CLIENTE - DNI: " + cliente.toString());
					centroCultural.mostrarInfoMateriales();
					Material material;
					Boolean flag;
					do {
						System.out.println("Introduzca el ID del artículo buscado: ");
						material = centroCultural.getMaterialId(sc.nextLine());
						flag = false;
						if (material == null) {
							flag = true;
						}
						else if (material.getPrestado()) {
							System.out.println("ERROR: El artículo solicitado se encuentra actualmente prestado. Por favor, seleccione otro!");
							flag = true;
						}
						else if (material instanceof Libro && cliente.getNumLibroPrestamo() == CentroCultural.NUM_MAX_PRESTAMOS_LIBRO_CLIENTE) {
							System.out.println("ERROR: Un cliente no puede realizar préstamos de más de tres libros!");
							flag = true;
					
						}
						else if (material instanceof Disco && cliente.getNumDiscoPrestamo() == CentroCultural.NUM_MAX_PRESTAMOS_DISCO_CLIENTE) {
							System.out.println("ERROR: Un cliente no puede realizar préstamos de más de tres discos!");
							flag = true;
						}
					} while(flag);
					cliente.anadirPrestamo(new Prestamo(material), i);
				}
			}
			cliente.mostrarInfoPrestamo();
			System.out.println("Desea realizar solicitudes de préstamo para otros clientes? SI - NO");
		}while(sc.nextLine().equalsIgnoreCase("SI") == true);
	}
	
}

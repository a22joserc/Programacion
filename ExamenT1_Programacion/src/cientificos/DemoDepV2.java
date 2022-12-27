package cientificos;

import java.math.BigDecimal;
import java.util.Scanner;

public class DemoDepV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String salirMenu;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("************************************************************************");
			System.out.println("                                 MENÚ                                   ");
			System.out.println("************************************************************************");
			System.out.println("INFO: Info Departamento \nTECLADO: Crear por Teclado Cientifico\nTECLADO-METODO2: Método clase Científico");
			System.out.println("************************************************************************");
			System.out.println("Introduzca por teclado la opción deseada:");
			String menu = sc.nextLine();
			System.out.println("************************************************************************");
			switch(menu) {
				case "INFO":
					Investigacion inv1 = new Investigacion("0012-EOL","Energía del Oleaje",new BigDecimal("10"));
					// Creamos Científicos;
					Cientifico cientifico1 = new Cientifico("Maria","Lopez",tipoExperiencia.Alta,15,inv1);
					System.out.println(cientifico1.toString());
					Cientifico cientifico2 = new Cientifico("Pedro","Gomez",tipoExperiencia.Media,5,inv1);
					System.out.println(cientifico2.toString());
					Cientifico cientifico3 = new Cientifico("Luis","Ramos",tipoExperiencia.Baja,3,inv1);
					System.out.println(cientifico3.toString());
					Cientifico cientifico4 = new Cientifico("Jose","Crespo",tipoExperiencia.Baja,2,inv1);
					System.out.println(cientifico4.toString());
					// Almacenamos los científcos en un array
					// Cientifico[] cientDep1 = new Cientifico[] {cientifico1, cientifico2, cientifico3,cientifico4};
					// Creamos Departamento
					// Departamento dep1 = new Departamento("GICEMA",15,cientDep1);
					Departamento dep1 = new Departamento("GICEMA",15);
					dep1.crearPlantilla();
					dep1.agregarCientifico(cientifico1, 0);
					dep1.agregarCientifico(cientifico2, 1);
					dep1.agregarCientifico(cientifico3, 2);
					dep1.agregarCientifico(cientifico4, 3);
					dep1.setPresupuestoAnual();
					System.out.println();
					dep1.mostrarInfo();
					System.out.println("**** Probamos a eliminar científicos por nombre ****");
					dep1.eliminarCientifico("Maria");
					System.out.println("**** Mostramos la nueva información ****");
					dep1.setPresupuestoAnual();
					dep1.mostrarInfo();
					System.out.println("Número empleados activos: " + dep1.calcularNumEmpleadosActivos());
					System.out.println("Experiencia Total empleados activos: " + dep1.calcularExperienciaTotal());
					System.out.println("Antigüedad Total empleados activos : " + dep1.calcularAntiguedadTotal());
					break;
				case "TECLADO":
					Cientifico cientifico = darAltaCientificoV2(sc);
					cientifico.mostrarInfo();
					break;
				case "TECLADO-METODO2":
					Cientifico cientificoT = new Cientifico(new Investigacion());
					cientificoT.darAltaCientifico(sc);
					cientificoT.mostrarInfo();
					break;
				default:
					System.out.println("ERROR: La opción elegida no se encuentra disponible en las funcionalidades del programa!");
			}			
			System.out.println("************************************************************************");
			System.out.println("Desea salir de Menú? Escriba SI/si en caso afirmativo o teclee algo para permanecer en el menú!");
			System.out.println("************************************************************************");
			salirMenu = sc.nextLine();
		}while(!salirMenu.equalsIgnoreCase("SI"));
		sc.close();
		System.out.println("************************** FIN DEL MENÚ ********************************");
		System.out.println("************************************************************************");
	}
	
	public static Cientifico darAltaCientifico(Scanner sc, tipoExperiencia experiencia) {
		Investigacion investigacion = new Investigacion();
		Cientifico cientifico = new Cientifico();
		cientifico.setInvestigacion(investigacion);
		System.out.println("Defina el nombre del científico: ");
		cientifico.setNombre(sc.nextLine());
		System.out.println("Defina los apellidos del científico: ");
		cientifico.setApellidos(sc.nextLine());
		System.out.println("Defina los años de experiencia del científico: ");
		cientifico.setAnhos(Integer.parseInt(sc.nextLine()));
		System.out.println("Defina el nombre de la investigación del científico: ");
		cientifico.getInvestigacion().setNombre(sc.nextLine());
		System.out.println("Defina el ID de la investigación del científico: ");
		cientifico.getInvestigacion().setId(sc.nextLine());
		System.out.println("Defina el Número (Alta precisión) de la investigación del científico: ");
		cientifico.getInvestigacion().setNumInv(new BigDecimal(sc.nextLine()));
		cientifico.setExperiencia(experiencia);
		cientifico.darAltaCientifico(sc);
		return cientifico;
	}
	
	
	public static Cientifico darAltaCientificoV2(Scanner sc) {
		Investigacion investigacion = new Investigacion();
		Cientifico cientifico = new Cientifico();
		cientifico.setInvestigacion(investigacion);
		System.out.println("Defina el nombre del científico: ");
		cientifico.setNombre(sc.nextLine());
		System.out.println("Defina los apellidos del científico: ");
		cientifico.setApellidos(sc.nextLine());
		System.out.println("Defina los años de experiencia del científico: ");
		cientifico.setAnhos(Integer.parseInt(sc.nextLine()));
		System.out.println("Defina el nombre de la investigación del científico: ");
		cientifico.getInvestigacion().setNombre(sc.nextLine());
		System.out.println("Defina el ID de la investigación del científico: ");
		cientifico.getInvestigacion().setId(sc.nextLine());
		System.out.println("Defina el Número (Alta precisión) de la investigación del científico: ");
		cientifico.getInvestigacion().setNumInv(new BigDecimal(sc.nextLine()));
		boolean flag = false;
		do {
			System.out.println("Introduzca la experiencia del científico: ALTA - MEDIA - BAJA");
			String experiencia = sc.nextLine();
			if (experiencia.equalsIgnoreCase("ALTA")) {
				cientifico.setExperiencia(tipoExperiencia.Alta);
				flag = true;
			}
			else if (experiencia.equalsIgnoreCase("MEDIA")) {
				cientifico.setExperiencia(tipoExperiencia.Media);
				flag = true;
			}
			else if (experiencia.equalsIgnoreCase("BAJA")) {
				cientifico.setExperiencia(tipoExperiencia.Baja);
				flag = true;
			}
			else {
				System.out.println("Error: El tipo de experiencia introducida no se admite en el sitema");
			}
		}while(flag==false);
		return cientifico;
	}

}

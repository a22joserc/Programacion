package ejercicio1Pruebas;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map;

public class Trabajador {
	
	// Variables de clase
	private Empresa empresa;
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private String lugarNac;
	
	// Constructor por defecto
	
	public Trabajador() {
		empresa = null;
		dni = "12345678X";
		nombre = "Nombre Empleado";
		apellidos = "Apellidos Empleado";
		edad = 0;
		lugarNac = "Lugar Nacimiento Empleado";
	}
	
	// Constructor con paso de parámetros
	
	public Trabajador(Empresa empresa, String dni, String nombre, String apellidos, int edad, String lugarNac) {
		this.empresa = empresa;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.lugarNac = lugarNac;
	}
	
	public Trabajador(Map<String,String> map) {
		this.empresa = new Empresa(map.get("cif"),map.get("nomEmp"),map.get("dirEmp"),Integer.parseInt(map.get("numEmp")));
		this.dni = map.get("dni");
		this.nombre = map.get("nombre");
		this.apellidos = map.get("apellidos");
		this.edad = Integer.parseInt(map.get("edad"));
		this.lugarNac = map.get("lugar");
	}
	
	// SETTERS
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}
	
	// GETTERS
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getLugarNac() {
		return lugarNac;
	}
	
	// SET FROM STRING USANADO SCANNER
	public void setFromStringSC(String cadena) {
		Scanner scC = new Scanner(cadena);
		scC.useDelimiter("\\|");
		String cadena1 = scC.next();
		Scanner sc1 = new Scanner(cadena1);
		sc1.useDelimiter(":");
		String dni = sc1.next();
		String nombre = sc1.next();
		String apellidos = sc1.next();
		int edad = sc1.nextInt();
		String lugarNac = sc1.next();
		String cadena2 = scC.next();
		Scanner sc2 = new Scanner(cadena2);
		sc2.useDelimiter(":");
		String cif = sc2.next();
		String nomEmpresa = sc2.next();
		String direccion = sc2.next();
		int empleados = scC.nextInt();
		sc1.close();
		sc2.close();
		scC.close();
		this.empresa.setCif(cif);
		this.empresa.setDireccion(direccion);
		this.empresa.setNombre(nomEmpresa);
		this.empresa.setNumEmpleados(empleados);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.lugarNac = lugarNac;
	}
	
	// SET FROM STRING USANADO StringTokenizer
	public void setFromStringST(String cadena) {
		StringTokenizer st = new StringTokenizer(cadena,"|"); 
		String cadena1 = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(cadena1,":"); 
		String dni = st1.nextToken();
		String nombre = st1.nextToken();
		String apellidos = st1.nextToken();
		int edad = Integer.parseInt(st1.nextToken());
		String lugarNac = st1.nextToken();
		String cadena2 = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(cadena2,":"); 
		String cif = st2.nextToken();
		String nomEmpresa = st2.nextToken();
		String direccion = st2.nextToken();	
		String cadena3 = st.nextToken();
		int empleados = Integer.parseInt(cadena3);
		this.empresa.setCif(cif);
		this.empresa.setDireccion(direccion);
		this.empresa.setNombre(nomEmpresa);
		this.empresa.setNumEmpleados(empleados);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.lugarNac = lugarNac;
	}
	
	@Override
	public String toString() {
		return "***************************\nNombre : " + this.getNombre() + ";\nApellidos: " + this.getApellidos() + ";\nEdad: " + this.getEdad() + ";\nDNI: " + this.getDni() + ";\nEmpresa: " + this.empresa.getNombre() +"\n***************************";
	}
}

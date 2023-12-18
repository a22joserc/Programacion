package ejercicio.ciencia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// DNI c_jefe
		Dni dni_cjefe = new Dni();
		dni_cjefe.dni_num = 78945632;
		dni_cjefe.dni_letra = 'H';
		// Cientifico Jefe
		Cientifico c_jefe = new Cientifico();
		c_jefe.nombre = "Jose Victor";
		c_jefe.apellidos = "Ramos Castro";
		c_jefe.es_jefe = true;
		c_jefe.salario = 45000;
		// Cientifico raso DNI
		Dni dni_c1 = new Dni();
		dni_c1.dni_num = 2345896;
		dni_c1.dni_letra = 'k';
		// Cientifico C1
		Cientifico c1 = new Cientifico();
		c1.nombre = "Miguel";
		c1.apellidos = "Álvarez Díaz";
		c1.jefe = c_jefe;
		c1.es_jefe = false;
		c1.salario = 30000;


	}

}

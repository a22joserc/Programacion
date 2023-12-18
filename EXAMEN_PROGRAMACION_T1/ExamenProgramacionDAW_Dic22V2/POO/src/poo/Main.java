package poo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Coche coche1 = new Coche();
		// coche1.pasajeros=5;
		// System.out.println("El coche tiene una capacidad de " + coche1.pasajeros + " pasajeros");
		/*Coche peugeot308 = new Coche();
		peugeot308.pasajeros=5;
		peugeot308.deposito=60;
		peugeot308.kpl=20;
		// peugeot308.autonomia=peugeot308.kpl*peugeot308.deposito;
		peugeot308.set_autonomia();
		System.out.println("Autonomia: " + peugeot308.autonomia);
		peugeot308.arranca();*/
		/*Persona p1 = new Persona("yo",45);
		//p1.nombre="yo";
		//p1.edad=45;
		Persona p2 = new Persona("tu",37);
		//p2.nombre="tu";
		//p2.edad=37;
		System.out.println("La edad combinada de las personas es " + (p1.edad+p2.edad));*/
		//Persona p1 = new Persona("Juanita", "Perez", 37);
		//System.out.println(p1.nombre_completo);
		/*Raton raton = new Raton();
		raton.botones = 2;
		raton.serial = 12345056;
		Teclado teclado = new Teclado();
		teclado.color = "Negro";
		teclado.tipo = Teclados.Español;
		teclado.id = 123546;
		Pc pc = new Pc();
		pc.kw = 250;
		pc.puertos = 4;
		pc.serial = 1234650;
		pc.raton = raton;
		pc.teclado = teclado;
		System.out.println(pc.teclado.tipo);	
		System.out.println(pc);*/
		// Instanciamos la clase DNI
		Dni dni_p1 = new Dni();
		dni_p1.letra_dni = 'H';
		dni_p1.num_dni = 12345678;
		// Instanciamos la clase persona
		Persona p1 = new Persona();
		p1.dni = dni_p1;
		p1.edad = 27;
		p1.apellidos = "Ramos Castro";
		p1.nombre = "José Víctor";
		System.out.println("El DNI de " + p1.nombre + " " + p1.apellidos + " es: " + p1.dni.num_dni + "-" + p1.dni.letra_dni);
		// Instanciamos la clase ruedas. Creamos 4 ruedas
		// Rueda Delatera Derecha
		Rueda ruedaDD = new Rueda();
		ruedaDD.ano_compra=2019;
		ruedaDD.posicion= tipo_ruedas.DD;
		System.out.println(ruedaDD);
		// Rueda Delatera Izquierda
		Rueda ruedaDI = new Rueda();
		ruedaDI.ano_compra=2015;
		ruedaDI.posicion= tipo_ruedas.DI;
		// Rueda Trasera Derecha
		Rueda ruedaTD = new Rueda();
		ruedaTD.ano_compra=2018;
		ruedaTD.posicion= tipo_ruedas.TD;
		// Rueda Trasera Izquierda
		Rueda ruedaTI = new Rueda();
		ruedaTI.ano_compra=2020;
		ruedaTI.posicion= tipo_ruedas.TI;
		// Creamos un objeto de la clase coche y le asignamos las ruedas creadas
		Coche2 coche = new Coche2();
		coche.matricula="0100-BDB";
		coche.rueda_DD=ruedaDD;
		coche.rueda_DI=ruedaDI;
		coche.rueda_TD=ruedaTD;
		coche.rueda_TI=ruedaTI;
		// Asignamos Coche a persnoa
		p1.coche=coche;
		System.out.println("La persona " + p1.nombre + " " + p1.apellidos + " tiene un coche con matricua: " + p1.coche.matricula);
		System.out.println("El coche " + p1.nombre + " " + p1.apellidos + " tiene una rueda " + tipo_ruedas.DD + " del año: " + p1.coche.rueda_DD.ano_compra);
		System.out.println("El coche " + p1.nombre + " " + p1.apellidos + " tiene una rueda " + tipo_ruedas.DI + " del año: " + p1.coche.rueda_DI.ano_compra);
		System.out.println("El coche " + p1.nombre + " " + p1.apellidos + " tiene una rueda " + tipo_ruedas.TD + " del año: " + p1.coche.rueda_TD.ano_compra);
		System.out.println("El coche " + p1.nombre + " " + p1.apellidos + " tiene una rueda " + tipo_ruedas.TD + " del año: " + p1.coche.rueda_TI.ano_compra);
		
		
	}

}

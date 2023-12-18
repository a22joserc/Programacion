package unidad_this;

public class MainCirculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Circulo c1 = new Circulo(0,0,2);
		// Circulo c2 = new Circulo(2,2,4);
		Circulo c3 = new Circulo(4,2,5);
		System.out.println(c3);
		/*Circulo cMayor = c1.getMayorRadio(c2);
		System.out.println("Circulo mayor: Coordena X = " + cMayor.getCoordX() + " m, Coordena Y = " + cMayor.getCoordY() + " m, Radio: " + cMayor.getRadio() + " m");
		System.out.println("Circulo mayor: Coordena X = " + c1.getMayorRadio(c3).getCoordX() + " m, Coordena Y = " + c1.getMayorRadio(c3).getCoordY() + " m, Radio: " + c1.getMayorRadio(c3).getRadio() + " m");
		Circulo cicruloMayor= c1.getMayorRadio(c2);
		System.out.println(cicruloMayor.getCoordX());*/
		/*System.out.println(c3);
		Circulo circuloCopia1 = c3.getMayorRadioV2(c2);
		circuloCopia1.imprimirEstado();
		Circulo circuloCopia2 = c3.getMayorRadioV3(c2);
		circuloCopia2.imprimirEstado();*/
		Circulo circulo = new Circulo();
		System.out.println(circulo);
		circulo = c3;
		System.out.println(circulo);
	}

}

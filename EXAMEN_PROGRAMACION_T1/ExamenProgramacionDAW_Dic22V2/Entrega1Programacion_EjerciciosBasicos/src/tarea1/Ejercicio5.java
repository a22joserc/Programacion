package tarea1;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double peso=71.5;
		double altura=1.67;
		double IMC=peso/Math.pow(altura, 2);
		System.out.println("******************** ENTRADA *******************");
		System.out.println("Peso: " + peso);
		System.out.println("Altura: " + altura);
		System.out.println("**************** CÁLCULO IMC *******************");
		System.out.println("IMC: " + IMC);
		System.out.printf("IMC con dos cifras significativas: %.2f%n", IMC);
		System.out.println("****************** TABLA IMC ********************");
		System.out.println("Delgado: <18.5 ");
		System.out.println("Normal: entre 18.5 y 24.9 ");
		System.out.println("Sobrepeso: entre 25 y 29.9 ");
		System.out.println("Obeso: 30 o más");
		System.out.println("****************** RESULTADO ********************");
		if (IMC<18.5) {
			System.out.println("Delgado");
		}
		else if(IMC>=18.5 && IMC<=24) {
			System.out.println("Normal");
		}
		else if(IMC>25 && IMC<=29.9) {
			System.out.println("Sobrepeso");
		}
		else if (IMC>30){
			System.out.println("Obeso");
		}
		else {
			System.out.println("El valor obtenido de IMC no se corresponde con ningún rango. Por favor revise los datos introducidos!");
		}
		System.out.println("*************************************************");
	}

}

package sobrecarga.metodos;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sobrecarga ob = new Sobrecarga();
		ob.metodoSobreCargado();
		System.out.println(ob);
		ob.metodoSobreCargado(5);
		System.out.println(ob);
		ob.metodoSobreCargado(5, 10);
		System.out.println(ob);
		ob.metodoSobreCargado(6.7, 16);
		System.out.println(ob);
	}

}

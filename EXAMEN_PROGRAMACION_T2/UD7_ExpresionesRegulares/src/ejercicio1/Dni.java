package ejercicio1;

public class Dni {
	
	private int num;
	private char letra;
	
	public Dni (int num, char letra) throws DniException {
		String str = String.valueOf(num).concat(String.valueOf(letra));
		if (!str.matches("[0-9]{8}[AZ]{1}")) {
			throw new DniException("DNI erroneo!");
		}
		else {
			this.num = num;
			this.letra = letra;
		}
	}
	
	public Dni (String strDni) throws DniException {
		if (!strDni.matches("[0-9]{8}[AZ]{1}")) {
			throw new DniException("DNI erroneo!");
		}
		else {
			this.num = Integer.parseInt(strDni.substring(0,strDni.length()-1));
			// this.letra = strDni.substring(strDni.length()-1).toCharArray()[0];
			this.letra = 'a';
		}
	}

}

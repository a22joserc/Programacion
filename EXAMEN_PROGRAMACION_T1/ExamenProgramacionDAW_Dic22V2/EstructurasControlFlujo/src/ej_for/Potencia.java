package ej_for;

public class Potencia {
	
	public int elevar(int base, int exp) {
		int pot=1;
		for (int i=0; i<exp; i++) {
			pot=pot*base;
		}
		return pot;
	}

}

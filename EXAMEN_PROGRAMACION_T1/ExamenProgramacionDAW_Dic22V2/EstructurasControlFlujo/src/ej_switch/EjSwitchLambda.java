package ej_switch;

public class EjSwitchLambda {
	
	dias dia = dias.MONDAY;
	
	int numLetters = switch(dia) {
		case MONDAY, FRIDAY, SUNDAY -> 6;
		case TUESDAY -> 7;
		case THURSDAY, SATURDAY -> 8;
		case WEDNESDAY -> 9;
		default -> 0;
	};

}

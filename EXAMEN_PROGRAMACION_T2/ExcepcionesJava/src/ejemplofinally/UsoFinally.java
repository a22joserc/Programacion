package ejemplofinally;

public class UsoFinally {
	
	public static void generarExcepcion(int paraSwitch){
        int t=10;
        System.out.println("Recibiendo " + paraSwitch);
        try{
        switch(paraSwitch){
            case 0:
            t=10/paraSwitch;//forzamos division por zero
            break;
            case 1:
            t=Integer.parseInt("10.5");//provocamos error de formato
            break;
            case 2:
            return;
    }
    }catch(ArithmeticException exc){
        System.out.println("no se puede dividir por cero ¡animal!");
        return;
    }catch(NumberFormatException miExcepcion){
        System.out.println("imposible convertir en entero ese string");
    }finally{
        System.out.println("dejando try");
        System.out.println();
    }
    }

}

package ejercicio5;
import java.util.concurrent.TimeUnit;

public class Ejercicio5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int hor=0; hor<24; hor++) {
			for (int min=0; min<60; min++) {
				for (int seg=0; seg<60; seg++) {
					System.out.printf("%02d:%02d:%02d\n",hor,min,seg);
					TimeUnit.SECONDS.sleep(1);
				}
			}
		}

	}

}

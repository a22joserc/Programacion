package constructores;

public class A {
	private int x;
	
	A(){
		x=2;
	}
	
	A(int x){
		this.x=x;
	}
	
	public int getX() {
		return x;
	}
	
	int sumar_b(B unObjetoB){
		return x+unObjetoB.getY();
	 }
}

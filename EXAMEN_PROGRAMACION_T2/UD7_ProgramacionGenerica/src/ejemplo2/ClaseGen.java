package ejemplo2;

public class ClaseGen<T> {
	private T miVal;
	
	public ClaseGen(T miVal) {
		this.miVal = miVal;
	}
	
	public T getMiVal() {
		return this.miVal;
	}
	
	@Override
	public String toString() {
		return "ClaseGen<" + this.miVal.getClass().getName() + ">: miVal = " + this.miVal;
	}

}

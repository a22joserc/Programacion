package ejemplosClaseRecord;

public class EjemploClaseRecord {
	
	public record Person (String name, String address) {
		public static String UNKNOWN_ADDRESS = "Unknown";
		
		public static Person unknwon(String address) {
			return new Person("unkwon", address);
		}
	}
	
	public static void main(String[] args) {
		
		Person persona1 = new Person("Pepito", "Marrozos");
		Person persona2 = new Person("Pepito", "Marrozos");
		
		System.out.println(persona1.name);
		System.out.println(persona1.equals(persona2));
		System.out.println("********************************");
		System.out.println(persona1.hashCode());
		System.out.println(persona2.hashCode());
		System.out.println("********************************");
		System.out.println(persona1.toString());
		System.out.println(persona2.toString());
		System.out.println("********************************");
		System.out.println(Person.UNKNOWN_ADDRESS);
		System.out.println("********************************");
		Person.UNKNOWN_ADDRESS = "Bertamirans";
		System.out.println(Person.UNKNOWN_ADDRESS);
		System.out.println("********************************");
		Person persona3 = Person.unknwon("Ames");
		System.out.println(persona3);
		
		
	}

}

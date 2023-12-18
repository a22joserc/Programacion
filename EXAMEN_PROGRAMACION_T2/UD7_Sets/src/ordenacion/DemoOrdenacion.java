package ordenacion;

import java.util.TreeSet;

public class DemoOrdenacion {
	public static void main(String[] args) {
		
		// CompareTo
		TreeSet<User> users = new TreeSet<>();
		User poole = new User(55, "Poole");
		poole.regSystemLogin();
		User david = new User(28, "David");
		david.regSystemLogin();
		User jose = new User(12, "Jose");
		jose.regSystemLogin();
		users.add(poole);
		users.add(david);
		users.add(jose);
		System.out.println(users);
		
		// UserComparator
		
		TreeSet<User> users2 = new TreeSet<>(new UserComparator());

		users2.add(poole);
		users2.add(david);
		users2.add(jose);
		System.out.println(users2);
		
	}
}

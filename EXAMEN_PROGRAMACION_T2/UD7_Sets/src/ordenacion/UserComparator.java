package ordenacion;

import java.time.LocalDateTime;
import java.util.Comparator;

public class UserComparator implements Comparator<User> {
	 @Override
	 public int compare(User u1, User u2) {
	    return u1.getlLastLogin().compareTo(u2.getlLastLogin());
	 }

}
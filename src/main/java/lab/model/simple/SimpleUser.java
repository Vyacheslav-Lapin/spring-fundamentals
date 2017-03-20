package lab.model.simple;

import lab.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleUser extends SimplePerson implements User {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
}

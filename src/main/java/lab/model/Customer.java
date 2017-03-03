package lab.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Customer implements Person {
    private String name;
    private boolean broke;

    public void sayHello(Person person) {
    }
}

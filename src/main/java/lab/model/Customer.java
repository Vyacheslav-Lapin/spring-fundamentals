package lab.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@Component
public class Customer implements Person {
    private String name;
    private boolean broke;

    public void sayHello(Person person) {
    }
}

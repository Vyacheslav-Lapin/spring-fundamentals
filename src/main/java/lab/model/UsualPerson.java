package lab.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Value
@AllArgsConstructor
public class UsualPerson implements Person {

    private int id;

    private String name;

    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
    }
}

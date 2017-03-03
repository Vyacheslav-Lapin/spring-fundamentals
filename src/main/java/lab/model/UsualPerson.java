package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsualPerson implements Person {

    private int id;
    private String name;
    private int age;
    private float height;
    private boolean isProgrammer;

    @Autowired
    private Country country;

    @Autowired
    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
    }
}
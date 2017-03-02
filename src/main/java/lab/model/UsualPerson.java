package lab.model;

import lombok.Value;

import java.util.List;

@Value
public class UsualPerson implements Person {

    private int id;
    private String name;
    private int age;
    private float height;
    private boolean isProgrammer;
    private Country country;
    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
    }
}
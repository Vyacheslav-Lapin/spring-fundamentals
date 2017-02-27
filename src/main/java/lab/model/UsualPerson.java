package lab.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.lang.reflect.*;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

@Entity
@Value
@AllArgsConstructor
public class UsualPerson implements Person {

    public static void main(String[] args) {
        System.out.println("Параметры - ");
        Parameter[] parameters = UsualPerson.class.getConstructors()[0].getParameters();
        for (Parameter parameter: parameters) {
            System.out.println(parameter.getName());
        }
    }

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
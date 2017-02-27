package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class UsualPerson implements Person {
    @Id
    @Column
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;

    public UsualPerson() {
        this("", null, 0);
    }

    public UsualPerson(String name, Country country, int age) {
        this(0, name, country, age, 0, false, Collections.emptyList());
    }

    @Override
    public void sayHello(Person person) {
    }
}
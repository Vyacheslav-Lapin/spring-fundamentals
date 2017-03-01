package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @Override
    public void sayHello(Person person) {
    }
}
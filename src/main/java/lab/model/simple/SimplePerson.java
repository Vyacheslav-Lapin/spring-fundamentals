package lab.model.simple;

import lab.model.Country;
import lab.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class SimplePerson implements Person {

    @Id
    @Column
    private int id;

    @Column
    @Value("John Smith")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    @Autowired
    private Country country;

    @Value("35")
    private int age;

    @Value("1.78")
    private float height;

    @Value("true")
    private boolean isProgrammer;

    @Value("false")
    private boolean broke;

    @Resource
    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
    }
}
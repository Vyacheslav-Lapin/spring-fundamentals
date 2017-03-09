package ioc.xml;

import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class SpringTCFAppTest {

    @Autowired
    private Person person;

    private Person expectedPerson = getExpectedPerson();

    @Test
    void testInitPerson() {
        assertEquals(expectedPerson, person);
    }

    private Person getExpectedPerson() {
        Country country = new Country(1, "Russia", "RU");
        List<String> contacts = Arrays.asList("asd@asd.ru", "+7-234-456-67-89");
        return new UsualPerson(
                0,
                "John Smith",
                country,
                35,
                1.78f,
                true,
                contacts
        );
    }
}

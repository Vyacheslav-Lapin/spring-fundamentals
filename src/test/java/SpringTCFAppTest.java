import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

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
        return new UsualPerson(
                0,
                "John Smith",
                new Country(1, "Russia", "RU"),
                35,
                1.78f,
                true,
                Arrays.asList("asd@asd.ru", "+7-234-456-67-89"));
    }

}

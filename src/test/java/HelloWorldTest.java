import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    public static final String APPLICATION_CONTEXT_XML = "application-context.xml";
    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "src/test/resources/" +
            APPLICATION_CONTEXT_XML;

    private UsualPerson expectedPerson;

    private AbstractApplicationContext context;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        Person person = context.getBean("person", Person.class);
        assertEquals(expectedPerson, person);
//        System.out.println(person);
    }

    private UsualPerson getExpectedPerson() {
        return new UsualPerson(
                0,
                "John Smith",
                new Country(1, "Russia", "RU"),
                35,
                0,
                false,
                Collections.emptyList());
    }

    @AfterEach
    void tearDown() throws Exception {
        if (context != null)
            context.close();
    }
}

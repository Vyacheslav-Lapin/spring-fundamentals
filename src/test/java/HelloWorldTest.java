import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "src/test/resources/application-context.xml";

    private UsualPerson expectedPerson;

    private AbstractApplicationContext context;

    @BeforeEach
    void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        Person person = context.getBean("person", Person.class);
        assertEquals(expectedPerson, person);
        System.out.println(person);
    }

    private UsualPerson getExpectedPerson() {
        return new UsualPerson(
                "John Smith",
                new Country(1, "Russia", "RU"),
                35);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (context != null)
            context.close();
    }
}

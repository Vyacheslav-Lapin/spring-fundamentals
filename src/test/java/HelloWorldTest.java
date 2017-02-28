import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML = "application-context.xml";
    private Person expectedPerson;
    private BeanFactory context;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        val person = context.getBean("person", Person.class);
        // ...
        assertEquals(expectedPerson, person);
    }

    private UsualPerson getExpectedPerson() {

        val country = new Country(
                1,
                "Russia",
                "RU");

        return new UsualPerson(
                0,
                "John Smith",
                country,
                35,
                0,
                false,
                Collections.emptyList());
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        if (context != null)
//            context.close();
//    }
}

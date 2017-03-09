package ioc.xml;

import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleSpringUsageTest {

	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";
	private BeanFactory context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
	private Person expectedPerson = getExpectedPerson();

	@Test
	void testInitPerson() {
		assertEquals(expectedPerson, context.getBean("person", Person.class));
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

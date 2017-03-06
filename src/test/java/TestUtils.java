import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;

import java.util.ArrayList;
import java.util.List;

interface TestUtils {

    static Person getExpectedPerson() {
        UsualPerson person = new UsualPerson();
        person.setAge(35);
        person.setHeight(1.78F);
        person.setProgrammer(true);
        person.setName("John Smith");

        Country country = Country.builder()
                .id(1)
                .name("Russia")
                .codeName("RU")
                .build();

        person.setCountry(country);

        List<String> contacts = new ArrayList<>();
        contacts.add("asd@asd.ru");
        contacts.add("+7-234-456-67-89");

        person.setContacts(contacts);

        return person;
    }
}

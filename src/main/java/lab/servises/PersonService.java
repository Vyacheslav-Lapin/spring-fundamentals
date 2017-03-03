package lab.servises;

import lab.model.Person;

@FunctionalInterface
public interface PersonService {
    Person getPerson(int id);
}

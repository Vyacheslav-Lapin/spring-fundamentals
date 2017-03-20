package lab.services;

import lab.model.Person;
import lab.model.User;

import java.util.List;

public interface PersonService {
    Person getPerson(int id);

    void saveUser(User user);

    List<Person> loadAllUsers();
}

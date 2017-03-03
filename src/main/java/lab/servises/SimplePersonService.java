package lab.servises;

import lab.dao.PersonDao;
import lab.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimplePersonService implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person getPerson(int id) {
        return personDao.getPerson(id);
    }
}

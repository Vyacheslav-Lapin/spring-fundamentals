package lab.services;

import lab.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimplePersonService implements PersonService {

    private PersonDao personDao;

    @Transactional(readOnly=true, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<User> loadAllUsers() {

        List<User> userList = personDao.selectAll();
        return userList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void saveUser(User user) {
        personDao.insert(user);
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    @Autowired
    @Required
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}

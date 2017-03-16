package lab.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class AbstractJpaDao {

	@PersistenceUnit
	EntityManagerFactory emf;
}
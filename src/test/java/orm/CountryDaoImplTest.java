package orm;

import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class CountryDaoImplTest {

//	private static Log log = LogFactory.getLog(orm.CountryDaoImplTest.class);

	private SimpleCountry exampleCountry = new SimpleCountry("Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@Test
	void testSaveCountry() {

		countryDao.save(exampleCountry);

		List<Country> countryList = countryDao.getAll();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	void testGtAllCountries() {

		countryDao.save(new SimpleCountry("Canada", "CA"));

		List<Country> countryList = countryDao.getAll();
		assertEquals(2, countryList.size());
	}

	@Test
	void testGetCountryByName() {
		exampleCountry.setId(1);
		Country country = countryDao.getByName("Australia");
		assertEquals(exampleCountry, country);
	}

}

import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class JdbcTest{

	@Autowired
	private CountryDao countryDao;
	
    private List<Country> expectedCountryList = new ArrayList<>();
    private List<Country> expectedCountryListStartsWithA = new ArrayList<>();
    private Country countryWithChangedName = new SimpleCountry(7, "Russia", "RU");

    @BeforeEach
    void setUp() throws Exception {
        initExpectedCountryLists();
        countryDao.loadCountries();
    }

    
    @Test
    @DirtiesContext
    void testCountryList() {
        List<Country> countryList = countryDao.getAll();
        assertNotNull(countryList);
        assertEquals(expectedCountryList.size(), countryList.size());
        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryListStartsWithA() {
        List<Country> countryList = countryDao.getStartsWith("A");
        assertNotNull(countryList);
        assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
        for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
            assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryChange() {
        countryDao.updateName("RU", "Russia");
        assertEquals(countryWithChangedName, countryDao.getCountryByCodeName("RU"));
    }

    private void initExpectedCountryLists() {
         for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
             String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i];
             Country country = new SimpleCountry(i, countryInitData[0], countryInitData[1]);
             expectedCountryList.add(country);
             if (country.getName().startsWith("A")) {
                 expectedCountryListStartsWithA.add(country);
             }
         }
     }
}
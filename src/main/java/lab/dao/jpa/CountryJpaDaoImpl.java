package lab.dao.jpa;

import javaslang.CheckedFunction0;
import javaslang.control.Try;
import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    @Override
    public void save(Country country) {
        CheckedFunction0.liftTry(emf::createEntityManager)
                .andThen(Try::get)
                .andThen(entityManager ->
                        CheckedFunction0.liftTry(entityManager::getTransaction)
                                .andThen(Try::get)
                                .andThen(entityTransaction -> {
                                    entityTransaction.begin();
                                    entityManager.persist(country);
                                    entityTransaction.commit();
                                    entityManager.close();
                                    return null;
                                }).get()
                ).get();
    }

    @Override
    public List<Country> getAllCountries() {
        return CheckedFunction0.liftTry(emf::createEntityManager)
                .andThen(Try::get)
                .andThen(entityManager -> {
                            List<Country> countryList = entityManager
                                    .createQuery("select c from Country c", Country.class)
                                    .getResultList();
                            entityManager.close();
                            return countryList;
                        }
                ).get();
    }

    @Override
    public List<Country> getCountryListStartWith(String name) {
        return null;
    }

    @Override
    public void updateCountryName(String codeName, String newCountryName) {

    }

    @Override
    public void loadCountries() {

    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        return null;
    }

    @Override
    public Country getCountryByName(String name) {
        return CheckedFunction0.liftTry(emf::createEntityManager)
                .andThen(Try::get)
                .andThen(entityManager -> {
                    Country country = entityManager
                            .createQuery(
                                    "select c from Country c where c.name like :name",
                                    Country.class)
                            .setParameter("name", name)
                            .getSingleResult();
                    entityManager.close();
                    return country;
                }).get();
    }

}

package lab.dao;

import lab.model.Country;

import java.util.List;

public interface CountryDao {

    void save(Country country);

    List<Country> getAllCountries();

    /**
     * @deprecated use {@link #getAllCountries}
     */
    @Deprecated
    default List<Country> getCountryList() {
        return getAllCountries();
    }

    List<Country> getCountryListStartWith(String name);

    void updateCountryName(String codeName, String newCountryName);

    void loadCountries();

    default Country getCountryByCodeName(String codeName) {
        return getAllCountries().stream()
                .filter(country -> country.getCodeName().equals(codeName))
                .findAny()
                .orElse(null);
    }

    Country getCountryByName(String name);

}
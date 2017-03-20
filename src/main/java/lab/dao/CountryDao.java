package lab.dao;

import lab.model.Country;
import lab.model.simple.SimpleCountry;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface CountryDao {

    String[][] COUNTRY_INIT_DATA = {
            {"Australia", "AU"},
            {"Canada", "CA"},
            {"France", "FR"},
            {"Hong Kong", "HK"},
            {"Iceland", "IC"},
            {"Japan", "JP"},
            {"Nepal", "NP"},
            {"Russian Federation", "RU"},
            {"Sweden", "SE"},
            {"Switzerland", "CH"},
            {"United Kingdom", "GB"},
            {"United States", "US"}
    };

    List<Country> getAll();

    default Country getByName(String name) {
        return getAll().stream()
                .filter(country -> country.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    default Country getCountryByCodeName(String codeName) {
        return getAll().stream()
                .filter(country -> country.getCodeName().equals(codeName))
                .findAny()
                .orElse(null);
    }

    void save(Country country);

    default void loadCountries() {
        Arrays.stream(COUNTRY_INIT_DATA)
//                .filter(strings -> strings.length == 2)
                .map(countryData -> new SimpleCountry(countryData[0], countryData[1]))
                .forEach(this::save);
    }

    default void updateName(String codeName, String newCountryName) {
        getAll().stream()
                .filter(country -> country.getCodeName().equals(codeName))
                .peek(country -> country.setName(newCountryName))
                .forEach(this::save);
    }

    default List<Country> getStartsWith(String name) {
        int length = name.length();
        return getAll().stream()
                .filter(country -> country.getName().substring(0, length).equals(name))
                .collect(Collectors.toList());
    }
}
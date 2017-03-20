package lab.dao;

import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.List;

//@Component
//@Qualifier("simpleCountryDao")
public class SimpleCountryDao extends NamedParameterJdbcDaoSupport implements CountryDao {

    private static final String LOAD_COUNTRIES_SQL = "INSERT INTO country (name, code_name) VALUES ('%s', '%s');";
    private static final String GET_ALL_COUNTRIES_SQL = "SELECT * FROM country";
    private static final String GET_COUNTRIES_BY_NAME_SQL = "SELECT * FROM country WHERE name LIKE :name";
    private static final String GET_COUNTRY_BY_NAME_SQL = "SELECT * FROM country WHERE name = '%s'";
    private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "SELECT * FROM country WHERE code_name = '%s'";
    private static final String UPDATE_COUNTRY_NAME_SQL = "UPDATE country SET name='%s' WHERE code_name='%s'";

    private static final RowMapper<Country> COUNTRY_ROW_MAPPER =
            (rs, rowNum) -> new SimpleCountry(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code_name"));

    @Override
    public List<Country> getAll() {
        return getJdbcTemplate().query(
                GET_ALL_COUNTRIES_SQL,
                COUNTRY_ROW_MAPPER);
    }

    @Override
    public List<Country> getStartsWith(String name) {
        return getNamedParameterJdbcTemplate().query(
                GET_COUNTRIES_BY_NAME_SQL,
                new MapSqlParameterSource("name", name + "%"),
                COUNTRY_ROW_MAPPER);
    }

    @Override
    public void updateName(String codeName, String newCountryName) {
        getJdbcTemplate().execute(
                String.format(UPDATE_COUNTRY_NAME_SQL, newCountryName, codeName));
    }

    @Override
    public void loadCountries() {
        for (String[] countryData : COUNTRY_INIT_DATA) {
            String sql = String.format(LOAD_COUNTRIES_SQL, countryData[0], countryData[1]);
            getJdbcTemplate().execute(sql);
        }
    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        String sql = String.format(GET_COUNTRY_BY_CODE_NAME_SQL, codeName);
        return getJdbcTemplate().query(sql, COUNTRY_ROW_MAPPER).get(0);
    }

    @Override
    public Country getByName(String name) {
        String sql = String.format(GET_COUNTRY_BY_NAME_SQL, name);
        List<Country> countryList = getJdbcTemplate().query(sql, COUNTRY_ROW_MAPPER);
        if (countryList.isEmpty())
            throw new CountryNotFoundException();
        return countryList.get(0);
    }

    @Override
    public void save(Country country) {

    }
}

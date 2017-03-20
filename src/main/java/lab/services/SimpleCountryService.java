package lab.services;

import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SimpleCountryService implements CountryService {

    @Autowired
    @Qualifier("simpleCountryService")
    private CountryService that;

	@Autowired
	private CountryDao countryDao;

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Country> getAllCountriesInsideTransaction(Propagation propagation) {
		if (Propagation.REQUIRED.equals(propagation)) {
			return that.getAllCountriesRequired();
		} else if (Propagation.REQUIRES_NEW.equals(propagation)) {
			return that.getAllCountriesRequiresNew();
		} else if (Propagation.SUPPORTS.equals(propagation)) {
			return that.getAllCountriesSupports();
		} else if (Propagation.NEVER.equals(propagation)) {
			return that.getAllCountriesNever();
		} else if (Propagation.MANDATORY.equals(propagation)) {
			return that.getAllCountriesMandatory();
		} else if (Propagation.NOT_SUPPORTED.equals(propagation)) {
			return that.getAllCountriesNotSupported();
		} else {
			return that.getAllCountries();
		}
	}

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Country> getAllCountriesRequired() {
		return countryDao.getAll();
	}

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Country> getAllCountriesRequiresNew() {
		return countryDao.getAll();
	}

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Country> getAllCountriesSupports() {
		return countryDao.getAll();
	}

    @Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<Country> getAllCountriesNever() {
		return countryDao.getAll();
	}

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Country> getAllCountriesMandatory() {
		return countryDao.getAll();
	}

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Country> getAllCountriesNotSupported() {
		return countryDao.getAll();
	}

	public List<Country> getAllCountries() {
		return countryDao.getAll();
	}

}
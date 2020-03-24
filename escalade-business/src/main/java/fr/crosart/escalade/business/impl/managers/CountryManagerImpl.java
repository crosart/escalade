package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.CountryManager;
import fr.crosart.escalade.consumer.contract.dao.CountryDao;
import fr.crosart.escalade.model.beans.Country;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CountryManagerImpl extends AbstractManager implements CountryManager {

    @Inject
    CountryDao countryDao;

    @Override
    public List<Country> getListCountries() {
        return countryDao.getListCountries();
    }

}

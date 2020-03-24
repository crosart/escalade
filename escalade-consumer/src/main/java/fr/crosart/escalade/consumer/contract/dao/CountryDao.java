package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getListCountries();
}

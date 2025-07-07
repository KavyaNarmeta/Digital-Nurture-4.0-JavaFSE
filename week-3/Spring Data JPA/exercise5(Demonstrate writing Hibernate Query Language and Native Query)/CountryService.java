package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String code) throws Exception {
        Country country = countryRepository.findByCode(code);
        if (country == null) throw new Exception("Country not found");
        return country;
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String newName) throws Exception {
        Country country = findCountryByCode(code);
        country.setName(newName);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    ///////////////////////////
    @Transactional
    public List<Country> findByNameContaining(String keyword) {
        return countryRepository.findByNameContaining(keyword);
    }

    @Transactional
    public List<Country> findByNameStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }

    @Transactional
    public List<Country> findByNameEndingWith(String suffix) {
        return countryRepository.findByNameEndingWith(suffix);
    }

    @Transactional
    public List<Country> findByNameIgnoreCase(String name) {
        return countryRepository.findByNameIgnoreCase(name);
    }
    @Transactional
    public List<Country> searchByNameJPQL(String keyword) {
        return countryRepository.searchByNameJPQL(keyword);
    }

    @Transactional
    public List<Country> searchByNameNative(String keyword) {
        return countryRepository.searchByNameNative(keyword);
    }


}

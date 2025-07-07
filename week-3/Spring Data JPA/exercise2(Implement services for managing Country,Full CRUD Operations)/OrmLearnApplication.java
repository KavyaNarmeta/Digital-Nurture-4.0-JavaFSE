package com.cognizant.orm_learn;


import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication

public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        testAddCountry();
        testGetAllCountries();
        testFindCountryByCode();
        testUpdateCountry();
        testDeleteCountry();
        testGetAllCountries();
    }

    private static void testAddCountry() {
        LOGGER.info("Add Country Start");
        Country country = new Country();
        country.setCode("FR");
        country.setName("France");
        countryService.addCountry(country);
        LOGGER.info("Add Country End");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Find by Code Start");
        try {
            Country country = countryService.findCountryByCode("FR");
            LOGGER.debug("Country: {}", country);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("Find by Code End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Update Start");
        try {
            countryService.updateCountry("FR", "Republic of France");
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("Update End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Delete Start");
        countryService.deleteCountry("FR");
        LOGGER.info("Delete End");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Get All Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("Get All End");
    }
}


package com.cognizant.springlearn.controller;
//Kavya Narmeta....Superset ID: 6397911
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
//Kavya Narmeta....Superset ID: 6397911
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	// Kavya Narmeta....Superset ID: 6397911
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
 // Kavya Narmeta....Superset ID: 6397911
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END");
        return country;
    }
  //Kavya Narmeta....Superset ID: 6397911
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        CountryService countryService = context.getBean("countryService", CountryService.class);
        Country country = countryService.getCountry(code);
        LOGGER.debug("Country : {}", country);
        LOGGER.info("END");
        return country;
    }

}

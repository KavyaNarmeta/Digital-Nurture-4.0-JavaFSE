package com.cognizant.orm_learn.repository;



import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByCode(String code);  // Find by primary key
}

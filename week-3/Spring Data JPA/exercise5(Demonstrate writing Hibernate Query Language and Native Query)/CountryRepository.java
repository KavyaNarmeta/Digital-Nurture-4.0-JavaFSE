package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByCode(String code);

    List<Country> findByNameContaining(String keyword);
    List<Country> findByNameStartingWith(String prefix);
    List<Country> findByNameEndingWith(String suffix);
    List<Country> findByNameIgnoreCase(String name);
    @Query("SELECT c FROM Country c WHERE c.name LIKE %:keyword%")
    List<Country> searchByNameJPQL(String keyword);
    @Query(value = "SELECT * FROM country WHERE co_name LIKE %:keyword%", nativeQuery = true)
    List<Country> searchByNameNative(String keyword);
}

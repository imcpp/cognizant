package com.cognizant.ormlearn.repository;



import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository(value="countryRepository")
public interface CountryRepository extends JpaRepository<Country, String> {

}

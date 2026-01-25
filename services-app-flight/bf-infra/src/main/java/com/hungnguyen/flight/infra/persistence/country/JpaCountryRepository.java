package com.hungnguyen.flight.infra.persistence.country;

import com.hungnguyen.flight.domain.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaCountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT c.country_id ,c.country_name FROM Country c", nativeQuery = true)
    List<Country> getAllCountries();
}

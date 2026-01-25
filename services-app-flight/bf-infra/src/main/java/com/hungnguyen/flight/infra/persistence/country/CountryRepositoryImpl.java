package com.hungnguyen.flight.infra.persistence.country;

import com.hungnguyen.flight.domain.country.Country;
import com.hungnguyen.flight.domain.country.CountryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository{

    private final JpaCountryRepository jpaCountryRepository;

    public CountryRepositoryImpl(JpaCountryRepository jpaCountryRepository) {
        this.jpaCountryRepository = jpaCountryRepository;
    }

    @Override
    public Country save(Country country) {
        return jpaCountryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountries() {
        return jpaCountryRepository.getAllCountries();
    }
}

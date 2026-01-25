package com.hungnguyen.flight.domain.country.validation;

import com.hungnguyen.flight.domain.country.CountryRepository;
import com.hungnguyen.flight.domain.country.CountryValidationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryNotExistValidationRule implements CountryValidationRule {

    private final CountryRepository countryRepository;

    public CountryNotExistValidationRule(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void validate(CountryValidationContext context) {
        String countryName = context.getCountryCommand().getCountryName();
        List<String> existingCountries = countryRepository.getAllCountries()
                .stream().map(country -> country.getCountryName().toLowerCase()).toList();
        if (existingCountries.contains(countryName.toLowerCase())) {
            throw new IllegalArgumentException("Country with name " + countryName + " already exists.");
        }
    }
}

package com.hungnguyen.flight.domain.country;

import org.springframework.stereotype.Service;

@Service
public class CountryDomainService {

    private final CountryRepository countryRepository;

    private final CountryValidator countryValidator;

    public CountryDomainService(CountryRepository countryRepository, CountryValidator countryValidator) {
        this.countryRepository = countryRepository;
        this.countryValidator = countryValidator;
    }

    public void addNewCountry(CountryCommand command) {
        CountryValidationContext countryValidationContext = new CountryValidationContext();
        countryValidationContext.setCountryCommand(command);
        countryValidator.validate(CountryValidator.ScenarioValidation.CREATE, countryValidationContext);
        Country country = new Country();
        country.setCountryName(command.getCountryName());
        countryRepository.save(country);
    }
}

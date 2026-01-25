package com.hungnguyen.flight.app.country;

import com.hungnguyen.flight.domain.country.CountryDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryCommandApplicationService {

    private CountryDomainService countryDomainService;

    private CountryMapper mapper;

    public CountryCommandApplicationService(CountryDomainService countryDomainService, CountryMapper mapper) {
        this.countryDomainService = countryDomainService;
        this.mapper = mapper;
    }

    @Transactional
    public void addNewCountry(CountryRequestDto dto) {
        countryDomainService.addNewCountry(mapper.map(dto));
    }
}

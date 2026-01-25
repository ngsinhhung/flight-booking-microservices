package com.hungnguyen.flight.domain.country;

import java.util.List;

public interface CountryRepository {
    Country save(Country country);

    List<Country> getAllCountries();
}

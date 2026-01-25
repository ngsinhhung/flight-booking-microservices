package com.hungnguyen.flight.domain.country.validation;

import com.hungnguyen.flight.domain.country.CountryValidationContext;

public interface CountryValidationRule {
    void validate(CountryValidationContext context);
}

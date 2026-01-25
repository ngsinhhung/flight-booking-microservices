package com.hungnguyen.flight.app.country;


import com.hungnguyen.flight.domain.country.CountryCommand;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryCommand map(CountryRequestDto dto) {
        CountryCommand command = new CountryCommand();
        command.setCountryName(dto.getCountryName());
        return command;
    }
}

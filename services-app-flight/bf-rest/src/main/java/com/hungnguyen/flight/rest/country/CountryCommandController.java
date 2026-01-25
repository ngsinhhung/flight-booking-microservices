package com.hungnguyen.flight.rest.country;

import com.hungnguyen.flight.app.country.CountryCommandApplicationService;
import com.hungnguyen.flight.app.country.CountryRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/country")
public class CountryCommandController {

    private CountryCommandApplicationService countryCommandApplicationService;

    public CountryCommandController(CountryCommandApplicationService countryCommandApplicationService) {
        this.countryCommandApplicationService = countryCommandApplicationService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addNewCountry(@RequestBody CountryRequestDto dto) {
        countryCommandApplicationService.addNewCountry(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.hungnguyen.flight.rest.country;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/country")
public class CountryCommandController {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCountry() {
        // Implementation for creating a country goes here
    }
}

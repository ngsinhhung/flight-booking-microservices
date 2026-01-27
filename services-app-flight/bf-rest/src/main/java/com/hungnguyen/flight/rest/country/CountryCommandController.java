package com.hungnguyen.flight.rest.country;

import com.hungnguyen.flight.app.country.CountryCommandApplicationService;
import com.hungnguyen.flight.app.country.CountryRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/country")
@Tag(name = "Country", description = "APIs for managing country data")
public class CountryCommandController {

    private final CountryCommandApplicationService countryCommandApplicationService;

    public CountryCommandController(CountryCommandApplicationService countryCommandApplicationService) {
        this.countryCommandApplicationService = countryCommandApplicationService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add New Country", description = "API to add a new country")
    public ResponseEntity<Void> addNewCountry(@RequestBody CountryRequestDto dto) {
        countryCommandApplicationService.addNewCountry(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

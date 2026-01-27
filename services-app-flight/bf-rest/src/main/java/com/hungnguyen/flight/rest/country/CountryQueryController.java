package com.hungnguyen.flight.rest.country;

import com.hungnguyen.flight.app.country.CountryQueryApplicationService;
import com.hungnguyen.flight.app.country.CountryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/country")
@Tag(name = "Country", description = "APIs for retrieving country data")
public class CountryQueryController {

    private final CountryQueryApplicationService countryQueryApplicationService;

    public CountryQueryController(CountryQueryApplicationService countryQueryApplicationService) {
        this.countryQueryApplicationService = countryQueryApplicationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Countries", description = "API to retrieve the list of countries")
    public ResponseEntity<List<CountryResponseDto>> getCountries() {
        return new ResponseEntity<>(countryQueryApplicationService.getCountries(), HttpStatus.OK);
    }


}

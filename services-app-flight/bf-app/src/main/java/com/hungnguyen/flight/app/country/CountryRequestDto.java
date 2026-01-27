package com.hungnguyen.flight.app.country;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Country Request Object")
public class CountryRequestDto {

    @NotNull
    @NotEmpty
    @Schema(description = "Name of the country", example = "United States")
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

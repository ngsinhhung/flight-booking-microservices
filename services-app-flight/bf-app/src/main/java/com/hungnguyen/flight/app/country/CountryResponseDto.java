package com.hungnguyen.flight.app.country;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Country Response Object")
public class CountryResponseDto {

    @Schema(description = "Unique identifier of the country", example = "1")
    private Integer countryId;

    @Schema(description = "Name of the country", example = "United States")
    private String countryName;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

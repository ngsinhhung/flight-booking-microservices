package com.hungnguyen.flight.infra.persistence.country;

import com.hungnguyen.flight.app.country.CountryResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountryMybatisMapper {

    @Select("SELECT country_id AS countryId, country_name AS countryName FROM country")
    List<CountryResponseDto> getCountries();
}

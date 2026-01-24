package com.hungnguyen.flight.infra.persistence.country;

import com.hungnguyen.flight.app.country.CountryResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMybatisMapper {

    List<CountryResponseDto> getCountries();
}

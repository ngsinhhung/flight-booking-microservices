package com.hungnguyen.flight.infra.persistence.country;

import com.hungnguyen.flight.app.country.CountryMapper;
import com.hungnguyen.flight.app.country.CountryQueryApplicationService;
import com.hungnguyen.flight.app.country.CountryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryQueryApplicationServiceImpl implements CountryQueryApplicationService {

    private final CountryMybatisMapper mybatisMapper;

    public CountryQueryApplicationServiceImpl(CountryMybatisMapper mybatisMapper, CountryMapper countryMapper) {
        this.mybatisMapper = mybatisMapper;
    }

    @Override
    public List<CountryResponseDto> getCountries() {
        return mybatisMapper.getCountries();
    }
}

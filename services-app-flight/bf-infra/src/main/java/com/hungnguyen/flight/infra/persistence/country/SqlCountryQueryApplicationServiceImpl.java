package com.hungnguyen.flight.infra.persistence.country;

import com.hungnguyen.flight.app.country.CountryQueryApplicationService;
import com.hungnguyen.flight.app.country.CountryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlCountryQueryApplicationServiceImpl implements CountryQueryApplicationService {

    private final CountryMybatisMapper mybatisMapper;

    public SqlCountryQueryApplicationServiceImpl(CountryMybatisMapper mybatisMapper) {
        this.mybatisMapper = mybatisMapper;
    }

    @Override
    public List<CountryResponseDto> getCountries() {
        return mybatisMapper.getCountries();
    }
}

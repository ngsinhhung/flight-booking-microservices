package com.hungnguyen.flight.domain.country;


import com.hungnguyen.flight.domain.booking.BookingValidationContext;
import com.hungnguyen.flight.domain.booking.BookingValidator;
import com.hungnguyen.flight.domain.booking.validation.BookingValidationRule;
import com.hungnguyen.flight.domain.booking.validation.SeatCodeValidationRule;
import com.hungnguyen.flight.domain.country.validation.CountryNotExistValidationRule;
import com.hungnguyen.flight.domain.country.validation.CountryValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CountryValidator {

    @Autowired
    private ApplicationContext applicationContext;

    private final Map<CountryValidator.ScenarioValidation, List<Class<? extends CountryValidationRule>>> rulesByScenario;

    {
        rulesByScenario = Map.of(
                CountryValidator.ScenarioValidation.CREATE,
                List.of(CountryNotExistValidationRule.class)
        );
    }
    public void validate(CountryValidator.ScenarioValidation scenario, CountryValidationContext context) {
        List<Class<? extends CountryValidationRule>> rules = rulesByScenario.get(scenario);
        for (Class<? extends CountryValidationRule> rule : rules) {
            try {
                CountryValidationRule validationRule = applicationContext.getBean(rule);
                validationRule.validate(context);
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate validation rule: " + rule.getName(), e);
            }
        }
    }


    public enum ScenarioValidation {
        CREATE
    }
}

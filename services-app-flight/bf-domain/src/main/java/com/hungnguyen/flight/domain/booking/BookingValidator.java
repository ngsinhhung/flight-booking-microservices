package com.hungnguyen.flight.domain.booking;

import com.hungnguyen.flight.domain.booking.validation.BookingValidationRule;
import com.hungnguyen.flight.domain.booking.validation.SeatCodeValidationRule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BookingValidator {

    private final Map<ScenarioValidation, List<Class<? extends BookingValidationRule>>> rulesByScenario;

    {
        rulesByScenario = Map.of(
                ScenarioValidation.CREATE,
                List.of(SeatCodeValidationRule.class)
        );
    }

    public void validate(ScenarioValidation scenario, BookingValidationContext context) {
        List<Class<? extends BookingValidationRule>> rules = rulesByScenario.get(scenario);
        for (Class<? extends BookingValidationRule> rule : rules) {
            try {
                BookingValidationRule validationRule = rule.getDeclaredConstructor().newInstance();
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

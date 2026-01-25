package com.hungnguyen.flight.domain.booking.validation;

import com.hungnguyen.flight.domain.booking.BookingValidationContext;

public interface BookingValidationRule {
    void validate(BookingValidationContext context);
}

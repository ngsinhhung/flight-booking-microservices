package com.hungnguyen.flight.domain.booking.validation;

import com.hungnguyen.flight.domain.booking.BookingValidationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingSeatAvailableValidationRule implements BookingValidationRule {

    @Override
    public void validate(BookingValidationContext context) {
        Optional<Integer> seatId = context.getBookingCommand().getSeatId();


    }
}

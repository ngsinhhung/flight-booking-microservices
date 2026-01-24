package com.hungnguyen.flight.domain.booking.validation;

import com.hungnguyen.flight.domain.booking.BookingValidationContext;
import org.springframework.stereotype.Component;

@Component
public class SeatCodeValidationRule implements BookingValidationRule {

    @Override
    public void validate(BookingValidationContext context) {
        String seatCode = context.getBookingCommand().getSeatCode();


    }
}

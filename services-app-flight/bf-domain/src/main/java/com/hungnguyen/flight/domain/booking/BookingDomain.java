package com.hungnguyen.flight.domain.booking;


import org.springframework.stereotype.Service;

@Service
public class BookingDomain {

    private final BookingValidator bookingValidator;

    public BookingDomain(BookingValidator bookingValidator) {
        this.bookingValidator = bookingValidator;
    }

    public String createFlightBooking(BookingCommand bookingCommand) {
        BookingValidationContext validationContext = new BookingValidationContext();
        validationContext.setBookingCommand(bookingCommand);
        bookingValidator.validate(BookingValidator.ScenarioValidation.CREATE, validationContext);


        return "BOOKING12345";
    }
}

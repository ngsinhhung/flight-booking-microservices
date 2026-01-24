package com.hungnguyen.flight.domain.booking;


public class BookingValidationContext {

    private BookingCommand bookingCommand;

    public BookingCommand getBookingCommand() {
        return bookingCommand;
    }

    public void setBookingCommand(BookingCommand bookingCommand) {
        this.bookingCommand = bookingCommand;
    }
}

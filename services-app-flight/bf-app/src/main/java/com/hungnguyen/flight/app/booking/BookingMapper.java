package com.hungnguyen.flight.app.booking;

import com.hungnguyen.flight.domain.booking.BookingCommand;

import java.util.Optional;

public class BookingMapper {

    public BookingCommand mapDtoToCommand(BookingRequestDto bookingDto) {
        BookingCommand command = new BookingCommand();
        command.setFlightId(Optional.of(bookingDto.getFlightId()));
        command.setSeatId(Optional.of(bookingDto.getSeatId()));
        return command;
    }
}

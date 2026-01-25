package com.hungnguyen.flight.app.booking;

import com.hungnguyen.flight.domain.booking.BookingCommand;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingCommand mapDtoToCommand(BookingRequestDto bookingDto) {
        BookingCommand command = new BookingCommand();

        return command;
    }
}

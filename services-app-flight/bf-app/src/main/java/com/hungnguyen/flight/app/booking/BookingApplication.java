package com.hungnguyen.flight.app.booking;


import com.hungnguyen.flight.domain.booking.BookingDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingApplication {

    private final BookingDomain bookingDomain;
    private final BookingMapper bookingMapper;

    public BookingApplication(BookingDomain bookingDomain, BookingMapper bookingMapper) {
        this.bookingDomain = bookingDomain;
        this.bookingMapper = bookingMapper;
    }


    @Transactional
    public String createFlightBooking (BookingRequestDto bookingRequestDto) {
        return bookingDomain.createFlightBooking(bookingMapper.mapDtoToCommand(bookingRequestDto));
    }
}

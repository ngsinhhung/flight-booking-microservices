package com.hungnguyen.flight.rest.booking;


import com.hungnguyen.flight.app.booking.BookingApplication;
import com.hungnguyen.flight.app.booking.BookingRequestDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/booking")
public class BookingCommandController {

    private final BookingApplication bookingApplication;

    public BookingCommandController(BookingApplication bookingApplication) {
        this.bookingApplication = bookingApplication;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createFlightBooking(@RequestBody BookingRequestDto bookingRequest) {
        String bookingId = bookingApplication.createFlightBooking(bookingRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-ID", bookingId);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}

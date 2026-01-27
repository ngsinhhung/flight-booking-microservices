package com.hungnguyen.flight.rest.booking;


import com.hungnguyen.flight.app.booking.BookingApplication;
import com.hungnguyen.flight.app.booking.BookingRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/booking")
@Tag(name = "Booking", description = "APIs for managing flight bookings")
public class BookingCommandController {

    private final BookingApplication bookingApplication;

    public BookingCommandController(BookingApplication bookingApplication) {
        this.bookingApplication = bookingApplication;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Flight Booking", description = "API to create a new flight booking")
    public ResponseEntity<Void> createFlightBooking(@RequestBody BookingRequestDto bookingRequest) {
        String bookingId = bookingApplication.createFlightBooking(bookingRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-ID", bookingId);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}

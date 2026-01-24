package com.hungnguyen.flight.domain.booking;

import java.util.Optional;

public class BookingCommand {

    private Optional<Integer> flightId;

    private Optional<Integer> seatId;

    public Optional<Integer> getFlightId() {
        return flightId;
    }

    public void setFlightId(Optional<Integer> flightId) {
        this.flightId = flightId;
    }

    public Optional<Integer> getSeatId() {
        return seatId;
    }

    public void setSeatId(Optional<Integer> seatId) {
        this.seatId = seatId;
    }
}

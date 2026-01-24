package com.hungnguyen.flight.domain.booking;

import java.util.Optional;

public class BookingCommand {

    private Integer flightId;

    private String seatCode;


    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }
}

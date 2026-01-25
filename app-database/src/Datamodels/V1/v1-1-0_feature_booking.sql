-- liquibase formatted sql

-- changeset hungnguyen:V1.1.0-feature-booking
-- tagDatabase V1.1.0

CREATE TABLE country (
    country_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    country_name VARCHAR(255)
);


CREATE TABLE airport (
    airport_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    airport_code VARCHAR(10) NOT NULL UNIQUE,
    airport_name VARCHAR(255) NOT NULL,
    address VARCHAR(100),
    country_id BIGINT NOT NULL,
    CONSTRAINT fk_airport_country FOREIGN KEY (country_id) REFERENCES country(country_id)
);

CREATE TABLE flight (
    flight_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    flight_code VARCHAR(50) NOT NULL UNIQUE,
    departure_airport_id BIGINT NOT NULL,
    arrival_airport_id BIGINT NOT NULL,
    departure_time DATETIME NOT NULL,
    arrival_time DATETIME NOT NULL,
    total_seats INT NOT NULL,
    booking_seats INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_flight_departure_airport FOREIGN KEY (departure_airport_id) REFERENCES airport(airport_id),
    CONSTRAINT fk_flight_arrival_airport FOREIGN KEY (arrival_airport_id) REFERENCES airport(airport_id)
);

CREATE TABLE booking (
    booking_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
    flight_id BIGINT NOT NULL,
    seat VARCHAR(50) NOT NULL,
    booking_date DATETIME2 DEFAULT SYSDATETIME(),
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_booking_flight FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
);

CREATE TABLE seat_locks (
    seat_lock_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    flight_id BIGINT NOT NULL,
    booking_id UNIQUEIDENTIFIER NOT NULL,
    lock_time DATETIME2 DEFAULT SYSDATETIME(),
    CONSTRAINT fk_seat_locks_flight FOREIGN KEY (flight_id) REFERENCES flight(flight_id),
    CONSTRAINT fk_seat_locks_booking FOREIGN KEY (booking_id) REFERENCES booking(booking_id)
);


--rollback drop table seat_locks;
--rollback drop table booking;
--rollback drop table flight;
--rollback drop table airport;
--rollback drop table country;


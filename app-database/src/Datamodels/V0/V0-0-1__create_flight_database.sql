-- liquibase formatted sql

-- changeset hungnguyen:init-flight-shema-v0-0-1
CREATE TABLE sec_user (
   user_id BIGINT IDENTITY(1,1) PRIMARY KEY,
   keycloak_id VARCHAR(100) NOT NULL,
   email VARCHAR(255) NOT NULL UNIQUE,
   full_name VARCHAR(255),
   created_at DATETIME2 DEFAULT SYSDATETIME()
);

CREATE TABLE role (
   role_id BIGINT IDENTITY(1,1) PRIMARY KEY,
   role VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES sec_user(user_id),
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE customer (
    customer_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    keycloak_user_id VARCHAR(36) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    customer_name VARCHAR(150),
    phone VARCHAR(20),
    status VARCHAR(30),
    created_at DATETIME2 DEFAULT SYSDATETIME(),
    updated_at DATETIME2 NULL
)

CREATE TABLE country (
    country_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    country_name VARCHAR(255)
)

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
    status VARCHAR(30) NOT NULL,
    CONSTRAINT fk_flight_departure_airport FOREIGN KEY (departure_airport_id) REFERENCES airport(airport_id),
    CONSTRAINT fk_flight_arrival_airport FOREIGN KEY (arrival_airport_id) REFERENCES airport(airport_id)
);

CREATE TABLE aircraft (
    aircraft_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    aircraft_code VARCHAR(50) NOT NULL UNIQUE,
    model VARCHAR(50),
    manufacturer VARCHAR(100),
    seats_config INT
)

--rollback DROP TABLE user_roles;
--rollback DROP TABLE flight;
--rollback DROP TABLE airport;
--rollback DROP TABLE country;
--rollback DROP TABLE customer;
--rollback DROP TABLE aircraft;
--rollback DROP TABLE role;
--rollback DROP TABLE sec_user;

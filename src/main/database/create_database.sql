/*
CREATE TABLES
*/

-- define airport table structure to provide integrity in app
CREATE TABLE airport
(
    iata_code   VARCHAR2(3 CHAR) NOT NULL PRIMARY KEY,
    icao_code   VARCHAR2(4 CHAR) NOT NULL,
    name        VARCHAR2(40 CHAR) NOT NULL,
    city        VARCHAR2(40 CHAR) NOT NULL,
    country     VARCHAR2(40 CHAR) NOT NULL,
    address     VARCHAR2(40 CHAR) NOT NULL
);

-- define airports table structure
CREATE TABLE airports
(
    iata_code   VARCHAR2(3 CHAR) NOT NULL,
    icao_code   VARCHAR2(4 CHAR) NOT NULL PRIMARY KEY,
    name        VARCHAR2(40 CHAR) NOT NULL,
    city        VARCHAR2(40 CHAR) NOT NULL,
    country     VARCHAR2(40 CHAR) NOT NULL,
    address     VARCHAR2(40 CHAR) NOT NULL
);

-- define aircrafts table structre
CREATE TABLE aircrafts
(
    aircraft_id         VARCHAR2(40 CHAR) NOT NULL PRIMARY KEY,
    name                VARCHAR2(40 CHAR) NOT NULL,
    brand               VARCHAR2(40 CHAR) NOT NULL,
    max_eco_seats       NUMERIC(3,0) NOT NULL,
    max_business_seats  NUMERIC(3,0) NOT NULL,
    model               VARCHAR2(40 CHAR) NOT NULL
);

-- define passengers table structure
CREATE TABLE passengers
(
    person_id   VARCHAR2(40 CHAR) NOT NULL PRIMARY KEY,
    first_name  VARCHAR2(40 CHAR) NOT NULL,
    last_name   VARCHAR2(40 CHAR) NOT NULL
);

-- define tickets table structure
CREATE TABLE tickets
(
    ticket_id       VARCHAR2(40 CHAR) NOT NULL PRIMARY KEY,
    passenger_id    VARCHAR2(40 CHAR) NOT NULL,
    flight_id       VARCHAR2(40 CHAR) NOT NULL,
    seat_number     NUMERIC(3,0) NOT NULL,
    seat_class      VARCHAR2(40 CHAR) NOT NULL
);

-- define crewmembers table structure
CREATE TABLE crewmembers
(
    person_id   VARCHAR2(40 CHAR) NOT NULL PRIMARY KEY,
    first_name  VARCHAR2(40 CHAR) NOT NULL,
    last_name   VARCHAR2(40 CHAR) NOT NULL,
    position_id NUMERIC(2,0) NOT NULL
);

-- define positions table structure
CREATE TABLE positions
(
    position_id NUMERIC(2, 0) NOT NULL PRIMARY KEY,
    name        VARCHAR2(40 CHAR) NOT NULL
);

-- define positions_history table structure
CREATE TABLE positions_history
(
    ph_id       NUMERIC(4, 0) NOT NULL PRIMARY KEY,
    employee_id VARCHAR2(40 CHAR) NOT NULL,
    position_id NUMERIC(2, 0) NOT NULL,
    start_date  DATE NOT NULL,
    end_date    DATE
);

-- define flights table stucture
CREATE TABLE flights
(
    flight_id           VARCHAR2(40 CHAR) NOT NULL PRIMARY KEY,
    origin_airport      VARCHAR2(40 CHAR) NOT NULL,
    destination_airport VARCHAR2(40 CHAR) NOT NULL,
    departure_time      DATE NOT NULL,
    arrival_time        DATE NOT NULL,
    aircraft_id         VARCHAR2(40 CHAR) NOT NULL
);

-- define flights_crew table structure
CREATE TABLE flights_crew
(
    flight_id       VARCHAR2(40 CHAR) NOT NULL,
    crewmember_id   VARCHAR2(40 CHAR) NOT NULL
);

-- define occupied_eco_seats table structure
CREATE TABLE occupied_eco_seats
(
    flight_id   VARCHAR2(40 CHAR) NOT NULL,
    seat_number VARCHAR2(40 CHAR) NOT NULL
);

-- define occupied_business_seats table structure
CREATE TABLE occupied_business_seats
(
    flight_id   VARCHAR2(40 CHAR) NOT NULL,
    seat_number VARCHAR2(40 CHAR) NOT NULL
);
    
CREATE TABLE salgrades
(
    salgrade_id NUMBER NOT NULL PRIMARY KEY,
    min_salary  NUMBER NOT NULL,
    max_salary  NUMBER NOT NULL
);

--------------------------------------------------------------------------------
/*
ADD CONSTRAINTS
*/
ALTER TABLE tickets
    ADD CONSTRAINT tickets_passengers_fk FOREIGN KEY (passenger_id)
    REFERENCES passengers (person_id);

ALTER TABLE tickets
    ADD CONSTRAINT tickets_flights_fk FOREIGN KEY (flight_id)
    REFERENCES flights (flight_id);

ALTER TABLE tickets
    ADD CONSTRAINT tickets_types CHECK (seat_class LIKE 'ECO' OR seat_class LIKE 'BUSINESS');
    
ALTER TABLE flights
    ADD CONSTRAINT flights_aircrafts_fk FOREIGN KEY (aircraft_id)
    REFERENCES aircrafts (aircraft_id);

ALTER TABLE occupied_business_seats
    ADD CONSTRAINT business_seats_flights_fk FOREIGN KEY (flight_id)
    REFERENCES flights (flight_id);

ALTER TABLE occupied_eco_seats
    ADD CONSTRAINT eco_seats_flights_fk FOREIGN KEY (flight_id)
    REFERENCES flights (flight_id);

ALTER TABLE flights
    ADD CONSTRAINT origin_airports_fk FOREIGN KEY (origin_airport)
    REFERENCES airports (icao_code);

ALTER TABLE flights
    ADD CONSTRAINT destination_airports_fk FOREIGN KEY (destination_airport)
    REFERENCES airports (icao_code);
    
ALTER TABLE flights
    ADD CONSTRAINT flight_time CHECK (departure_time < arrival_time);

ALTER TABLE flights_crew
    ADD CONSTRAINT cremembers_fk FOREIGN KEY (crewmember_id)
    REFERENCES crewmembers (person_id);

ALTER TABLE flights_crew
    ADD CONSTRAINT flights_fk FOREIGN KEY (flight_id)
    REFERENCES flights (flight_id);

ALTER TABLE crewmembers
    ADD CONSTRAINT crewmembers_positions_fk FOREIGN KEY (position_id)
    REFERENCES positions (position_id);

ALTER TABLE positions_history
    ADD CONSTRAINT ph_crewmembers_fk FOREIGN KEY (employee_id)
    REFERENCES crewmembers (person_id);

ALTER TABLE positions_history
    ADD CONSTRAINT ph_positions_fk FOREIGN KEY (position_id)
    REFERENCES positions (position_id);

ALTER TABLE salgrades
    ADD CONSTRAINT check_salary_forks CHECK (min_salary < max_salary);

ALTER TABLE positions
    ADD salgrade NUMBER;

ALTER TABLE positions
    ADD CONSTRAINT postions_salgrades_fk FOREIGN KEY (salgrade)
    REFERENCES salgrades (salgrade_id);
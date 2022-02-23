CREATE OR REPLACE TRIGGER tg_crew_positions_history
AFTER UPDATE OF position_id ON crewmembers
FOR EACH ROW
WHEN (new.position_id != old.position_id)
DECLARE
    v_end_date              positions_history.end_date%TYPE;
    v_crewmem_old_ph_id     positions_history.ph_id%TYPE;
    v_crewmem_new_ph_id     positions_history.ph_id%TYPE;
BEGIN    
    SELECT MAX(ph_id)
    INTO v_crewmem_old_ph_id
    FROM positions_history
    WHERE employee_id = :old.person_id;

    IF v_crewmem_old_ph_id IS NOT NULL THEN
        UPDATE positions_history
        SET end_date = SYSDATE
        WHERE ph_id = v_crewmem_old_ph_id;
    END IF;
    
    IF v_end_date IS NULL THEN
        v_end_date := SYSDATE;
    END IF;
    
    INSERT INTO positions_history VALUES (get_new_positions_history_index, :new.person_id, :new.position_id, v_end_date, NULL);
    
END tg_crew_positions_history;
/


CREATE OR REPLACE TRIGGER tg_add_eco_seats_occupancy
AFTER INSERT ON TICKETS
FOR EACH ROW
WHEN (UPPER(new.seat_class) LIKE 'ECO')
DECLARE
    v_is_available  BOOLEAN;
BEGIN
    dbms_output.put_line('tg_add_eco_seats_occupancy');
    v_is_available := check_if_eco_seat_available(:new.seat_number, :new.flight_id);
    
    IF v_is_available THEN
        INSERT INTO occupied_eco_seats VALUES (:new.flight_id, :new.seat_number);
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Cannot book already occupied seat');
    END IF;
END tg_add_eco_seats_occupancy;
/


CREATE OR REPLACE TRIGGER tg_delete_eco_seat_occupancy
AFTER DELETE ON TICKETS
FOR EACH ROW
WHEN (UPPER(old.seat_class) = 'ECO')
BEGIN
    DELETE FROM occupied_eco_seats
    WHERE (flight_id = :old.flight_id) AND (seat_number = :old.seat_number);
END tg_delete_eco_seat_occupancy;
/


CREATE OR REPLACE TRIGGER tg_eco_seat_number_change
AFTER UPDATE OF seat_number ON TICKETS
FOR EACH ROW
WHEN (UPPER(old.seat_class) = 'ECO' AND UPPER(new.seat_class) = 'ECO' AND new.seat_number <> old.seat_number)
DECLARE
    v_is_available  BOOLEAN;
BEGIN
    dbms_OUTPUT.put_line('tg_eco_seat_number_change');
    v_is_available := check_if_eco_seat_available(:new.seat_number, :new.flight_id);
    
    IF v_is_available THEN
        UPDATE occupied_eco_seats
        SET seat_number = :new.seat_number
        WHERE (seat_number = :old.seat_number) AND (flight_id = :old.flight_id);
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Cannot book already occupied seat');
    END IF;
END tg_eco_seat_number_change;
/


CREATE OR REPLACE TRIGGER tg_add_business_seats_occupancy
AFTER INSERT ON TICKETS
FOR EACH ROW
WHEN (UPPER(new.seat_class) LIKE 'BUSINESS')
DECLARE
    v_is_available  BOOLEAN;
BEGIN
    dbms_output.put_line('tg_add_business_seats_occupancy');
    v_is_available := check_if_business_seat_available(:new.seat_number, :new.flight_id);
    
    IF v_is_available THEN
        INSERT INTO occupied_business_seats VALUES (:new.flight_id, :new.seat_number);
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Cannot book already occupied seat');
    END IF;
END tg_add_business_seats_occupancy;
/


CREATE OR REPLACE TRIGGER tg_delete_business_seat_occupancy
AFTER DELETE ON TICKETS
FOR EACH ROW
WHEN (UPPER(old.seat_class) = 'BUSINESS')
BEGIN
    DELETE FROM occupied_business_seats
    WHERE (flight_id = :old.flight_id) AND (seat_number = :old.seat_number);
END tg_delete_business_seat_occupancy;
/


CREATE OR REPLACE TRIGGER tg_business_seat_number_change
AFTER UPDATE OF seat_number ON TICKETS
FOR EACH ROW
WHEN ((UPPER(old.seat_class) = 'BUSINESS') AND (UPPER(new.seat_class) = 'BUSINESS') AND (new.seat_number <> old.seat_number))
DECLARE
    v_is_available  BOOLEAN;
BEGIN
    dbms_OUTPUT.put_line('tg_business_seat_number_change');
    v_is_available := check_if_business_seat_available(:new.seat_number, :new.flight_id);
    
    IF v_is_available THEN
        UPDATE occupied_business_seats
        SET seat_number = :new.seat_number
        WHERE (seat_number = :old.seat_number) AND (flight_id = :old.flight_id);
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Cannot book already occupied seat');
    END IF;
END tg_business_seat_number_change;
/


CREATE OR REPLACE TRIGGER th_check_seat_number
BEFORE INSERT ON tickets
FOR EACH ROW
DECLARE
    -- eco and business seat are of the same data type
    v_max_seats_num     aircrafts.max_eco_seats%TYPE;
BEGIN
    IF UPPER(:new.seat_class) LIKE 'ECO' THEN
        SELECT a.max_eco_seats
        INTO v_max_seats_num
        FROM flights f
            LEFT JOIN aircrafts a ON (f.aircraft_id = a.aircraft_id)
        WHERE f.flight_id = :new.flight_id;
    ELSE
        SELECT a.max_business_seats
        INTO v_max_seats_num
        FROM flights f
            LEFT JOIN aircrafts a ON (f.aircraft_id = a.aircraft_id)
        WHERE f.flight_id = :new.flight_id;
    END IF; 
    
    IF (:new.seat_number < 1) OR (:new.seat_number > v_max_seats_num) THEN
        RAISE_APPLICATION_ERROR(-20002, 'Cannot book seat number greater than maximum or smaller than 1');
    END IF;
END tg_check_seat_number;
/

CREATE OR REPLACE TRIGGER tg_change_business_seat_to_eco
AFTER UPDATE OF seat_class ON TICKETS
FOR EACH ROW
WHEN (UPPER(old.seat_class) = 'BUSINESS' AND UPPER(new.seat_class) = 'ECO')
DECLARE
    v_is_available  BOOLEAN;
BEGIN
    dbms_output.put_line('tg_change_business_seat_to_eco');
    v_is_available := check_if_eco_seat_available(:new.seat_number, :new.flight_id);
    
    IF v_is_available THEN
        INSERT INTO occupied_eco_seats VALUES (:new.flight_id, :new.seat_number);
        
        DELETE FROM occupied_business_seats
        WHERE (flight_id = :old.flight_id) AND (seat_number = :old.seat_number);
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Cannot book already occupied seat');
    END IF;
END tg_business_seat_number_change;
/

CREATE OR REPLACE TRIGGER tg_change_eco_seat_to_business
AFTER UPDATE OF seat_class ON TICKETS
FOR EACH ROW
WHEN (UPPER(old.seat_class) = 'ECO' AND UPPER(new.seat_class) = 'BUSINESS')
DECLARE
    v_is_available  BOOLEAN;
BEGIN
    dbms_output.put_line('tg_change_eco_seat_to_business');
    v_is_available := check_if_business_seat_available(:new.seat_number, :new.flight_id);
    
    IF v_is_available THEN
        INSERT INTO occupied_business_seats VALUES (:new.flight_id, :new.seat_number);
    
        DELETE FROM occupied_eco_seats
        WHERE (flight_id = :old.flight_id) AND (seat_number = :old.seat_number);
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Cannot book already occupied seat');
    END IF;
END tg_business_seat_number_change;
/

CREATE OR REPLACE TRIGGER tg_delete_flight
BEFORE DELETE ON flights
FOR EACH ROW
DECLARE
BEGIN
    DELETE FROM flights_crew
    WHERE flight_id = :old.flight_id;
    
    DELETE FROM tickets
    WHERE flight_id = :old.flight_id;
END tg_delete_flight;
/

CREATE OR REPLACE TRIGGER tg_delete_airport
BEFORE DELETE ON airports
FOR EACH ROW
DECLARE
BEGIN
    DELETE FROM flights
    WHERE origin_airport = :old.icao_code;
    
    DELETE FROM flights
    WHERE destination_airport = :old.icao_code;
END tg_delete_airport;
/

CREATE OR REPLACE TRIGGER tg_delete_aircraft
BEFORE DELETE ON aircrafts
FOR EACH ROW
DECLARE
BEGIN
    DELETE FROM flights
    WHERE aircraft_id = :old.aircraft_id;
END tg_delete_aircraft;
/

CREATE OR REPLACE TRIGGER tg_delete_crewmember
BEFORE DELETE ON crewmembers
FOR EACH ROW
BEGIN
    DELETE FROM positions_history
    WHERE employee_id = :old.person_id;
END tg_delete_crewmember;
/

CREATE OR REPLACE TRIGGER tg_delete_passenger
BEFORE DELETE ON passengers
FOR EACH ROW
BEGIN
    DELETE FROM tickets
    WHERE passenger_id = :old.person_id;
END tg_delete_passenger;
/
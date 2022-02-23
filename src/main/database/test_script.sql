/* TEST FUNCTIONS */
/* test get_new_positions_history_index */
SELECT get_new_positions_history_index FROM dual;

/* test check_if_eco_seat_available */
DECLARE
    v_availability  BOOLEAN;
BEGIN
    v_availability := check_if_eco_seat_available(1, '1');  /* should be false if data is loaded */
    IF v_availability THEN
        dbms_output.put_line('TRUE - is available');
    ELSE
        dbms_output.put_line('FALSE - is not available');
    END IF;
END;
/

DECLARE
    v_availability  BOOLEAN;
BEGIN
    v_availability := check_if_eco_seat_available(1, '2');  /* should be true if data is loaded */
    IF v_availability THEN
        dbms_output.put_line('TRUE - is available');
    ELSE
        dbms_output.put_line('FALSE - is not available');
    END IF;
END;
/

/* test check_if_business_seat_available */
DECLARE
    v_availability  BOOLEAN;
BEGIN
    v_availability := check_if_business_seat_available(1, '1');  /* should be false if data is loaded */
    IF v_availability THEN
        dbms_output.put_line('TRUE - is available');
    ELSE
        dbms_output.put_line('FALSE - is not available');
    END IF;
END;
/

DECLARE
    v_availability  BOOLEAN;
BEGIN
    v_availability := check_if_business_seat_available(1, '2');  /* should be true if data is loaded */
    IF v_availability THEN
        dbms_output.put_line('TRUE - is available');
    ELSE
        dbms_output.put_line('FALSE - is not available');
    END IF;
END;
/


/* TEST TRIGGERS */
/* test tg_crew_positions_history */
UPDATE crewmembers
SET position_id = 1
WHERE person_id = '1';

UPDATE crewmembers
SET position_id = 2
WHERE person_id = '1';

ROLLBACK;

/* test tg_add_eco_seats_occupancy */
INSERT INTO passengers VALUES (100, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (100, 100, 1, 100, 'ECO');   /* available seat */
INSERT INTO tickets VALUES (101, 100, 1, 100, 'ECO');   /* seat no longer available*/
ROLLBACK;

/* test tg_delete_eco_seat_occupancy */
INSERT INTO passengers VALUES (100, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (100, 100, 1, 100, 'ECO');   /* available seat */
DELETE FROM tickets
WHERE ticket_id = '100';
ROLLBACK;

/*
test tg_eco_seat_number_change
*/
INSERT INTO passengers VALUES (100, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (100, 100, 1, 100, 'ECO');   /* available seat */
UPDATE tickets
SET seat_number = 101
WHERE ticket_id = '100';
ROLLBACK;


/* test tg_add_business_seats_occupancy */
INSERT INTO passengers VALUES (200, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (200, 200, 1, 10, 'BUSINESS');   /* available seat */
INSERT INTO tickets VALUES (201, 200, 1, 10, 'BUSINESS');   /* seat no longer available*/
ROLLBACK;

/*
test tg_delete_business_seat_occupancy
*/
INSERT INTO passengers VALUES (200, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (200, 200, 1, 10, 'BUSINESS');   /* available seat */
DELETE FROM tickets
WHERE ticket_id = '200';
ROLLBACK;

/*
test tg_business_seat_number_change
*/
INSERT INTO passengers VALUES (200, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (200, 200, 1, 10, 'BUSINESS');   /* available seat */
UPDATE tickets
SET seat_number = 11
WHERE ticket_id = '200';
ROLLBACK;

/*
test th_check_seat_number
*/
-- checking seats max number
INSERT INTO tickets VALUES (1, 1, 1, 251, 'ECO');       /* too big value */
INSERT INTO tickets VALUES (1, 1, 1, 51, 'BUSINESS');   /* too big value */
-- checking seats min number
INSERT INTO tickets VALUES (1, 1, 1, 0, 'ECO');         /* to small value */
INSERT INTO tickets VALUES (1, 1, 1, -1, 'BUSINESS');   /* to small value */


/*
test tg_change_business_seat_to_eco
*/
INSERT INTO passengers VALUES (200, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (200, 200, 1, 10, 'BUSINESS');   /* available seat */
UPDATE tickets
SET seat_class = 'ECO'
WHERE ticket_id = '200';

DELETE FROM tickets
WHERE ticket_id = '200';
DELETE FROM passengers
WHERE person_id = '200';

/*
tg_change_eco_seat_to_business
*/
INSERT INTO passengers VALUES (200, 'Jan Karol', 'Chodkiewicz');
INSERT INTO tickets VALUES (200, 200, 1, 10, 'ECO');   /* available seat */
UPDATE tickets
SET seat_class = 'BUSINESS'
WHERE ticket_id = '200';

DELETE FROM tickets
WHERE ticket_id = '200';
DELETE FROM passengers
WHERE person_id = '200';

/*
test tg_delete_flight
*/
DELETE FROM flights
WHERE flight_id = '1';
ROLLBACK;

/*
test tg_delete_airport
*/
DELETE FROM airports where ICAO_CODE = 'EPWA';
ROLLBACK;

/*
test tg_delete_aircraft
*/
DELETE FROM aircrafts where aircraft_id = '1';
ROLLBACK;

/*
test tg_delete_crewmember
*/
INSERT INTO crewmembers VALUES ('1111', 'TEST', 'TEEST', 1);
UPDATE crewmembers
SET position_id = 2
WHERE person_id = '1111';
DELETE FROM crewmembers WHERE person_id = '1111';
ROLLBACK;

/*
test tg_delete_passengers
*/
INSERT INTO passengers VALUES ('1111', 'TEST', 'TEEST');
INSERT INTO tickets VALUES ('1111', '1111', '1', 5, 'BUSINESS');
DELETE FROM passengers WHERE person_id = '1111';
ROLLBACK;


/* TEST PROCEDURES */
/* test change_crewmember_position */
/* change to new and existing position */
exec change_crewmember_position('1', '3');
/* change to the same position */
exec change_crewmember_position('1', '3');
/* change to non-existing position - should raise and error and print message onto dbms output */
exec change_crewmember_position('1', '300');
/* change to not-existing crewmember - should raise and error and print message onto dbms output */
exec change_crewmember_position('1000', '3');
ROLLBACK;

/* test change_airport_name */
/* change to valid name */
exec change_airport_name('EPPO', 'Port Lotniczy Poznan-Lawica');
/* change to too short name - should raise and error and print message onto dbms output */
exec change_airport_name('EPPO', 'P');
/* change to too long name - should raise and error and print message onto dbms output */
exec change_airport_name('EPPO', '123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890');
/* try to change the name of not existing airport - should raise and error and print message onto dbms output */
exec change_airport_name('ABCD', 'Port Lotniczy Poznan-Lawica');
ROLLBACK;
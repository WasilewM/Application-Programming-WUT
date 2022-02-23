CREATE OR REPLACE FUNCTION get_new_positions_history_index
RETURN NUMBER
AS
    v_ph_id     positions_history.ph_id%TYPE;
BEGIN
    SELECT MAX(ph_id)
    INTO v_ph_id
    FROM positions_history;
    
    IF v_ph_id IS NOT NULL THEN
        v_ph_id := v_ph_id + 1;
    ELSE
        v_ph_id := 1;
    END IF;
    
    RETURN v_ph_id;
END get_new_positions_history_index;
/

CREATE OR REPLACE FUNCTION check_if_eco_seat_available(p_seat_number NUMBER, p_flight_id VARCHAR2)
RETURN BOOLEAN
AS
BEGIN
    FOR cr IN (
        SELECT *
        FROM occupied_eco_seats
    )
    LOOP
        IF (cr.flight_id = p_flight_id) AND (cr.seat_number = p_seat_number) THEN
            RETURN FALSE;
        END IF;
    END LOOP;
    
    RETURN TRUE;
END check_if_eco_seat_available;
/

CREATE OR REPLACE FUNCTION check_if_business_seat_available(p_seat_number NUMBER, p_flight_id VARCHAR2)
RETURN BOOLEAN
AS
BEGIN
    FOR cr IN (
        SELECT *
        FROM occupied_business_seats
    )
    LOOP
        IF (cr.flight_id = p_flight_id) AND (cr.seat_number = p_seat_number) THEN
            RETURN FALSE;
        END IF;
    END LOOP;
    
    RETURN TRUE;
END check_if_business_seat_available;
/
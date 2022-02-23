CREATE OR REPLACE PROCEDURE change_crewmember_position(p_id crewmembers.person_id%TYPE, p_new_position positions.position_id%TYPE)
AS
    v_new_position_name     positions.name%TYPE;
    v_old_position          crewmembers.position_id%TYPE;
BEGIN
    dbms_output.put_line('change_crewmember_position procedure');

    /* checking whether position with given id exists */
    SELECT name
    INTO v_new_position_name
    FROM positions
    WHERE position_id = p_new_position;
    
    /* checking whether crewmember with given id exists in the database */
    SELECT position_id
    INTO v_old_position
    FROM crewmembers
    WHERE person_id = p_id;
    
    /* update crewmember attribute */
    UPDATE crewmembers
    SET position_id = p_new_position
    WHERE person_id = p_id;
    dbms_output.put_line('Crewmember ' || p_id || ' has changed position from: ' || v_old_position || ' to: ' || p_new_position);

EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('Invalid data! Please check given parameters');
        RAISE_APPLICATION_ERROR(-20002, 'Invalid data! Please check given parameters');
    
END change_crewmember_position;
/


CREATE OR REPLACE PROCEDURE change_airport_name(p_icao_code airports.icao_code%TYPE, p_new_name airports.name%TYPE)
AS
    v_old_name  airports.name%TYPE;
BEGIN
    /* checking whether airport with given ICAO code exists in the database */
    SELECT name
    INTO v_old_name
    FROM airports
    WHERE icao_code = p_icao_code;

    /* checking new name validity */
    IF LENGTH(p_new_name) < 3 OR LENGTH(p_new_name) > 140 THEN
        dbms_output.put_line('Invalid name! Airport name length should be between 3 and 140 characters.');
        RAISE_APPLICATION_ERROR(-20003, 'Invalid name! Airport name length should be between 3 and 140 characters.');
    END IF;
    
    /* update name */
    UPDATE airports
    SET name = p_new_name
    WHERE icao_code = p_icao_code;
    dbms_output.put_line('Airport ' || p_icao_code || ' has changed name from: ' || v_old_name || ' to: ' || p_new_name);
    
EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('Invalid ICAO code - airport does not exist in the database. Please check given parameters');
        RAISE_APPLICATION_ERROR(-20004, 'Invalid ICAO code - airport does not exist in the database. Please check given parameters');  
    
END change_airport_name;
/
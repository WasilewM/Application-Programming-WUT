--------------------------------------------------------
--  DDL for Table TICKETS
--------------------------------------------------------

  CREATE TABLE "Z17"."TICKETS" 
   (	"TICKET_ID" VARCHAR2(40 CHAR), 
	"PASSENGER_ID" VARCHAR2(40 CHAR), 
	"FLIGHT_ID" VARCHAR2(40 CHAR), 
	"SEAT_NUMBER" NUMBER(3,0), 
	"SEAT_CLASS" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table AIRCRAFTS
--------------------------------------------------------

  CREATE TABLE "Z17"."AIRCRAFTS" 
   (	"AIRCRAFT_ID" VARCHAR2(40 CHAR), 
	"NAME" VARCHAR2(40 CHAR), 
	"BRAND" VARCHAR2(40 CHAR), 
	"MAX_ECO_SEATS" NUMBER(3,0), 
	"MAX_BUSINESS_SEATS" NUMBER(3,0), 
	"MODEL" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table SALGRADES
--------------------------------------------------------

  CREATE TABLE "Z17"."SALGRADES" 
   (	"SALGRADE_ID" NUMBER, 
	"MIN_SALARY" NUMBER, 
	"MAX_SALARY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table FLIGHTS
--------------------------------------------------------

  CREATE TABLE "Z17"."FLIGHTS" 
   (	"FLIGHT_ID" VARCHAR2(40 CHAR), 
	"ORIGIN_AIRPORT" VARCHAR2(40 CHAR), 
	"DESTINATION_AIRPORT" VARCHAR2(40 CHAR), 
	"DEPARTURE_TIME" DATE, 
	"ARRIVAL_TIME" DATE, 
	"AIRCRAFT_ID" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table POSITIONS
--------------------------------------------------------

  CREATE TABLE "Z17"."POSITIONS" 
   (	"POSITION_ID" NUMBER(2,0), 
	"NAME" VARCHAR2(40 CHAR), 
	"SALGRADE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table PASSENGERS
--------------------------------------------------------

  CREATE TABLE "Z17"."PASSENGERS" 
   (	"PERSON_ID" VARCHAR2(40 CHAR), 
	"FIRST_NAME" VARCHAR2(40 CHAR), 
	"LAST_NAME" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table POSITIONS_HISTORY
--------------------------------------------------------

  CREATE TABLE "Z17"."POSITIONS_HISTORY" 
   (	"PH_ID" NUMBER(4,0), 
	"EMPLOYEE_ID" VARCHAR2(40 CHAR), 
	"POSITION_ID" NUMBER(2,0), 
	"START_DATE" DATE, 
	"END_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table CREWMEMBERS
--------------------------------------------------------

  CREATE TABLE "Z17"."CREWMEMBERS" 
   (	"PERSON_ID" VARCHAR2(40 CHAR), 
	"FIRST_NAME" VARCHAR2(40 CHAR), 
	"LAST_NAME" VARCHAR2(40 CHAR), 
	"POSITION_ID" NUMBER(2,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table OCCUPIED_BUSINESS_SEATS
--------------------------------------------------------

  CREATE TABLE "Z17"."OCCUPIED_BUSINESS_SEATS" 
   (	"FLIGHT_ID" VARCHAR2(40 CHAR), 
	"SEAT_NUMBER" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table FLIGHTS_CREW
--------------------------------------------------------

  CREATE TABLE "Z17"."FLIGHTS_CREW" 
   (	"FLIGHT_ID" VARCHAR2(40 CHAR), 
	"CREWMEMBER_ID" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table AIRPORTS
--------------------------------------------------------

  CREATE TABLE "Z17"."AIRPORTS" 
   (	"IATA_CODE" VARCHAR2(3 CHAR), 
	"ICAO_CODE" VARCHAR2(4 CHAR), 
	"NAME" VARCHAR2(140 CHAR), 
	"CITY" VARCHAR2(40 CHAR), 
	"COUNTRY" VARCHAR2(40 CHAR), 
	"ADDRESS" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Table OCCUPIED_ECO_SEATS
--------------------------------------------------------

  CREATE TABLE "Z17"."OCCUPIED_ECO_SEATS" 
   (	"FLIGHT_ID" VARCHAR2(40 CHAR), 
	"SEAT_NUMBER" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 ROW STORE COMPRESS ADVANCED LOGGING
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00318201
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00318201" ON "Z17"."TICKETS" ("TICKET_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00318235
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00318235" ON "Z17"."AIRCRAFTS" ("AIRCRAFT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00358790
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00358790" ON "Z17"."SALGRADES" ("SALGRADE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00318251
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00318251" ON "Z17"."FLIGHTS" ("FLIGHT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00322437
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00322437" ON "Z17"."POSITIONS" ("POSITION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00318239
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00318239" ON "Z17"."PASSENGERS" ("PERSON_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00322443
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00322443" ON "Z17"."POSITIONS_HISTORY" ("PH_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00318244
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00318244" ON "Z17"."CREWMEMBERS" ("PERSON_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Index SYS_C00318271
--------------------------------------------------------

  CREATE UNIQUE INDEX "Z17"."SYS_C00318271" ON "Z17"."AIRPORTS" ("ICAO_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA" ;
--------------------------------------------------------
--  DDL for Trigger TG_DELETE_BUSINESS_SEAT_OCCUPANCY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_DELETE_BUSINESS_SEAT_OCCUPANCY" 
AFTER DELETE ON TICKETS
FOR EACH ROW
 WHEN (UPPER(old.seat_class) = 'BUSINESS') BEGIN
    DELETE FROM occupied_business_seats
    WHERE (flight_id = :old.flight_id) AND (seat_number = :old.seat_number);
END tg_delete_business_seat_occupancy;

/
ALTER TRIGGER "Z17"."TG_DELETE_BUSINESS_SEAT_OCCUPANCY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_DELETE_ECO_SEAT_OCCUPANCY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_DELETE_ECO_SEAT_OCCUPANCY" 
AFTER DELETE ON TICKETS
FOR EACH ROW
 WHEN (UPPER(old.seat_class) = 'ECO') BEGIN
    DELETE FROM occupied_eco_seats
    WHERE (flight_id = :old.flight_id) AND (seat_number = :old.seat_number);
END tg_delete_eco_seat_occupancy;

/
ALTER TRIGGER "Z17"."TG_DELETE_ECO_SEAT_OCCUPANCY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_CHANGE_BUSINESS_SEAT_TO_ECO
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_CHANGE_BUSINESS_SEAT_TO_ECO" 
AFTER UPDATE OF seat_class ON TICKETS
FOR EACH ROW
 WHEN (UPPER(old.seat_class) = 'BUSINESS' AND UPPER(new.seat_class) = 'ECO') DECLARE
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
ALTER TRIGGER "Z17"."TG_CHANGE_BUSINESS_SEAT_TO_ECO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_CHANGE_ECO_SEAT_TO_BUSINESS
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_CHANGE_ECO_SEAT_TO_BUSINESS" 
AFTER UPDATE OF seat_class ON TICKETS
FOR EACH ROW
 WHEN (UPPER(old.seat_class) = 'ECO' AND UPPER(new.seat_class) = 'BUSINESS') DECLARE
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
ALTER TRIGGER "Z17"."TG_CHANGE_ECO_SEAT_TO_BUSINESS" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_ADD_BUSINESS_SEATS_OCCUPANCY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_ADD_BUSINESS_SEATS_OCCUPANCY" 
AFTER INSERT ON TICKETS
FOR EACH ROW
 WHEN (UPPER(new.seat_class) LIKE 'BUSINESS') DECLARE
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
ALTER TRIGGER "Z17"."TG_ADD_BUSINESS_SEATS_OCCUPANCY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_ADD_ECO_SEATS_OCCUPANCY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_ADD_ECO_SEATS_OCCUPANCY" 
AFTER INSERT ON TICKETS
FOR EACH ROW
 WHEN (UPPER(new.seat_class) LIKE 'ECO') DECLARE
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
ALTER TRIGGER "Z17"."TG_ADD_ECO_SEATS_OCCUPANCY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_ECO_SEAT_NUMBER_CHANGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_ECO_SEAT_NUMBER_CHANGE" 
AFTER UPDATE OF seat_number ON TICKETS
FOR EACH ROW
 WHEN (UPPER(old.seat_class) = 'ECO' AND UPPER(new.seat_class) = 'ECO' AND new.seat_number <> old.seat_number) DECLARE
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
ALTER TRIGGER "Z17"."TG_ECO_SEAT_NUMBER_CHANGE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_BUSINESS_SEAT_NUMBER_CHANGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_BUSINESS_SEAT_NUMBER_CHANGE" 
AFTER UPDATE OF seat_number ON TICKETS
FOR EACH ROW
 WHEN ((UPPER(old.seat_class) = 'BUSINESS') AND (UPPER(new.seat_class) = 'BUSINESS') AND (new.seat_number <> old.seat_number)) DECLARE
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
ALTER TRIGGER "Z17"."TG_BUSINESS_SEAT_NUMBER_CHANGE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TH_CHECK_SEAT_NUMBER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TH_CHECK_SEAT_NUMBER" 
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
ALTER TRIGGER "Z17"."TH_CHECK_SEAT_NUMBER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_DELETE_AIRCRAFT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_DELETE_AIRCRAFT" 
BEFORE DELETE ON aircrafts
FOR EACH ROW
DECLARE
BEGIN
    DELETE FROM flights
    WHERE aircraft_id = :old.aircraft_id;
END tg_delete_aircraft;

/
ALTER TRIGGER "Z17"."TG_DELETE_AIRCRAFT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_DELETE_FLIGHT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_DELETE_FLIGHT" 
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
ALTER TRIGGER "Z17"."TG_DELETE_FLIGHT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_CREW_POSITIONS_HISTORY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_CREW_POSITIONS_HISTORY" 
AFTER UPDATE OF position_id ON crewmembers
FOR EACH ROW
 WHEN (new.position_id != old.position_id) DECLARE
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
ALTER TRIGGER "Z17"."TG_CREW_POSITIONS_HISTORY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TG_DELETE_AIRPORT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "Z17"."TG_DELETE_AIRPORT" 
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
ALTER TRIGGER "Z17"."TG_DELETE_AIRPORT" ENABLE;
--------------------------------------------------------
--  Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "Z17"."TICKETS" MODIFY ("TICKET_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."TICKETS" MODIFY ("PASSENGER_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."TICKETS" MODIFY ("FLIGHT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."TICKETS" MODIFY ("SEAT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "Z17"."TICKETS" ADD PRIMARY KEY ("TICKET_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
  ALTER TABLE "Z17"."TICKETS" MODIFY ("SEAT_CLASS" NOT NULL ENABLE);
  ALTER TABLE "Z17"."TICKETS" ADD CONSTRAINT "TICKETS_TYPES" CHECK (seat_class LIKE 'ECO' OR seat_class LIKE 'BUSINESS') ENABLE;
--------------------------------------------------------
--  Constraints for Table AIRCRAFTS
--------------------------------------------------------

  ALTER TABLE "Z17"."AIRCRAFTS" MODIFY ("AIRCRAFT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRCRAFTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRCRAFTS" MODIFY ("BRAND" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRCRAFTS" MODIFY ("MAX_ECO_SEATS" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRCRAFTS" MODIFY ("MAX_BUSINESS_SEATS" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRCRAFTS" MODIFY ("MODEL" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRCRAFTS" ADD PRIMARY KEY ("AIRCRAFT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SALGRADES
--------------------------------------------------------

  ALTER TABLE "Z17"."SALGRADES" ADD CONSTRAINT "CHECK_SALARY_FORKS" CHECK (min_salary < max_salary) ENABLE;
  ALTER TABLE "Z17"."SALGRADES" MODIFY ("SALGRADE_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."SALGRADES" MODIFY ("MIN_SALARY" NOT NULL ENABLE);
  ALTER TABLE "Z17"."SALGRADES" MODIFY ("MAX_SALARY" NOT NULL ENABLE);
  ALTER TABLE "Z17"."SALGRADES" ADD PRIMARY KEY ("SALGRADE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table FLIGHTS
--------------------------------------------------------

  ALTER TABLE "Z17"."FLIGHTS" ADD CONSTRAINT "FLIGHT_TIME" CHECK (departure_time < arrival_time) ENABLE;
  ALTER TABLE "Z17"."FLIGHTS" MODIFY ("FLIGHT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS" MODIFY ("ORIGIN_AIRPORT" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS" MODIFY ("DESTINATION_AIRPORT" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS" MODIFY ("DEPARTURE_TIME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS" MODIFY ("ARRIVAL_TIME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS" MODIFY ("AIRCRAFT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS" ADD PRIMARY KEY ("FLIGHT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table POSITIONS
--------------------------------------------------------

  ALTER TABLE "Z17"."POSITIONS" MODIFY ("POSITION_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."POSITIONS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."POSITIONS" ADD PRIMARY KEY ("POSITION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PASSENGERS
--------------------------------------------------------

  ALTER TABLE "Z17"."PASSENGERS" MODIFY ("PERSON_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."PASSENGERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."PASSENGERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."PASSENGERS" ADD PRIMARY KEY ("PERSON_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table POSITIONS_HISTORY
--------------------------------------------------------

  ALTER TABLE "Z17"."POSITIONS_HISTORY" MODIFY ("PH_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."POSITIONS_HISTORY" MODIFY ("EMPLOYEE_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."POSITIONS_HISTORY" MODIFY ("POSITION_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."POSITIONS_HISTORY" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "Z17"."POSITIONS_HISTORY" ADD PRIMARY KEY ("PH_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CREWMEMBERS
--------------------------------------------------------

  ALTER TABLE "Z17"."CREWMEMBERS" MODIFY ("PERSON_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."CREWMEMBERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."CREWMEMBERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."CREWMEMBERS" ADD PRIMARY KEY ("PERSON_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
  ALTER TABLE "Z17"."CREWMEMBERS" MODIFY ("POSITION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OCCUPIED_BUSINESS_SEATS
--------------------------------------------------------

  ALTER TABLE "Z17"."OCCUPIED_BUSINESS_SEATS" MODIFY ("FLIGHT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."OCCUPIED_BUSINESS_SEATS" MODIFY ("SEAT_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FLIGHTS_CREW
--------------------------------------------------------

  ALTER TABLE "Z17"."FLIGHTS_CREW" MODIFY ("FLIGHT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."FLIGHTS_CREW" MODIFY ("CREWMEMBER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AIRPORTS
--------------------------------------------------------

  ALTER TABLE "Z17"."AIRPORTS" MODIFY ("IATA_CODE" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRPORTS" MODIFY ("ICAO_CODE" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRPORTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRPORTS" MODIFY ("CITY" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRPORTS" MODIFY ("COUNTRY" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRPORTS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "Z17"."AIRPORTS" ADD PRIMARY KEY ("ICAO_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 16384 NEXT 16384 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "II_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table OCCUPIED_ECO_SEATS
--------------------------------------------------------

  ALTER TABLE "Z17"."OCCUPIED_ECO_SEATS" MODIFY ("FLIGHT_ID" NOT NULL ENABLE);
  ALTER TABLE "Z17"."OCCUPIED_ECO_SEATS" MODIFY ("SEAT_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "Z17"."TICKETS" ADD CONSTRAINT "TICKETS_FLIGHTS_FK" FOREIGN KEY ("FLIGHT_ID")
	  REFERENCES "Z17"."FLIGHTS" ("FLIGHT_ID") ENABLE;
  ALTER TABLE "Z17"."TICKETS" ADD CONSTRAINT "TICKETS_PASSENGERS_FK" FOREIGN KEY ("PASSENGER_ID")
	  REFERENCES "Z17"."PASSENGERS" ("PERSON_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FLIGHTS
--------------------------------------------------------

  ALTER TABLE "Z17"."FLIGHTS" ADD CONSTRAINT "DESTINATION_AIRPORTS_FK" FOREIGN KEY ("DESTINATION_AIRPORT")
	  REFERENCES "Z17"."AIRPORTS" ("ICAO_CODE") ENABLE;
  ALTER TABLE "Z17"."FLIGHTS" ADD CONSTRAINT "FLIGHTS_AIRCRAFTS_FK" FOREIGN KEY ("AIRCRAFT_ID")
	  REFERENCES "Z17"."AIRCRAFTS" ("AIRCRAFT_ID") ENABLE;
  ALTER TABLE "Z17"."FLIGHTS" ADD CONSTRAINT "ORIGIN_AIRPORTS_FK" FOREIGN KEY ("ORIGIN_AIRPORT")
	  REFERENCES "Z17"."AIRPORTS" ("ICAO_CODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table POSITIONS
--------------------------------------------------------

  ALTER TABLE "Z17"."POSITIONS" ADD CONSTRAINT "POSTIONS_SALGRADES_FK" FOREIGN KEY ("SALGRADE")
	  REFERENCES "Z17"."SALGRADES" ("SALGRADE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table POSITIONS_HISTORY
--------------------------------------------------------

  ALTER TABLE "Z17"."POSITIONS_HISTORY" ADD CONSTRAINT "PH_CREWMEMBERS_FK" FOREIGN KEY ("EMPLOYEE_ID")
	  REFERENCES "Z17"."CREWMEMBERS" ("PERSON_ID") ENABLE;
  ALTER TABLE "Z17"."POSITIONS_HISTORY" ADD CONSTRAINT "PH_POSITIONS_FK" FOREIGN KEY ("POSITION_ID")
	  REFERENCES "Z17"."POSITIONS" ("POSITION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CREWMEMBERS
--------------------------------------------------------

  ALTER TABLE "Z17"."CREWMEMBERS" ADD CONSTRAINT "CREWMEMBERS_POSITIONS_FK" FOREIGN KEY ("POSITION_ID")
	  REFERENCES "Z17"."POSITIONS" ("POSITION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OCCUPIED_BUSINESS_SEATS
--------------------------------------------------------

  ALTER TABLE "Z17"."OCCUPIED_BUSINESS_SEATS" ADD CONSTRAINT "BUSINESS_SEATS_FLIGHTS_FK" FOREIGN KEY ("FLIGHT_ID")
	  REFERENCES "Z17"."FLIGHTS" ("FLIGHT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FLIGHTS_CREW
--------------------------------------------------------

  ALTER TABLE "Z17"."FLIGHTS_CREW" ADD CONSTRAINT "CREMEMBERS_FK" FOREIGN KEY ("CREWMEMBER_ID")
	  REFERENCES "Z17"."CREWMEMBERS" ("PERSON_ID") ENABLE;
  ALTER TABLE "Z17"."FLIGHTS_CREW" ADD CONSTRAINT "FLIGHTS_FK" FOREIGN KEY ("FLIGHT_ID")
	  REFERENCES "Z17"."FLIGHTS" ("FLIGHT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OCCUPIED_ECO_SEATS
--------------------------------------------------------

  ALTER TABLE "Z17"."OCCUPIED_ECO_SEATS" ADD CONSTRAINT "ECO_SEATS_FLIGHTS_FK" FOREIGN KEY ("FLIGHT_ID")
	  REFERENCES "Z17"."FLIGHTS" ("FLIGHT_ID") ENABLE;

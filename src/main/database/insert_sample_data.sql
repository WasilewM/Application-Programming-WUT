--DELETE FROM aircrafts;
--DELETE FROM airports;
--DELETE FROM positions_history;
--DELETE FROM crewmembers;
--DELETE FROM flights;
--DELETE FROM flights_crew;
--DELETE FROM occupied_business_seats;
--DELETE FROM occupied_eco_seats;
--DELETE FROM passengers;
--DELETE FROM positions;
--DELETE FROM tickets;
--COMMIT;


INSERT INTO airports VALUES ('POZ', 'EPPO', 'Lotnisko Poznan-Lawica', 'Poznan', 'Poland', 'Bukowska 285, 60-189');
INSERT INTO airports VALUES ('WAW', 'EPWA', 'Lotnisko Chopina w Wasrszawie', 'Warszawa', 'Poland', 'Zwirki i Wigury, 00-001');
COMMIT;

INSERT INTO positions VALUES (1, 'captain');
INSERT INTO positions VALUES (2, 'second pilot');
INSERT INTO positions VALUES (3, 'technician');
COMMIT;

INSERT INTO crewmembers VALUES (1, 'Jan', 'Kowalski', 1);
UPDATE crewmembers
SET position_id = 2
WHERE person_id = '1';
COMMIT;

INSERT INTO passengers VALUES (1, 'Jan', 'Chodkiewicz');
INSERT INTO passengers VALUES (2, 'Stefan', 'Zolkiewski');
INSERT INTO passengers VALUES (3, 'Jan', 'Zamoyski');
INSERT INTO passengers VALUES (4, 'Stefan', 'Batory');
COMMIT;

INSERT INTO aircrafts VALUES (1, 'Dreamliner 1', 'PLL LOT', 250, 50, 'Boeing 787-9 Dreamliner');
COMMIT;

INSERT INTO flights VALUES (1, 'EPPO', 'EPWA', SYSDATE -1, SYSDATE, 1);
COMMIT;

INSERT INTO tickets VALUES (1, 1, 1, 1, 'ECO');
INSERT INTO tickets VALUES (2, 2, 1, 1, 'BUSINESS');
INSERT INTO tickets VALUES (3, 3, 1, 2, 'BUSINESS');
INSERT INTO tickets VALUES (4, 4, 1, 2, 'ECO');
COMMIT;

UPDATE tickets
SET seat_number = 2
WHERE ticket_id = 4;
ROLLBACK;

INSERT INTO salgrades VALUES (1, 3000, 4500);
INSERT INTO salgrades VALUES (2, 4500, 7000);
COMMIT;

/* exemplary SELECT statements */
/* get all passengers with the number of their tickets */
SELECT p.first_name, p.last_name, COUNT(t.ticket_id)
FROM passengers p
    LEFT JOIN tickets t ON (p.person_id = t.passenger_id)
GROUP BY p.person_id, p.first_name, p.last_name;

/* get ids of passenger that have a ticket*/
SELECT p.person_id
FROM passengers p
    INNER JOIN tickets t ON (p.person_id = t.passenger_id)
GROUP BY p.person_id;

/* get all passengers with the information about their flights - including aircrafts names */
SELECT p.first_name, p.last_name, f.flight_id, f.origin_airport, f.destination_airport, a.name AS aircraft_name
FROM passengers p
    LEFT JOIN tickets t ON (p.person_id = t.passenger_id)
    LEFT JOIN flights f ON (t.flight_id = f.flight_id)
    LEFT JOIN aircrafts a ON (f.aircraft_id = a.aircraft_id)
ORDER BY f.flight_id NULLS LAST, p.first_name, p.last_name;
    
/* get only passengers that have a ticket. ensure there is information about their flights with the information about their flights - including aircrafts names */
SELECT p.first_name, p.last_name, f.flight_id, f.origin_airport, f.destination_airport, a.name AS aircraft_name
FROM passengers p
    INNER JOIN tickets t ON (p.person_id = t.passenger_id)
    INNER JOIN flights f ON (t.flight_id = f.flight_id)
    INNER JOIN aircrafts a ON (f.aircraft_id = a.aircraft_id)
ORDER BY f.flight_id NULLS LAST, p.first_name, p.last_name;

/* get airports that currently do not have any flights - they are not an origin nor destination of any flight */
SELECT a.*
FROM airports a
MINUS
SELECT a.*
FROM airports a
    INNER JOIN flights f ON (f.origin_airport = a.icao_code)
MINUS
SELECT a.*
FROM airports a
    INNER JOIN flights f ON (f.destination_airport = a.icao_code);
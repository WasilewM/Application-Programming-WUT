package com.onibmagairlines.classes;

import java.util.ArrayList;

public class DetailsHTMLGen {
    public static String getFlightCSS() {
        return """
                	.container {
                		font-family: Cambria, "Hoefler Text", "Liberation Serif", Times, "Times New Roman", "serif";
                		background-color: #B4BCBD;
                		border: 1px solid;
                		-webkit-box-shadow: 8px 8px 10px 0px rgba(66, 68, 90, 1);
                		-moz-box-shadow: 8px 8px 10px 0px rgba(66, 68, 90, 1);
                		box-shadow: 8px 8px 10px 0px rgba(66, 68, 90, 1);
                		-webkit-border-radius: 12px;
                		-moz-border-radius: 12px;
                		border-radius: 12px;
                		padding: 10px 10px 0px 10px;
                		width: fit-content;
                        margin-top: 15px;
                	}
                	.ticket {
                		
                	}
                	.entry {
                /*		border: 1px solid;*/
                		background-color: #CFCFCF;
                		border-radius: 10px;
                		-webkit-box-shadow: 8px 8px 24px -16px rgba(66, 68, 90, 1);
                		-moz-box-shadow: 8px 8px 24px -16px rgba(66, 68, 90, 1);
                		box-shadow: 8px 8px 24px -16px rgba(66, 68, 90, 1);
                		margin-bottom: 10px;
                	}
                	.name {
                		position: absolute;
                		padding-left: 6px;
                		padding-top: 3px;
                		color: #515151
                	}
                	.value {
                		text-align: right;
                		font-size: 18px;
                		padding: 15px 7px 5px 10px;
                	}
                	.title {
                		font-size: 23px;
                		text-align: center;
                		margin-bottom: 10px;
                		font-family: "Arial Narrow", Arial, sans-serif;
                	}""";
    }
    public static String generateOneFlightHTML(Flight flight, boolean showOccupiedSeatsAndCrewmembers) {
        var data = flight.getFlightData();
        String arrival_time = data.get(1).toString();
        String departure_time = data.get(2).toString();
        String html = "<div class=\"container\">" +
                "<div class=\"title\">Flight information</div>" +
                "<div class=\"entry\" style=\"width: 140px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Flight ID</div>" +
                "<div class=\"value\">" + data.get(0) + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 200px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Plane name</div>" +
                "<div class=\"value\">" + data.get(9) + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 130px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Brand</div>" +
                "<div class=\"value\">" + data.get(10) + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"overflow: hidden;\">" +
                "<div class=\"name\">Model</div>" +
                "<div class=\"value\">" + data.get(11) + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 740px;\">" +
                "<div class=\"name\">From</div>" +
                "<div class=\"value\">" + data.get(8) + " (" + data.get(6) + ")<br>" + data.get(7) + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 740px;\">" +
                "<div class=\"name\">To</div>" +
                "<div class=\"value\">" + data.get(5) + " (" + data.get(3) + ")<br>" + data.get(4) + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 390px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Departure time</div>" +
                "<div class=\"value\">" + departure_time.substring(0, departure_time.length() - 5) + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"overflow: hidden;\">" +
                "<div class=\"name\">Arrival time</div>" +
                "<div class=\"value\">" + arrival_time.substring(0, arrival_time.length() - 5) + "</div>" +
                "</div>";

        if (showOccupiedSeatsAndCrewmembers) {
            var occupiedEcoSeats = flight.getOccupiedEcoSeats();
            var getOccupiedBusinessSeats = flight.getOccupiedBusinessSeats();
            if (occupiedEcoSeats.isEmpty())
                occupiedEcoSeats = "All seats are free";
            if (getOccupiedBusinessSeats.isEmpty())
                getOccupiedBusinessSeats = "All seats are free";

            html += "<div class=\"title\">Seats</div>" +
                    "<div class=\"entry\" style=\"width: 740px;\">" +
                    "<div class=\"name\">Occupied eco seats</div>" +
                    "<div class=\"value\">" + occupiedEcoSeats + "</div></div>" +
                    "<div class=\"entry\" style=\"width: 740px;\">" +
                    "<div class=\"name\">Occupied business seats</div>" +
                    "<div class=\"value\">" + getOccupiedBusinessSeats + "</div></div>";
            html += "<div class=\"title\">Crewmembers</div>";

            ArrayList<String> captain = new ArrayList<>();
            captain.add(flight.getCaptainID());
            var captain_data = Flight.getCrewmembersInfo(captain);
            if (!captain_data.isEmpty()) {
                html += "<div class=\"entry\" style=\"width: 550px; float: left; margin-right: 10px;\">" +
                        "<div class=\"name\">Full name</div>" +
                        "<div class=\"value\">" + captain_data.get(0).get(0) + " " + captain_data.get(0).get(1) + "</div>" +
                        "</div>" +
                        "<div class=\"entry\" style=\"overflow: hidden;\">" +
                        "<div class=\"name\">Position</div>" +
                        "<div class=\"value\">captain</div>" +
                        "</div>";
            }
            ArrayList<String> firstOfficer = new ArrayList<>();
            firstOfficer.add(flight.getFirstOfficerID());
            var firstOfficer_data = Flight.getCrewmembersInfo(firstOfficer);
            if (!firstOfficer_data.isEmpty()) {
                html += "<div class=\"entry\" style=\"width: 550px; float: left; margin-right: 10px;\">" +
                        "<div class=\"name\">Full name</div>" +
                        "<div class=\"value\">" + firstOfficer_data.get(0).get(0) + " " + firstOfficer_data.get(0).get(1) + "</div>" +
                        "</div>" +
                        "<div class=\"entry\" style=\"overflow: hidden;\">" +
                        "<div class=\"name\">Position</div>" +
                        "<div class=\"value\">first officer</div>" +
                        "</div>";
            }

            var stewards = Flight.getCrewmembersInfo(flight.getStewardsIds());
            for (var steward : stewards) {
                html += "<div class=\"entry\" style=\"width: 550px; float: left; margin-right: 10px;\">" +
                        "<div class=\"name\">Full name</div>" +
                        "<div class=\"value\">" + steward.get(0) + " " + steward.get(1) + "</div>" +
                        "</div>" +
                        "<div class=\"entry\" style=\"overflow: hidden;\">" +
                        "<div class=\"name\">Position</div>" +
                        "<div class=\"value\">steward</div>" +
                        "</div>";
            }
            var technicians = Flight.getCrewmembersInfo(flight.getTechniciansIds());
            for (var technician : technicians) {
                html += "<div class=\"entry\" style=\"width: 550px; float: left; margin-right: 10px;\">" +
                        "<div class=\"name\">Full name</div>" +
                        "<div class=\"value\">" + technician.get(0) + " " + technician.get(1) + "</div>" +
                        "</div>" +
                        "<div class=\"entry\" style=\"overflow: hidden;\">" +
                        "<div class=\"name\">Position</div>" +
                        "<div class=\"value\">technician</div>" +
                        "</div>";
            }
        }
        html += "</div>";

//        html += "<div class=\"entry\" style=\"width: 550px; float: left; margin-right: 10px;\">" +
//                "<div class=\"name\">Full name</div>" +
//                "<div class=\"value\">Radosław Bąk</div>" +
//                "</div>" +
//                "<div class=\"entry\" style=\"overflow: hidden;\">" +
//                "<div class=\"name\">Position</div>" +
//                "<div class=\"value\">steward</div>" +
//                "</div>" +
//                "<div class=\"entry\" style=\"width: 550px; float: left; margin-right: 10px;\">" +
//                "<div class=\"name\">Full name</div>" +
//                "<div class=\"value\">Radosław Bąk</div>" +
//                "</div>" +
//                "<div class=\"entry\" style=\"overflow: hidden;\">" +
//                "<div class=\"name\">Position</div>" +
//                "<div class=\"value\">steward</div>" +
//                "</div>" +
//                "</div>";
        return html;
    }
    public static String generateFlightHTML(Flight flight){
        return "<!doctype html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                "<title>abc</title>" +
                "<style>" + getFlightCSS() +
                "</style>" +
                "</head>" +
                "" +
                "<body>" +
                generateOneFlightHTML(flight, true) +
                "</body>" +
                "</html>";
    }
//    public static String generateAirportHTML(Airport airport) {
//        return  "<table>" +
//                "<tbody>" +
//                "  <tr>" +
//                "    <td>Name</td>" +
//                "    <td>" + airport.getName() + "</td>" +
//                "  </tr>" +
//                "  <tr>" +
//                "    <td>IATACode</td>" +
//                "    <td>" + airport.getIATACode() + "</td>" +
//                "  </tr>" +
//                "  <tr>" +
//                "    <td>ICAOCode</td>" +
//                "    <td>" + airport.getICAOCode() + "</td>" +
//                "  </tr>" +
//                "  <tr>" +
//                "    <td>City</td>" +
//                "    <td>" + airport.getCity() + "</td>" +
//                "  </tr>" +
//                "  <tr>" +
//                "    <td>Country</td>" +
//                "    <td>" + airport.getCountry() + "</td>" +
//                "  </tr>" +
//                "  <tr>" +
//                "    <td>Address</td>" +
//                "    <td>" + airport.getAddress() + "</td>" +
//                "  </tr>" +
//                "</tbody>" +
//                "</table>";
//    }
    public static String generateAirportHTML(Airport airport){
        StringBuilder html = new StringBuilder("<!doctype html><html><head><meta charset=\"utf-8\"><style>" +
                getFlightCSS() +
                "</style></head><body>" +
                "<div class=\"container\">" +
                "<div class=\"title\">Airport information</div>" +
                "<div class=\"entry\" style=\"width: 540px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Airport name</div>" +
                "<div class=\"value\">" + airport.getName() + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 190px; overflow: hidden;\">" +
                "<div class=\"name\">Country</div>" +
                "<div class=\"value\">" + airport.getCountry() + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 140px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">ICAO Code</div>" +
                "<div class=\"value\">" + airport.getICAOCode() + "</div>" +
                "" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 140px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">IATA Code</div>" +
                "<div class=\"value\">" + airport.getIATACode() + "</div>" +
                "" +
                "</div>" +
                "" +
                "<div class=\"entry\" style=\"overflow: hidden;\">" +
                "<div class=\"name\">Address</div>" +
                "<div class=\"value\">" + airport.getAddress() + "</div>" +
                "" +
                "</div>" +
                "" +
                "</div>" +
                "<br><div style=\"font-size: 22px; text-align: center;\">Arrivals</div>");
        var flights = airport.getArrivals();
        for (var flight : flights) {
            html.append(generateOneFlightHTML(flight, false));
        }
        if (flights.isEmpty()) {
            html.append("There are currently no scheduled arrivals.<br>");
        }
        html.append("<div style=\"font-size: 22px; text-align: center;\"><br>Departures</div>");
        flights = airport.getDepartures();
        for (var flight : flights) {
            html.append(generateOneFlightHTML(flight, false));
        }
        if (flights.isEmpty()) {
            html.append("There are currently no scheduled departures.");
        }
        html.append("</body></html>");
        return html.toString();
    }
    public static String generateAircraftHTML(Aircraft aircraft){
        StringBuilder html = new StringBuilder("<!doctype html><html><head><meta charset=\"utf-8\"><style>" +
                getFlightCSS() +
                "</style></head><body>");
        html.append("<div style=\"font-family: Arial, Helvetica, sans-serif; font-size: 25px\">").append(aircraft.getAircraftBrand()).append(" ").append(aircraft.getAircraftModel()).append(" - ").append(aircraft.getAircraftName()).append("</div><br>").append("<div style=\"font-size: 20px\">").append("Aircraft's flights").append("</div>");
        var flights = aircraft.getFlights();
        for (var flight : flights) {
            html.append(generateOneFlightHTML(flight, false));
        }
        if (flights.isEmpty()) {
            html.append("An aircraft is not assigned to any flight.");
        }
        html.append("</body></html>");
        return html.toString();
    }

    public static String generateCrewmemberHTML(Crewmember crewmember){
        StringBuilder html = new StringBuilder("<!doctype html><html><head><meta charset=\"utf-8\"><style>" +
                getFlightCSS() +
                "</style></head><body>");
        html.append("<div style=\"font-family: Arial, Helvetica, sans-serif; font-size: 25px\">").append(crewmember.getFirstName()).append(" ").append(crewmember.getLastName()).append(" - ").append(Utils.getPositionsMap().get(crewmember.roleInt)).append("</div>").append("<br>").append("<div style=\"font-size: 20px\">").append("Crewmember's flights").append("</div>");
        var flights = crewmember.getFlights();
        for (var flight : flights) {
            html.append(generateOneFlightHTML(flight, false));
        }
        if (flights.isEmpty()) {
            html.append("A crew member is not assigned to any flight.");
        }
        html.append("</body></html>");
        return html.toString();
    }

    public static String generatePassengerHTML(Passenger passenger){
        StringBuilder html = new StringBuilder("<!doctype html><html><head><meta charset=\"utf-8\"><style>" +
                getTicketCSS() +
                "</style></head><body>");
        html.append("<div style=\"font-family: Arial, Helvetica, sans-serif; font-size: 25px\">").append(passenger.getFirstName()).append(" ").append(passenger.getLastName()).append("</div>").append("<br>").append("<div style=\"font-size: 20px\">").append("Passenger's boarding passes").append("</div>");
        for (var ticket : passenger.getTicketList())
            html.append(generateOneTicketHTML(ticket));
        html.append("</body></html>");
        return html.toString();
    }
    public static String getTicketCSS() {
        return ".container {" +
                "font-family: Cambria, \"Hoefler Text\", \"Liberation Serif\", Times, \"Times New Roman\", \"serif\";" +
                "background-color: #93CF4F;" +
                "border: 1px solid;" +
                "-webkit-box-shadow: 8px 8px 10px 0px rgba(66, 68, 90, 1);" +
                "-moz-box-shadow: 8px 8px 10px 0px rgba(66, 68, 90, 1);" +
                "box-shadow: 8px 8px 10px 0px rgba(66, 68, 90, 1);" +
                "-webkit-border-radius: 12px;" +
                "-moz-border-radius: 12px;" +
                "border-radius: 12px;" +
                "padding: 10px 10px 0px 10px;" +
                "width: fit-content;" +
                "height: 265px;" +
                "margin-top: 15px" +
                "}" +
                ".ticket {" +
                "" +
                "}" +
                ".entry {" +
                "/*border: 1px solid;*/" +
                "background-color: #E4FBDC;" +
                "border-radius: 10px;" +
                "-webkit-box-shadow: 8px 8px 24px -16px rgba(66, 68, 90, 1);" +
                "-moz-box-shadow: 8px 8px 24px -16px rgba(66, 68, 90, 1);" +
                "box-shadow: 8px 8px 24px -16px rgba(66, 68, 90, 1);" +
                "margin-bottom: 10px;" +
                "}" +
                ".name {" +
                "position: absolute;" +
                "padding-left: 6px;" +
                "padding-top: 3px;" +
                "color: #515151" +
                "}" +
                ".value {" +
                "text-align: right;" +
                "font-size: 18px;" +
                "padding: 15px 7px 5px 10px;" +
                "}" +
                ".title {" +
                "font-size: 23px;" +
                "text-align: center;" +
                "margin-bottom: 10px;" +
                "font-family: \"Arial Narrow\", Arial, sans-serif;" +
                "}";
    }
    public static String generateOneTicketHTML(Ticket ticket) {
        var data = ticket.getTicketData();
        String arrival_time = data.get(1).toString();
        String departure_time = data.get(2).toString();

        return "<div class=\"container\">" +
                "<div class=\"title\">Boarding pass</div>" +
                "<div class=\"entry\" style=\"width: 740px;\">" +
                "<div class=\"name\">Passenger Name</div>" +
                "<div class=\"value\">" + data.get(14) + " " + data.get(15) + " </div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 355px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">From</div>" +
                "<div class=\"value\">" + data.get(8) + " (" + data.get(6) + ")</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 375px; overflow: hidden;\">" +
                "<div class=\"name\">Departure time</div>" +
                "<div class=\"value\">" + departure_time.substring(0, departure_time.length() - 5) + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 355px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">To</div>" +
                "<div class=\"value\">" + data.get(5) + " (" + data.get(3) + ")</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 375px; overflow: hidden;\">" +
                "<div class=\"name\">Arrival time</div>" +
                "<div class=\"value\">" + arrival_time.substring(0, arrival_time.length() - 5) + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 250px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Plane</div>" +
                "<div class=\"value\"><br>" + data.get(10) + " " + data.get(11) + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 100px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Flight ID</div>" +
                "<div class=\"value\"><br>" + data.get(0) + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"width: 120px; float: left; margin-right: 10px;\">" +
                "<div class=\"name\">Seat number</div>" +
                "<div class=\"value\"><br>" + data.get(12) + "</div>" +
                "</div>" +
                "<div class=\"entry\" style=\"overflow: hidden;\">" +
                "<div class=\"name\">Seat class</div>" +
                "<div class=\"value\"><br>" + data.get(13) + "</div>" +
                "" +
                "</div>" +
                "" +
                "</div>";
    }
    public static String generateTicketHTML(Ticket ticket){
        return "<!doctype html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                "<style>" +
                getTicketCSS() +
                "</style>" +
                "</head>" +
                "" +
                "<body>" +
                generateOneTicketHTML(ticket) +
                "</body>" +
                "</html>";
    }
}

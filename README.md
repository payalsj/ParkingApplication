# ParkingApplication
About Project:

The Parking Application is designed to facilitate efficient parking space utilization, entry/exit tracking, and overall management of a parking facility. It will generate a ticket based on that ticket you will be assigned a spot to park your car.

Endpoints: The Parking Application offers the following endpoints:-

To generate ticket for parking:
-EndPoint= "http://localhost:8080/tickets"
-Description: This Api returns a ticket number and we can park the car at given place and at the same time it will add the registration number and entry time of car in audit table.
-HTTP Method: POST

To unpark the car:
-EndPoint= "http://localhost:8080/unpark/{registrationNumber}"
-Description: This Api will remove a car from parking and at the same time it will also add the exit time of car in audit table.
-HTTP Method: GET

To get TicketNumber By car RegistartinNumber:
-EndPoint= "http://localhost:8080/tickets/{registratonNumber}"
-Description: This Api will return Ticket number in which a car with a given registration number is placed.
-HTTP Method: GET

To get list of Ticket Numbers for particualr car color:
-EndPoint= "http://localhost:8080/tickets/color/{color}"
-Description:This Api will return List of Ticket numbers of all tickets where a car of a particular color is placed.
-HTTP Method: GET

To get registartion numbers of cara by Color:
-EndPoint= "http://localhost:8080/cars/{color}"
-Description:This Api returns registration numbers of all cars of a particular Color.
-HTTP Method: GET


For API Documentation refer this swagger link :- http://localhost:8080/swagger-ui.html



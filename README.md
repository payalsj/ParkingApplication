# ParkingApplication
About Project:

The Parking Application is designed to facilitate efficient parking space utilization, entry/exit tracking, and overall management of a parking facility. It will generate a ticket based on that ticket you will be assigned a spot to to park your car.

Endpoints: The Parking Application offers the following endpoints:-

To generate ticket for parking:
-EndPoint= "http://localhost:8080/tickets"
-Description: This Api returns a ticket number and we can park the car at given place and at the same time it will add the registration number and entry time of car in audit table.
-HTTP Method: POST


To unpark the car:
-EndPoint= "http://localhost:8080/unpark/{registrationNumber}"
-Description: This Api will remove a car from parking and at the same time it will also add the exit time of car in audit table.
-HTTP Method: GET

For API Documentation refer this swagger link :- http://localhost:8081/swagger-ui.html

**NOTE:- Please use Postman for API testing & pass the headers mentioned above for authentication.

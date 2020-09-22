PRACTICAL EXERCISE

Write a program to design Vending Machine using your 'favourite language' with all possible tests
Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
	Prompt shall show if any other denomination is used
Allow user to select products Coke(25), Pepsi(35), Soda(45)
	Options provided on home screen with price and an exit option
Allow user to take refund by cancelling the request.
	On final screen there is a Confirmation. User can opt to Cancel order and get full refund
Return selected product and remaining change if any.
	On confirming final product the program ends with the details of the change the user shall get.
Allow reset operation for vending machine supplier.
	Sorry, I am not sure on this.

The code has been written using Eclipse Version: 2020-09 (4.17.0), JDK 1.8 and run from the IDE itself.

It can be compiled and run from command prompt as well:
C:\Users\R\eclipse-workspace\VendingMachine\src>javac com\testcode\VendingMachine.java

C:\Users\R\eclipse-workspace\VendingMachine\src>java com.testcode.VendingMachine
Please select your drink:
A for Coke - 25 cents
B for Pepsi - 35 cents
C for Soda - 45 cents
E to Exit


2. API automation

As a biker I would like to know the exact location of city bikes around the world in a given application.
Test this particular scenario: “As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude”

The code has been written using Eclipse Version: 2020-09 (4.17.0), JDK 1.8 and run from IDE itself.
Test shall validate if response 200 is received and then proceed
It shall give the details of country and longitude and latitude for city entered as Frankfurt
If any city name given is not found it shall give prompt as City name not found

Other BDD scenarios can be as below but not included in the script
Scenario: User is able to retrieve the companies and it's details available in a city or country
Given: User is able to access API and provided city and country is available in the list
When: User submits the country and/or city name
Then: All bike company names are retrieved with details

Scenario: User is able to locate bikes in cities based on country
Given: User is able to access the API 
When: User submits the name of the country
Then: All cities having bikes available in the country is displayed with details

Scenario: User is able to locate bikes in cities based on for specific company
Given: User is able to access the API and has city is available in the list of networks
When: User submits the name of the city
Then: All companies in the city are listed with details

Scenario: User is able to find latitude and longitude of the bike available in a specific city in a country
Given: User is able to access the API and has city is available in the list of networks
When: User submits the name of the city
Then: All companies in the city are listed with exact longitude and latitude of the bikes

Scenario: User is able to retrieve all cities the bike company is providing service
Given: User is able to access the API and has company is available in the list of networks
When: User submits name of the company
Then: Only the details are retrieved for the specific company for all cities and countries

Scenario: Proper error message is received if no details found
Given: User is able to access the API and provides company name/city/country
When: Company name/city/country not in the network
Then: Proper error message is returned

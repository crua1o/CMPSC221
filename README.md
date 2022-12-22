# CMPSC221 Projects

## Decode the VIN

Your task is to create a Java application that implements a simple Vehicle Identification Number (VIN) decoder. A VIN is a unique code that an automobile manufacturer assigns to an individual vehicle. Although in use since 1954, VINs were not standardized until 1981. The standardized format requires that 
a VIN contain 17 characters consisting only of letters and digits. (Technically, the letters I, O, and Q are not allowed.) A VIN is composed of 3 main sections: 
1. World Manufacturer Identifier (WMI) – Characters 1 through 3 indicate the country in which a vehicle was made and the manufacturer who made it. 
2. Vehicle Descriptor Section (VDS) – Characters 4 through 8 identify the vehicle type and may include information about model, body style, and engine type. Character 9 is a check digit used to detect invalid VINs. 
3. Vehicle Identifier Section (VIS) – Characters 10 through 17 identify the model year, manufacturing plant, and serial number. 
Specific vehicle information that can be retrieved without too much difficulty is: country of origin (character 1), manufacturer (character 2), check digit (character 9), model year (character 10), and serial number (characters 12 through 17).  
 
Your program begins by prompting the user to enter a string representing a VIN. If the VIN is valid, it is decoded to display the 3 groups (WMI, VDS, VIS) and 5 attributes (country, manufacturer, check digit, model year, serial number) described above. If it is invalid, an appropriate error message is displayed. The program then asks the user if s/he wishes to enter another VIN. Depending upon the user’s response, the 
program either prompts for another VIN or thanks the user for using the VIN decoder and ends.

## Online Pizza Shop

Create a Java application that implements an online specialty pizza shop.
1. Obtain order.
2. Display order summary
3. Process payment
4. Thank customer

## Query Movies Database

### Description
Java program that queries a database of movies and awards they have won. Includes an SQL script to create a movies database filled with data.
Includes two tables:
1) movieTitles, with fields movieID, title, rating, genre, director, and star; movieID holds an integer, while the rest of the fields will hold strings; movieID is also the primary key.
2) movieAwards, with fields movieID, award, and awardYear; movieID and awardYear holds integers, while award holds a string; movieID is also the foreign key.

Also includes Java program to query database:

1. A query to display all information in the movieTitles table sorted in ascending order by title. 
2. A query to display all information in the movieAwards table sorted in descending order by award year. 
3. A query to display all information except for movie ID, director, award, and award year for those movies whose rating is “PG-13.” 
4. A query to display all information except for rating and genre for only those movies that have won awards.

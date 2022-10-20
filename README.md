# movies-database
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

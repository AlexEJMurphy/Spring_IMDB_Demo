# Exposing [IMDb Non-Commercial Datasets](https://developer.imdb.com/non-commercial-datasets/#titleratingstsvgz)

##  - Using the Spring Framework

### This project was my first step into the world of Spring. The intention of the project for the user to input the title of a film and get the associated director(s) and/or writer(s).

#### Rather than load different datasets into different repositories and query with a join, this project parses fields from the 'title.basics.tsv.gz' AND 'title.crew.tsv.gz' into a map of 'GetCrewForMovieTitle' Query Objects and saves it to 'IMDBMovieAndCrewRepository', an approach based on  [this](https://softwareengineering.stackexchange.com/questions/421229/data-repository-and-complex-queries-dto) discussion.


To run the project through Idea: Execute Maven Goal -> mvn spring-boot:run

#### Prerequisites:

Download
- title.basics.tsv.gz 
- title.crew.tsv.gz from the link in the title of this README


Replace the filepaths in 'RestServiceApplication' - line 36 with your local paths to the datasets.

#### Dependencies:

 - Apache Commons
 - Spring Boot JPA
 - Spring Boot Starter Web
 - Spring Boot DevTools
 - Spring Boot ThymeLeaf
 - H2 Database
 - OpenCSV
 - Jackson Dataformat CSV

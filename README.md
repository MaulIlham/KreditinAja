<!-- ABOUT THE PROJECT -->
## About The Project

Kreditin aja is a system used for buying and selling houses, 
where on Kreditin, users can sell their houses or users can also buy houses on credit.



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* maven : 
  https://mkyong.com/maven/how-to-install-maven-in-windows/

* OpenJdk 8
* Text Editor

## Configuration
 * before you run the project you must be config path
of image, you can change path image in Constant.java
 * create database db_kreditinaja and then download and import table from here : https://drive.google.com/drive/folders/1BwpOEtmpSKF7YD4sNJCm52KmitxGSdiu?usp=sharing
 * don't forget to change you mysql access in application-local.properties, change your password and username with your password and username
 
### Installation

1. Build Spring Boot Project with Maven
   ```sh
    maven package
   ```
   or
   
   ```sh
    mvn install / mvn clean install
   ```
2. Run Spring Boot app using Maven: 
   ```sh
   mvn spring-boot:run
   ```
3. [optional] Run Spring Boot app with java -jar command
   ```JS
   java -jar target/Kreditin-Aja-0.0.1-SNAPSHOT.jar
   ```

<!-- USAGE EXAMPLES -->
## Usage

run the project and open http://localhost:8844/api-docs.html for the API documentation 

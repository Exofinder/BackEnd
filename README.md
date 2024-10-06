# 2024 NASA Space Apps Challenge

---

## Theme: Navigator for the Habitable Worlds Observatory (HWO): Mapping the Characterizable Exoplanets in our Galaxy

---

## Implements

### CSV Data Upload API

1. **Processing CSV Files:**
   - We retain only the parameters to be used on the server and determine the information to be stored in the database.
   - Formulas are used to calculate values using information within the database to reduce null values.
   - Handling of null values is implemented.
2. **Domain Design:**
   - The domain is designed to accommodate all the data.
3. **Infrastructure Setup:**
   - We connect to RDS to insert data into the RDS
4. **Using Libraries and JPA:**
   - The CSV Reader library is used to read the CSV file line by line and store it in the database.

### habitability probability calculation and Determine Impact of corona graph API

1. **Determining Habitability for Each Planet and Their Influence on the Corona Graph:**
   - Receive the name of the host star and obtain a list of information about all planets within that system.
   - Use the list as a parameter to call the API of the AI server.
   - Use Mono for asynchronous processing.
2. **Process the response from the AI server:**
   - Use ObjectMapper to convert the JSON file into a List.
   - Store the List in a DTO and return it in a format that is easy to process when responding to the frontend.
     
---

## Tech Stack

- Build & Bundler: `AWS Elastic Beanstalk`
- Framework: `Spring Boot`
- Language: `Java`
- CSV Reader: `OpenCSV`
- Database: `AWS RDS`
- CORS Configuration: `WebMvcConfigurer`
- Deploy: `AWS`

---

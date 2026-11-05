# Hospital Management System

A menu-driven Hospital Management System built with Java, JDBC, and MySQL.

## Features

- Register and view patients
- Search patient records
- Add and view doctors
- Book and view appointments
- Generate and view bills

## Technologies

- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA (development environment)

## Database setup

1. Open MySQL Workbench and connect to your local MySQL server.
2. Open `database.sql`.
3. Execute the script to create the `hospital_db` database and its four tables:
   `patients`, `doctors`, `appointments`, and `bills`.

The script creates the tables and their primary-key/foreign-key relationships. It does not insert real patient or doctor records.

## Configure the database connection

The application reads the database password from the `DB_PASSWORD` environment variable.

Set `DB_PASSWORD` on your computer to your own local MySQL password before running the application. Do not put your actual password in source code or commit it to GitHub.

The connection URL and username are configured in `DBConnection.java`. Update them if your local MySQL setup uses a different database name, host, port, or username.

## Run the application

1. Install a compatible JDK and MySQL Server.
2. Open this Maven project in IntelliJ IDEA (or another Java IDE).
3. Allow Maven to download the dependencies listed in `pom.xml`.
4. Create the database using `database.sql`.
5. Set the `DB_PASSWORD` environment variable.
6. Run the `Main` class.

## Notes

- This is an educational project intended for learning Java, JDBC, and relational database operations.
- Use sample data only. Do not commit real patient information.
- The SQL script reflects the column definitions visible in the project's current MySQL schema. If your original schema uses additional indexes, constraints, or different foreign-key names/options, compare it with `SHOW CREATE TABLE` before replacing an existing database.

## Author

Tejas Thirivikraman

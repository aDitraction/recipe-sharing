# Recipe Sharing Platform

A simple Java application that allows users to add and view recipes. It uses a **MySQL database** to store recipes and provides a graphical user interface (GUI) using **Java Swing**.

## Prerequisites

Before you start, you need to have the following installed on your machine:

- **Java 8 or higher**
- **Maven**
- **MySQL** (or a compatible database)
- **Eclipse IDE** (Optional, for development)

## 1. Setting Up the MySQL Database

First, make sure you have **MySQL** installed and running. You can follow the instructions below to set up the **database** and **table** for storing recipes.

### 1.1. Start MySQL Server

Ensure that the **MySQL server** is running. If you're using MySQL locally, you can start the server through MySQL Workbench or by running the following command in the terminal:

```bash
sudo service mysql start
```
1.2. Create the Database and Table

Connect to the MySQL server and create the recipe_sharing database and recipes table:
```sql
CREATE DATABASE recipe_sharing;
USE recipe_sharing;

CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    ingredients TEXT,
    instructions TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
You can run the above SQL queries in MySQL Workbench or using the MySQL command-line client.
2. Configuration
2.1. Database Configuration

In the project, the DBUtil.java file contains the database connection settings. Open the DBUtil.java file and update the connection string, username, and password to match your MySQL configuration.
```java
private static final String URL = "jdbc:mysql://localhost:3306/recipe_sharing?useSSL=false&serverTimezone=UTC";
private static final String USER = "recipe_user";  // Change this to your MySQL username
private static final String PASSWORD = "password";  // Change this to your MySQL password
```
Ensure that these credentials match the MySQL user and password you've set up for connecting to the recipe_sharing database.
3. Build and Run the Application

You can build and run this project either from Eclipse IDE or directly from the command line using Maven.
3.1. Using Eclipse

    Import the Project:
        Open Eclipse and select File → Import → Existing Maven Projects.
        Navigate to the root directory of this project and select it to import the project into Eclipse.

    Build the Project:
        Right-click on the project in the Project Explorer.
        Choose Maven → Update Project to ensure that all dependencies are downloaded.

    Run the Application:
        Right-click on RecipeGUI.java (located under src/main/java/com/recipe/).
        Select Run As → Java Application.
        The Swing GUI should open, allowing you to interact with the application.

3.2. Using Maven from the Command Line

    Install Maven: If you haven't already, download and install Maven.

    Build the Project: In the root directory of the project (where pom.xml is located), open the terminal or command prompt and run:
```bash
mvn clean install
```
This will clean, compile, and package the project.

Run the Application: After the project is built, you can run the application by executing:
```bash
mvn exec:java -Dexec.mainClass="com.recipe.RecipeGUI"
```
This will start the Swing GUI.

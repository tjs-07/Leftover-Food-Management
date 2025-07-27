# Leftover Food Management System

## Overview
The **Leftover Food Management System** is a Java-based application designed for restaurants to manage surplus food. It allows users to add details about leftover food, including its name, type, quantity, manufacturing date, expiration date, storage method, allergies, and delivery location. This system helps track and redistribute food, contributing to reducing food waste.

## Features
- **Login/Signup**: Secure login system for restaurants.
- **Food Management**: Add, manage, and track leftover food details.
- **Database**: Uses MySQL for storing food-related data.
- **User Interface**: Built with Java Swing for an intuitive GUI.
- **Responsive Design**: Well-organized UI with labels, text boxes, and buttons.

## Technologies Used
- **Java**: Programming language used for development.
- **MySQL**: Database for storing food data.
- **Java Swing**: GUI framework for building the user interface.

## Prerequisites
- **Java 8 or above** installed.
- **MySQL** for database management.
- **MySQL Connector/J** (JDBC driver) added to your project’s classpath.

## Setup
1. **Clone the repository** to your local machine.
2. **Import the project** into your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. **Set up the MySQL database** with the following structure:
   - Database: `food`
   - Table `hotel` for food data.
   - Table `login` for user credentials.

4. **Add your MySQL credentials** (username, password) in `DatabaseConnection.java`.

## Usage
1. Run the application to see the **Home Page**.
2. Click on **Restaurant Login** to access the login/signup page.
3. After logging in, you’ll be redirected to the **Food Management Page**, where you can add surplus food details.



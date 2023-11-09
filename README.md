# RMI Banking System

## Introduction
The RMI (Remote Method Invocation) Banking System is a Java-based application that allows users to perform basic banking operations such as creating accounts, depositing and withdrawing funds, checking account balances, and transferring funds between accounts. It uses RMI technology to enable remote access to these banking functionalities.

## Features
- **Create Account:** Users can create a new bank account by providing a unique account ID and an initial balance.

- **Deposit Funds:** Users can deposit funds into their existing accounts by specifying the account ID and the amount to deposit.

- **Withdraw Funds:** Users can withdraw funds from their accounts, provided they have sufficient balance.

- **Check Account Balance:** Users can check the balance of any existing account by providing its account ID.

- **Transfer Funds:** Users can transfer funds from one account to another by specifying the source and destination account IDs and the amount to transfer.

- **Graphical User Interface (GUI):** The application includes a GUI for easy interaction with the banking system.

## Prerequisites
Before running this project, make sure you have the following prerequisites installed:
- Java Development Kit (JDK) 8 or higher
- Maven
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL (or any other relational database)

## Getting Started
Follow these steps to set up and run the RMI Banking System:

1. Clone the repository to your local machine:

2. Set up your MySQL database and configure the database connection in the `application.properties` file.

3. Build the project using Maven:

4. Start the RMI server:

5. Start the RMI client:

6. The GUI for the banking system should now be running, allowing you to perform banking operations.

## Project Structure
- **com.example.RMI:** Contains the main application code.
- `Account`: Entity class representing a bank account.
- `AccountRepository`: Repository interface for managing account data.
- `BankManager`: RMI interface defining banking operations.
- `BankManagerGUI`: Graphical user interface for interacting with the banking system.
- `BankManagerImpl`: Implementation of the `BankManager` RMI interface.
- `Client`: Main client application to connect to the RMI server.
- `Server`: Main server application to host the RMI service.

## Usage
1. Run the server (`Server.java`) to start the RMI service.

2. Run the client (`Client.java`) to start the GUI for the banking system.

3. Use the GUI to perform banking operations as described in the Features section.




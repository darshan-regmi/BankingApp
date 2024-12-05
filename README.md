Banking App

A simple banking application built using JavaFX. This application allows users to log in, view their balance, deposit and withdraw funds, and view transaction history.

Features

	•	Login: Secure user login with username and password.
	•	Balance Overview: View your current account balance.
	•	Deposit Funds: Deposit money into the account.
	•	Withdraw Funds: Withdraw money from the account (with sufficient balance).
	•	Transaction History: View a list of all past transactions.
	•	Exit: Close the application.

Requirements

	•	Java 11+ (for compatibility with JavaFX)
	•	JavaFX SDK (version 23 or higher)

Installation

Prerequisites:

	1.	Install Java JDK (version 11 or above).
	2.	Install JavaFX SDK (version 23 or higher). You can download it from JavaFX Downloads.

Setup:

	1.	Clone the repository (if applicable) or download the source files.
	2.	Extract JavaFX SDK and note the lib directory path.

Running the Application:

	1.	Open the terminal and navigate to the project directory.
	2.	Compile the source code using the following command:

avac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out BankingApp.java 


	3.	Run the application with:

java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp out Github.BankingApp.BankingApp



Example:

Replace /path/to/javafx-sdk/lib with the actual path to the lib directory of your JavaFX SDK installation. For example:

java --module-path /Library/Java/JavaVirtualMachines/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -cp out Github.BankingApp.BankingApp

Credentials:

	•	Username: user
	•	Password: password

Project Structure

.
├── BankingApp.java      # Main Java file
└── out                        # Directory for compiled class files
    └── Github
		└──BankingApp
        	└── BankingApp.class

License

This project is licensed under the MIT License - see the LICENSE file for details.

Feel free to modify or add sections as needed based on your project’s specifics! Let me know if you need further customizations.
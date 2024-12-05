package Github.BankingApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BankingApp extends Application {

    private double balance = 1000.00; // Initial balance
    private ArrayList<String> transactions = new ArrayList<>();
    private Label balanceLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking Application");

        // Login Scene
        VBox loginPane = createLoginPane(primaryStage);

        // Set up the initial scene
        Scene scene = new Scene(loginPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createLoginPane(Stage stage) {
        VBox loginPane = new VBox(10);
        loginPane.setPadding(new Insets(20));
        loginPane.setAlignment(Pos.CENTER);

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            // Simple username and password check
            if ("user".equals(userField.getText()) && "password".equals(passField.getText())) {
                stage.setScene(new Scene(createDashboardPane(stage), 400, 300));
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid credentials!");
            }
        });

        loginPane.getChildren().addAll(userLabel, userField, passLabel, passField, loginButton);

        return loginPane;
    }

    private VBox createDashboardPane(Stage stage) {
        VBox dashboardPane = new VBox(10);
        dashboardPane.setPadding(new Insets(20));
        dashboardPane.setAlignment(Pos.CENTER);

        balanceLabel = new Label("Balance: $" + balance);

        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button transactionButton = new Button("Transactions");
        Button exitButton = new Button("Exit");

        depositButton.setOnAction(e -> handleDeposit());
        withdrawButton.setOnAction(e -> handleWithdrawal());
        transactionButton.setOnAction(e -> showTransactionHistory());
        exitButton.setOnAction(e -> stage.close());

        VBox buttonBox = new VBox(10, depositButton, withdrawButton, transactionButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);

        dashboardPane.getChildren().addAll(balanceLabel, buttonBox);

        return dashboardPane;
    }

    private void handleDeposit() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Deposit");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter deposit amount:");

        dialog.showAndWait().ifPresent(input -> {
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    balance += amount;
                    transactions.add("Deposited: $" + amount);
                    updateBalanceLabel();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Enter a valid amount!");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid input!");
            }
        });
    }

    private void handleWithdrawal() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Withdraw");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter withdrawal amount:");

        dialog.showAndWait().ifPresent(input -> {
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    transactions.add("Withdrew: $" + amount);
                    updateBalanceLabel();
                } else if (amount > balance) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Insufficient balance!");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Enter a valid amount!");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid input!");
            }
        });
    }

    private void showTransactionHistory() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Transactions");
        alert.setHeaderText(null);
        StringBuilder transactionHistory = new StringBuilder();
        for (String transaction : transactions) {
            transactionHistory.append(transaction).append("\n");
        }
        alert.setContentText(transactionHistory.length() > 0 ? transactionHistory.toString() : "No transactions yet.");
        alert.showAndWait();
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + balance);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
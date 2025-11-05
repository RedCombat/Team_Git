package edu.utsa.cs3443.uzd052_lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.io.IOException;

public class MainScreenController {
    
    @FXML private TextArea registrationNumberField;
    @FXML private RadioButton findRadioButton;
    @FXML private RadioButton deleteRadioButton;
    @FXML private TextArea resultArea;
    
    private AidShipManager aidShipManager;
    
    @FXML
    public void initialize() {
        aidShipManager = new AidShipManager();
        loadShipsOnStartup();
    }
    
    private void loadShipsOnStartup() {
        try {
            aidShipManager.loadAidShips();
            int shipCount = aidShipManager.getAidShipList().size();
            resultArea.setText("Welcome! Successfully loaded " + shipCount + " ships from database.");
        } catch (IOException e) {
            resultArea.setText("Warning: Could not load ship data - " + e.getMessage());
        }
    }
    
    @FXML
    private void handleListShips() {
        ArrayList<AidShip> ships = aidShipManager.getAidShipList();

        if (ships.isEmpty()) {
            resultArea.setText("No ships currently registered in the system.");
            return;
        }

        String output = "--- REGISTERED AID SHIPS ---\n\n";

        for (AidShip ship : ships) {
            output += ship + "\n\n";
        }

        resultArea.setText(output);
    }
    
    @FXML
    private void handleGo() {
        String regNumber = registrationNumberField.getText().trim();
        
        if (regNumber.isEmpty()) {
            showError("Please enter a registration number first.");
            return;
        }
        
        if (findRadioButton.isSelected()) {
            findShip(regNumber);
        } else if (deleteRadioButton.isSelected()) {
            deleteShip(regNumber);
        }
    }
    
    private void findShip(String regNumber) {
        AidShip ship = aidShipManager.findAidShip(regNumber);

        if (ship != null) {
            resultArea.setText("Found ship:\n\n" + ship);
        } else {
            resultArea.setText("No ship found with registration: " + regNumber);
        }
    }
    
    private void deleteShip(String regNumber) {
        AidShip ship = aidShipManager.findAidShip(regNumber);

        if (ship == null) {
            resultArea.setText("Cannot delete - no ship found with registration: " + regNumber);
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Delete Ship");
        confirm.setHeaderText("Are you sure?");
        confirm.setContentText("This will permanently delete: " + ship.getName() + " (" + regNumber + ")");

        var result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                boolean success = aidShipManager.deleteAidShip(ship);
                if (success) {
                    resultArea.setText("Ship '" + ship.getName() + "' has been deleted.\n" +
                                     "Ships remaining: " + aidShipManager.getAidShipList().size());
                    registrationNumberField.clear();
                } else {
                    resultArea.setText("Delete operation failed - please try again.");
                }
            } catch (IOException e) {
                showError("Could not save changes: " + e.getMessage());
            }
        }
    }
    
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
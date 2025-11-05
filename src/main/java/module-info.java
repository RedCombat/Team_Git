module edu.utsa.cs3443.uzd052_lab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.uzd052_lab3 to javafx.fxml;
    exports edu.utsa.cs3443.uzd052_lab3;
}
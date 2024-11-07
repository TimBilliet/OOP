module be.ugent.memory {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.memory to javafx.fxml;
    exports be.ugent.memory;
}
module com.main.tugaspbo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.main.tugaspbo to javafx.fxml;
    exports com.main.tugaspbo;
    opens DB to javafx.base;
    exports Student;
}

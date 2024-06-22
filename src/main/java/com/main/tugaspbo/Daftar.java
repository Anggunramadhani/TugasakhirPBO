package com.main.tugaspbo;

import DB.Student;
import DB.User;
import Student.MenuStudent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Daftar extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the AnchorPane
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);

        // Create the Labels
        Label titleLabel = new Label("UMM Library");
        titleLabel.setFont(new Font("Times New Roman", 36));
        titleLabel.setLayoutX(239);
        titleLabel.setLayoutY(54);
        titleLabel.setStyle("-fx-text-fill: #ff0000;");

        Button backButton = new Button("Login Student");
        backButton.setLayoutX(14.0);
        backButton.setLayoutY(446.0);
        backButton.setPrefSize(119.0, 40.0);
        backButton.setFont(new Font("System Bold", 14.0));

        backButton.setOnAction(actionEvent -> {
            LoginStudent loginStudent = new LoginStudent();
            loginStudent.start(primaryStage);
        });

        Label nameLabel = new Label("Nama");
        nameLabel.setLayoutX(74.0);
        nameLabel.setLayoutY(113.0);
        nameLabel.setFont(new Font(18.0));

        Label nimLabel = new Label("NIM");
        nimLabel.setLayoutX(74.0);
        nimLabel.setLayoutY(192.0);
        nimLabel.setFont(new Font(18.0));

        Label facultyLabel = new Label("Fakultas");
        facultyLabel.setLayoutX(376.0);
        facultyLabel.setLayoutY(113.0);
        facultyLabel.setFont(new Font(18.0));

        Label programLabel = new Label("Program Studi");
        programLabel.setLayoutX(378.0);
        programLabel.setLayoutY(192.0);
        programLabel.setFont(new Font(18.0));

        TextField nameField = new TextField();
        nameField.setLayoutX(82.0);
        nameField.setLayoutY(140.0);
        nameField.setPrefSize(257.0, 35.0);

        TextField nimField = new TextField();
        nimField.setLayoutX(82.0);
        nimField.setLayoutY(219.0);
        nimField.setPrefSize(257.0, 35.0);

        TextField facultyField = new TextField();
        facultyField.setLayoutX(387.0);
        facultyField.setLayoutY(140.0);
        facultyField.setPrefSize(257.0, 35.0);

        TextField programField = new TextField();
        programField.setLayoutX(387.0);
        programField.setLayoutY(219.0);
        programField.setPrefSize(257.0, 35.0);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(88.0);
        errorLabel.setLayoutY(384.0);
        errorLabel.setPrefSize(537.0, 20.0);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font(14.0));

        Label noterorlabel = new Label();
        noterorlabel.setFont(new Font(18));
        noterorlabel.setLayoutX(157);
        noterorlabel.setLayoutY(395);
        noterorlabel.setPrefSize(381, 17);
        noterorlabel.setTextFill(Color.BLUE);

        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(274.0);
        submitButton.setLayoutY(302.0);
        submitButton.setPrefSize(165.0, 53.0);
        submitButton.setFont(new Font("System Bold", 18.0));


        submitButton.setOnAction(actionEvent -> {

            String name = nameField.getText();
            String nim = nimField.getText();
            String faculty = facultyField.getText();
            String program = programField.getText();

            if(name.isEmpty()) {
                errorLabel.setText("Name empty");
                return;
            }
            if(nim.isEmpty()) {
                errorLabel.setText("NIM empty");
                return;
            }
            if(faculty.isEmpty()) {
                errorLabel.setText("Faculty empty");
                return;
            }
            if(program.isEmpty()) {
                errorLabel.setText("Program empty");
            }

            if(nim.length() != 15) {
                errorLabel.setText("NIM must be 15 digits");
                return;
            }

            if(!nim.matches("\\d+")) {
                errorLabel.setText("NIM must be digits");
                return;
            }
            errorLabel.setText("Daftar berhasil!");
            User.students.add(new Student(name, nim, faculty, program));
            MenuStudent menustudent = new MenuStudent();
            menustudent.start(primaryStage);
        });

        root.getChildren().addAll(
                titleLabel, backButton, nameLabel, nimLabel, facultyLabel, programLabel,
                nameField, nimField, facultyField, programField, errorLabel, submitButton
        );

        Scene scene = new Scene(root);
        primaryStage.setTitle("Daftar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

package com.main.tugaspbo;

import DB.Book;
import DB.User;
import DB.Student;
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

public class LoginStudent extends Application {

    public static boolean sudahTambah = false;

    public static void addTempStudent(){
        User.students.add(new Student("Aggun Ramadhani", "202310370311077",  "Teknik", "Informatika"));
        User.students.add(new Student("Fany Fauzah", "202310370311066", "Teknik ", "Informatika"));
    }

    public static void addTempBooks() {
        User.books.add(new Book("388c-e681-9152", "Laskar Pelangi", "Andrea Hirata\n", "Story", 15));
        User.books.add(new Book("ed90-be30-5cdb", "Bumi Manusia", "Pramoedya Ananta Toer\n", "Story",10));
        User.books.add(new Book("d95e-0c4a-9523", "Ayat-Ayat Cinta ", " Habiburahman Shirazy", "Story", 17));
    }

    @Override
    public void start(Stage primaryStage) {
        if(!sudahTambah) {
            addTempStudent();
            addTempBooks();
            sudahTambah = true;
        }
        // Create the AnchorPane
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);

        // Create the Labels
        Label titleLabel = new Label("UMM Library");
        titleLabel.setFont(new Font("Times New Roman", 36));
        titleLabel.setLayoutX(231);
        titleLabel.setLayoutY(55);
        titleLabel.setStyle("-fx-text-fill: #ff0000;");

        Label nimLabel = new Label("NIM");
        nimLabel.setFont(new Font(18));
        nimLabel.setLayoutX(136);
        nimLabel.setLayoutY(126);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font(18));
        passwordLabel.setLayoutX(139);
        passwordLabel.setLayoutY(212);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(18));
        errorLabel.setLayoutX(157);
        errorLabel.setLayoutY(395);
        errorLabel.setPrefSize(381, 17);
        errorLabel.setTextFill(Color.RED);

        // Create the TextFields
        TextField nimTextField = new TextField();
        nimTextField.setLayoutX(163);
        nimTextField.setLayoutY(154);
        nimTextField.setPrefSize(381, 40);

        TextField passwordTextField = new TextField();
        passwordTextField.setLayoutX(163);
        passwordTextField.setLayoutY(245);
        passwordTextField.setPrefSize(381, 40);

        // Create the Buttons
        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("System Bold", 18));
        loginButton.setLayoutX(279);
        loginButton.setLayoutY(318);
        loginButton.setPrefSize(149, 61);

        loginButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String nim = nimTextField.getText();
            String password = passwordTextField.getText();
            if(nim.isEmpty()) {
                errorLabel.setText("NIM empty.");
                return;
            }
            if(password.isEmpty()) {
                errorLabel.setText("Password empty.");
                return;
            }

            boolean find = false;
            for (int i = 0; i < User.students.size(); i++) {
                if(nim.equals(User.students.get(i).getNim())) {
                    find = true;
                    if(nim.equals(password)) {
                        User.loginStudent = nim;
                        MenuStudent menuStudent = new MenuStudent();
                        menuStudent.start(primaryStage);
                    }else {
                        errorLabel.setText("Incorrect password.");
                    }
                }
            }
            if(!find) {
                errorLabel.setText("NIM not found.");
            }
        });

        Button daftarButton = new Button("Daftar");
        daftarButton.setFont(new Font("System Bold", 14));
        daftarButton.setLayoutX(14);
        daftarButton.setLayoutY(446);
        daftarButton.setPrefSize(119, 40);

        daftarButton.setOnAction(actionEvent -> {
            Daftar Daftar = new Daftar();
            Daftar.start(primaryStage);
        });

        root.getChildren().addAll(titleLabel, nimLabel, passwordLabel, nimTextField, passwordTextField, loginButton, daftarButton, errorLabel);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

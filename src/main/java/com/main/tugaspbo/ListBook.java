package com.main.tugaspbo;


import DB.Book;
import DB.User;
import Student.MenuStudent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListBook extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);
        root.setStyle("-fx-background-color: lightblue;"); // Optional: Set background color for visualization


        Label label = new Label("Daftar Buku");
        label.setLayoutX(250.0);
        label.setLayoutY(34.0);
        label.setFont(new Font("System Bold", 36.0));
        label.setStyle("-fx-text-fill: #ff0000;");


        Button button = new Button("Back");
        button.setLayoutX(14.0);
        button.setLayoutY(446.0);
        button.setFont(new Font("System Bold", 14.0));

        button.setOnAction(actionEvent -> {
            MenuStudent menustudent = new MenuStudent();
            menustudent.start(primaryStage);
        });

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(31.0);
        scrollPane.setLayoutY(111.0);
        scrollPane.setPrefHeight(322.0);
        scrollPane.setPrefWidth(638.0);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        TableView<Book> tableView = new TableView<>();
        tableView.setPrefSize(638, 322);

        TableColumn<Book, String> column1 = new TableColumn<>("ID Book");
        column1.setPrefWidth(140);
        column1.setCellValueFactory(new PropertyValueFactory<>("id_buku"));
        TableColumn<Book, String> column2 = new TableColumn<>("Title");
        column2.setPrefWidth(80);
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> column3 = new TableColumn<>("Author");
        column3.setPrefWidth(80);
        column3.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<Book, String> column4 = new TableColumn<>("Category");
        column4.setPrefWidth(80);
        column4.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Book, String> column5 = new TableColumn<>("Stock");
        column5.setPrefWidth(80);
        column5.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Book> bookData = FXCollections.observableArrayList(User.books);
        tableView.setItems(bookData);

        scrollPane.setContent(tableView);

        root.getChildren().addAll(label, button, scrollPane);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Daftar buku");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



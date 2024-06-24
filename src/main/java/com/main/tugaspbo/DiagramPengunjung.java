package com.main.tugaspbo;

import Student.MenuStudent;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class DiagramPengunjung extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Diagram Pengunjung Bulan Juni");

        // Create a "Back" button
        Button backButton = new Button("Back");
        backButton.setLayoutX(14.0);
        backButton.setLayoutY(446.0);
        backButton.setPrefSize(119.0, 40.0);
        backButton.setFont(new Font("System Bold", 14.0));

        // Handle button click to go back
        backButton.setOnAction(actionEvent -> {
            MenuStudent menuStudent = new MenuStudent();
            menuStudent.start(primaryStage); // Pastikan primaryStage dideklarasikan
        });

        // Data pengunjung selama 4 minggu di bulan Juni
        List<PieChart.Data> pieChartData = new ArrayList<>();
        pieChartData.add(new PieChart.Data("Minggu 1", 100));
        pieChartData.add(new PieChart.Data("Minggu 2", 150));
        pieChartData.add(new PieChart.Data("Minggu 3", 120));
        pieChartData.add(new PieChart.Data("Minggu 4", 200));

        // Membuat diagram lingkaran
        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(pieChartData);

        // Tambahkan tombol "Back" ke dalam Group
        Group root = new Group(pieChart, backButton);

        Scene scene = new Scene(root, 700, 500);
        scene.setFill(javafx.scene.paint.Color.LIGHTBLUE); // Set background color

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
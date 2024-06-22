package com.main.tugaspbo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DiagramPengunjung extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Data pengunjung selama 4 minggu di bulan Juni
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.getData().add(new XYChart.Data<>("Minggu 1", 100));
        dataSeries.getData().add(new XYChart.Data<>("Minggu 2", 150));
        dataSeries.getData().add(new XYChart.Data<>("Minggu 3", 120));
        dataSeries.getData().add(new XYChart.Data<>("Minggu 4", 200));

        // Membuat diagram batang
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.getData().add(dataSeries);

        // Menambahkan persentase di atas setiap batang
        for (XYChart.Data<String, Number> data : dataSeries.getData()) {
            int value = data.getYValue().intValue();
            String percentage = String.format("%.1f%%", ((double) value / 570) * 100);
            data.nodeProperty().get().setOnMouseEntered(e -> {
                data.nodeProperty().get().setStyle("-fx-font-size: 12pt;");
                data.nodeProperty().get().setUserData(percentage);
            });
            data.nodeProperty().get().setOnMouseExited(e -> {
                data.nodeProperty().get().setStyle("");
                data.nodeProperty().get().setUserData(null);
            });
        }


        Scene scene = new Scene(barChart, 600, 400);

        primaryStage.setTitle("Diagram Pengunjung Bulan Juni");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
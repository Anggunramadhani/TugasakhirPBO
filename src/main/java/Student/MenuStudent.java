package Student;

import com.main.tugaspbo.DiagramPengunjung;
import com.main.tugaspbo.ListBook;
import com.main.tugaspbo.LoginStudent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuStudent extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(700, 500);
        root.setStyle("-fx-background-color: lightblue;");


        Label titleLabel = new Label("Student Menu");
        titleLabel.setLayoutX(243.0);
        titleLabel.setLayoutY(60.0);
        titleLabel.setFont(new Font("Times New Roman", 36.0));
        titleLabel.setStyle("-fx-text-fill: #ff0000;");

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(14.0);
        logoutButton.setLayoutY(446.0);
        logoutButton.setPrefSize(119.0, 40.0);
        logoutButton.setFont(new Font("System Bold", 14.0));

        logoutButton.setOnAction(actionEvent -> {
            LoginStudent loginStudent = new LoginStudent();
            loginStudent.start(primaryStage);
        });

        Button borrowBookButton = new Button("Pinjam Buku");
        borrowBookButton.setLayoutX(103);
        borrowBookButton.setLayoutY(159);
        borrowBookButton.setPrefSize(212, 76);
        borrowBookButton.setFont(new Font("System Bold", 18.0));

        borrowBookButton.setOnAction(actionEvent -> {
            BorrowBook borrowBook = new BorrowBook();
            borrowBook.start(primaryStage);
        });

        Button borrowedBookButton = new Button("Kembalikan buku");
        borrowedBookButton.setLayoutX(103);
        borrowedBookButton.setLayoutY(294);
        borrowedBookButton.setPrefSize(212, 76);
        borrowedBookButton.setFont(new Font("System Bold", 18.0));

        borrowedBookButton.setOnAction(actionEvent -> {
            Borrowed borrowed = new Borrowed();
            borrowed.start(primaryStage);
        });

        Button diagramPengunjungButton = new Button("Diagram Pengunjung");
        diagramPengunjungButton.setLayoutX(393);
        diagramPengunjungButton.setLayoutY(159);
        diagramPengunjungButton.setPrefSize(212, 76);
        diagramPengunjungButton.setFont(new Font("System Bold", 18.0));

        diagramPengunjungButton.setOnAction(actionEvent -> {
            DiagramPengunjung diagramPengunjung = new DiagramPengunjung();
            diagramPengunjung.start(primaryStage);
        });

        Button daftarBukuButton = new Button("Daftar Buku");
        daftarBukuButton.setLayoutX(393);
        daftarBukuButton.setLayoutY(294);
        daftarBukuButton.setPrefSize(212, 76);
        daftarBukuButton.setFont(new Font("System Bold", 18.0));

        daftarBukuButton.setOnAction(actionEvent -> {
            ListBook listBook = new ListBook();
            try {
                listBook.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        root.getChildren().addAll(titleLabel, logoutButton, borrowBookButton, borrowedBookButton, diagramPengunjungButton, daftarBukuButton);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Student Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
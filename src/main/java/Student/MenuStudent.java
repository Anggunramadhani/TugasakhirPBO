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

        Label titleLabel = new Label("Student Menu");
        titleLabel.setLayoutX(243.0);
        titleLabel.setLayoutY(60.0);
        titleLabel.setFont(new Font("System Bold", 36.0));

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(14.0);
        logoutButton.setLayoutY(446.0);
        logoutButton.setPrefSize(119.0, 40.0);
        logoutButton.setFont(new Font("System Bold", 14.0));

        logoutButton.setOnAction(actionEvent -> {
            LoginStudent loginStudent = new LoginStudent();
            loginStudent.start(primaryStage);
        });

        Button borrowBookButton = new Button("Borrow Book");
        borrowBookButton.setLayoutX(275.0);
        borrowBookButton.setLayoutY(172.0);
        borrowBookButton.setPrefSize(177.0, 68.0);
        borrowBookButton.setFont(new Font("System Bold", 18.0));

        borrowBookButton.setOnAction(actionEvent -> {
            BorrowBook borrowBook = new BorrowBook();
            borrowBook.start(primaryStage);
        });

        Button borrowedBookButton = new Button("Borrowed Book");
        borrowedBookButton.setLayoutX(275.0);
        borrowedBookButton.setLayoutY(277.0);
        borrowedBookButton.setPrefSize(177.0, 68.0);
        borrowedBookButton.setFont(new Font("System Bold", 18.0));

        borrowedBookButton.setOnAction(actionEvent -> {
            Borrowed borrowed = new Borrowed();
            borrowed.start(primaryStage);
        });

        Button diagramPengunjungButton = new Button("Diagram Pengunjung");
        diagramPengunjungButton.setLayoutX(275.0);
        diagramPengunjungButton.setLayoutY(382.0);
        diagramPengunjungButton.setPrefSize(177.0, 68.0);
        diagramPengunjungButton.setFont(new Font("System Bold", 18.0));

        diagramPengunjungButton.setOnAction(actionEvent -> {
            DiagramPengunjung diagramPengunjung = new DiagramPengunjung();
            diagramPengunjung.start(primaryStage);
        });

        Button daftarBukuButton = new Button("Daftar Buku");
        daftarBukuButton.setLayoutX(275.0);
        daftarBukuButton.setLayoutY(487.0);
        daftarBukuButton.setPrefSize(177.0, 68.0);
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
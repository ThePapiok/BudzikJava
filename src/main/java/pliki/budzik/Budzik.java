package pliki.budzik;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Budzik extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(Budzik.class.getResource("listabudzikow.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Budzik.class.getResource("dodajbudzik.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 600, 600);
        Scene scene2 = new Scene(fxmlLoader2.load(), 600, 600);
        DodajBudzik dodajBudzik=fxmlLoader2.getController();
        ListaBudzikow listaBudzikow=fxmlLoader1.getController();
        listaBudzikow.setStage(stage);
        listaBudzikow.setScene(scene2);
        listaBudzikow.setDodajBudzik(dodajBudzik);
        dodajBudzik.setScene(scene1);
        dodajBudzik.setStage(stage);
        dodajBudzik.setListaBudzikow(listaBudzikow);
        stage.setTitle("Budzik");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

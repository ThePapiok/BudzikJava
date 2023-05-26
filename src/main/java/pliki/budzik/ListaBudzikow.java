package pliki.budzik;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class ListaBudzikow {

    private Stage stage;
    private Scene scene;
    private DodajBudzik dodajBudzik;
    @FXML
    private ListView lista;

    public void dodaj()
    {
        dodajBudzik.resetScene();
        stage.setScene(scene);
    }

    public void zakoncz()
    {
        Platform.exit();
    }

    public void setStage(Stage stage)
    {
        this.stage=stage;
    }

    public void setScene(Scene scene)
    {
        this.scene=scene;
    }

    public void setDodajBudzik(DodajBudzik dodajBudzik) {
        this.dodajBudzik = dodajBudzik;
    }

    public void addToList(String budzik)
    {
        lista.getItems().add(budzik);
    }
}

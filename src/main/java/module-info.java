module pliki.budzik {
    requires javafx.controls;
    requires javafx.fxml;


    opens pliki.budzik to javafx.fxml;
    exports pliki.budzik;
}
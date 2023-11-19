module teste.teste3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens teste.teste3 to javafx.fxml;
    exports teste.teste3;
}

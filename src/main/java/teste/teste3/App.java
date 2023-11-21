package teste.teste3;

import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application { //Veja que a aplicação é no geral associada à uma Application, invocada na main. Lembrar da organização de interface JavaFX: Application < Scene < componentes de interface desejados (botões, labels, etc).

    private static Scene scene;
    
    private final ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary")); //instancia Scene associando chamada ao arquivo de interface fxml principal, chamando-a no método loadFXML
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException { //método auxiliar para poder alterar contexto de Scene na Application corrente. Simular 2 telas que se alternam na aplicação, inicia com a primary.fxml e permite alternar com secondary.fxml
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException { //método de carga de fxml, auxiliar neste exemplo, invocado no método start
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(); //por default, invoca o método start acima para gerar uma Scene na Application corrente
    }

}
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
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application { //Veja que a aplicação é no geral associada à uma Application, invocada na main. Lembrar da organização de interface JavaFX: Application < Scene < componentes de interface desejados (botões, labels, etc).

    private static Scene scene;

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
    
    // salvar um ArrayList de objetos Funcionario em um arquivo. 
    public static void salvarFuncionariosEmArquivo(ArrayList<Funcionario> listaFunc, String caminho, String nomeArquivo) {
    //O método recebe três parâmetros: listaFunc contendo objetos Funcionario a serem salvos, caminho é o caminho do diretório onde o arquivo será salvo, e nomeArquivo é o nome do arquivo a ser criado.
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho + "/" + nomeArquivo))) {
        oos.writeObject(listaFunc); //usado para gravar objetos no arquivo 
        //oos.writeObject(listaFunc): escreve o objeto listaFunc no arquivo.
        System.out.println("Dados salvos com sucesso no arquivo: " + caminho + "/" + nomeArquivo);
    } catch (IOException e) { //mensagem indicando que os dados foram salvos com sucesso, juntamente com o caminho e nome do arquivo.
        Alert msg_erro = new Alert(Alert.AlertType.ERROR);
        msg_erro.setTitle("Reportando Erro");
        msg_erro.setHeaderText("Erro ao salvar dados em arquivo");
        msg_erro.setContentText("Tente novamente");
        msg_erro.showAndWait();
    }
}
}
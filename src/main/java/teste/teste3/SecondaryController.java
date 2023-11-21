package teste.teste3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SecondaryController{
    /*// Componentes gráficos correspondentes aos dados do funcionário
    @FXML
    private TextField txtNome; //campo de texto
    @FXML
    private TextField txtSalario; //campo de texto
    @FXML
    private TextField  dataContratacao; //campo de texto
    @FXML
    private ComboBox<String> cbbCargo; //opções de cargo
    @FXML
    private TextField txtAreaProg; //campo de texto
    @FXML
    private TextField txTurno; //campo de texto */
    @FXML
    Button btnSair; //botão Sair
    @FXML
    Button btnEditar2; 
     
    /*// Lista de Funcionários
    private final ArrayList<Funcionario> listaFunc;
   
    //funcionário selecionado para edição
    private Funcionario funcionarioEmEdicao;
    
    // Construtor que recebe a lista de Funcionários
    public SecondaryController(ArrayList<Funcionario> listaFunc) {
        this.listaFunc = listaFunc;
    }
    
     @FXML // Método para configurar o funcionário para edição associado ao botão "Editar2"
    public void setFuncionarioParaEdicao(Funcionario funcionario) {
        funcionarioEmEdicao = funcionario;
        //definir os valores correspondentes do funcionário selecionado para edição. 
        txtNome.setText(funcionario.getNome());
        txtSalario.setText(String.valueOf(funcionario.getSalario()));
    }

    @FXML  // Método associado ao botão "Excluir"
    private void excluirFuncionario() throws IOException {
        if (funcionarioEmEdicao != null) {
            //excluir o funcionário da lista
            listaFunc.remove(funcionarioEmEdicao);
            
        }
    }*/

    @FXML //Método associado ao botão "Sair"
    private void sair () throws IOException { 
        if (exibirMsgSair())
            
            // Fecha a tela secundária após excluir
            switchToPrimary();
            //System.exit(0);
    } 
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
     // Método para exibir mensagem de confirmação ao sair
    private boolean exibirMsgSair() throws IOException{
        Alert msg_conf = new Alert(Alert.AlertType.CONFIRMATION);
        msg_conf.setTitle("Confirmação");
        msg_conf.setHeaderText("Você clicou em sair.");
        msg_conf.setContentText("Tem certeza?");
        Optional<ButtonType> result = msg_conf.showAndWait();
        return result.get() == ButtonType.OK;
    }
}
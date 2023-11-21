package teste.teste3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import teste.teste3.Funcionario.*;
import teste.teste3.Funcionario;


public class PrimaryController implements Initializable {
    // Declaração de campos com anotação @FXML para injetar elementos da interface gráfica
    @FXML
    private TextField txtNome;//campo de texto
    @FXML
    private TextField txtSalario; //campo de texto
    @FXML
    private TextField  DataContratacao; //campo de texto
    @FXML
    private ComboBox<String> cbbCargo; //opções de cargo
    @FXML
    private TextField txtAreaProg; //campo de texto
    @FXML
    private Label labelAreaProg;
    @FXML
    private TextField txTurno; //campo de texto
    @FXML
    private Label labelTurno;
    @FXML
    Button btnEditar; //botão Editar
    @FXML
    Button btnSair; //botão Sair
    @FXML
    Button btnSalvar; //botão Salvar
    @FXML
    Button btnNovo;//botão Novo
    
     private boolean novoFuncionario = false;
    
    // Referência ao funcionário selecionado para edição
    //private Funcionario funcionarioEmEdicao;
    
    @FXML // Lista de Funcionários
    private final ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
    
    
    @FXML //tabela da classe Funcionário, para exibi-los;
    private TableView<Funcionario> Tabela = new TableView<Funcionario>(); 
    
    // Declaração das colunas da tabela
    @FXML
    private TableColumn<Funcionario, String> colNome = new TableColumn <>();
    @FXML
    private TableColumn<Funcionario, Double> colSalario = new TableColumn <>();
    @FXML
    private TableColumn<Funcionario, Date> colContratacao = new TableColumn <>();
    @FXML
    private TableColumn<Funcionario, String> colCargo = new TableColumn <>();
    @FXML
    private TableColumn<Funcionario, String> colAreaProg = new TableColumn <>();
    @FXML
    private TableColumn<Funcionario, String> colTurno = new TableColumn <>();
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {  // Método de inicialização do controlador
        // Formulário de Cadastro, inicialização dos elementos;
        txtNome.setText(""); 
        txtSalario.setText("");
         cbbCargo.getItems().addAll("Gerente Executivo", "Gerente Geral", "Programador", "Secretario");
        DataContratacao.toString();
        txtAreaProg.setText(""); 
	txTurno.setText("Manhã/Tarde/Noite"); 
         
        // Habilita/desabilita e limpa os campos de habilidade e turno com base na seleção do cargo;
        cbbCargo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if ("Programador".equals(newValue)) {
                txtAreaProg.setDisable(false);
                labelAreaProg.setDisable(false);
            } else {
                txtAreaProg.setDisable(true);
                 labelAreaProg.setDisable(true);
                txtAreaProg.clear();
            }

            if ("Secretario".equals(newValue)) {
                txTurno.setDisable(false);
                labelTurno.setDisable(false);
            } else {
                txTurno.setDisable(true);
                labelTurno.setDisable(true);
                txTurno.clear();
            }
        });
        
        preencherColunaNome();
        preencherColunaSalario();
        preencherColunaContratacao();
        preencherColunaCargo();
        
       Tabela.setItems(listaFuncionario());
    }
    
    @FXML //guardar o arraylist em um observablelist
    public ObservableList<Funcionario> listaFuncionario() {
    ObservableList<Funcionario> func = FXCollections.observableArrayList(Funcionario.getListaFunc());
    return func;
}

    
    @FXML //métodos para preencher cada coluna separadamente
    public void preencherColunaNome(){
	colNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Funcionario, String>, ObservableValue<String>>() {
		@Override
		public ObservableValue<String> call (CellDataFeatures<Funcionario, String>  ListaFunc)  {		
			return new SimpleStringProperty( ListaFunc.getValue().getNome());
		}
	});
}
    @FXML
    public void preencherColunaSalario() {
     colSalario.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Funcionario, Double>, ObservableValue<Double>>() {
          @Override
          public ObservableValue<Double> call(CellDataFeatures<Funcionario, Double> ListaFunc) {
            return new SimpleObjectProperty<>(ListaFunc.getValue().getSalario());
        }
    });
}
    @FXML
    public void preencherColunaContratacao() {
        colContratacao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Funcionario, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(CellDataFeatures<Funcionario, Date> ListaFunc) {
                return new SimpleObjectProperty<>(ListaFunc.getValue().getDataContratacao());
        }
    });
}
    @FXML
    public void preencherColunaCargo() {
        colCargo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Funcionario, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Funcionario,String> ListaFunc) {
                return new SimpleObjectProperty(ListaFunc.getValue().getCargo());
        }
    });
}
    
     @FXML
    public void preencherColunaHabilidade() {
        colAreaProg.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Funcionario, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Funcionario,String> ListaFunc) {
                return new SimpleObjectProperty(ListaFunc.getValue().getareaProg());
        }
    });
}
    @FXML
    public void preencherColunaTurno() {
        colTurno.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Funcionario, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Funcionario,String> ListaFunc) {
                return new SimpleObjectProperty(ListaFunc.getValue().getturno());
        }
    });
}
    
    @FXML //Método associado ao botão "Novo"; 
    private void limparCampos() {
        novoFuncionario = true;
        //Tabela.getItems().clear(); // Limpa a tabela 
        txtNome.clear(); //limpa o campo do formulário
        txtSalario.clear(); //limpa o campo do formulário
        cbbCargo.setValue(null); // Limpa o ComboBox
        //txtHabilidade.clear(); sendo limpo em outra parte do código também
        //txTurno.clear(); sendo limpo em outra parte do código também
        txtNome.requestFocus(); //faz o foco de digitação no text field "txtNome"
    }
   
    @FXML //Método associado ao botão de "salvar";
    private void salvar_Funcionario() throws IOException{
         // Verifica se o botão "Novo" foi clicado
        if (!novoFuncionario) {
            // Se não foi clicado, exibe uma mensagem para informar ao usuário que o formulário só pode ser ativado pelo botão "Novo"
            exibirAviso();
            return;
        }

        //salvar funcionário com validações
        String nome = txtNome.getText(); //Obtém o texto do campo de texto chamado txtNome e armazena na variável nome.
    
        if (nome.isEmpty()) { //Verifica se o nome está vazio
            exibirMsgErro(); //Se estiver, chama o método
            return;
    }
        double salario = 0.0;
    try {
        salario = Double.parseDouble(txtSalario.getText()); //converter o texto do campo de texto txtSalario para um valor double
    } catch (NumberFormatException e) {
        mostrarMensagemErro();
        return;
    }
     String cargo = (String) cbbCargo.getValue();
    if (cargo == null) {
        mostrarMensagemErro2();
        return;
    }
    
    /*// Verifica o tipo de funcionário com base no cargo
    Funcionario novoFunc;
        if ("Programador".equals(cargo)) {
            String areaProg = txtAreaProg.getText();
                novoFunc = new Programador(nome, salario, DataContratacao, cargo, areaProg);
    } else if ("Secretario".equals(cargo)) {
            int turno = Integer.parseInt(txTurno.getText());
                novoFuncionario = new Secretario(nome, salario, DataContratacao, cargo, turno);
    } else if ("GerenteExecutivo".equals(cargo)) {
                novoFuncionario = new GerenteExecutivo(nome, salario, DataContratacao, cargo, 0.0, 0.0);
    } else if ("GerenteGeral".equals(cargo)) {
                novoFuncionario = new GerenteGeral(nome, salario, DataContratacao, cargo, 0.0);
    } else {
    return;
}

    // Adiciona o novo funcionário à lista e atualiza a TableView
    listaFuncionarios.add(novoFunc);
    Tabela.setItems(listaFuncionarios);*/
    
    limparCampos(); //é responsável por limpar os campos do formulário.
   
    novoFuncionario = false; //Reseta a variável para garantir que o formulário não possa ser salvo sem clicar no botão "Novo" novamente
    }
    
    @FXML //Método associado ao botão "Editar". 
    private void switchToEditar() throws IOException {
       // Carrega o arquivo FXML da tela secundária
    FXMLLoader loader = new FXMLLoader(PrimaryController.class.getResource("/fxml/secondary.fxml"));
    // Cria uma nova cena e carrega o fxml
    Scene scene = new Scene(loader.load());
    // Obtém a referência à janela principal (Stage)
    Stage stage = new Stage(); // Cria uma nova janela
    // Define o título da nova janela
    stage.setTitle("Editar Funcionário");
    // Define a cena na nova janela
    stage.setScene(scene);
    // Mostra a nova janela (tela secundária)
    stage.show();
    }
    
    @FXML //Método associado ao botão "Sair"
    private void sair () throws IOException { 
        if (exibirMsgSair())
            System.exit(0);
    } 
    
    // Métodos para mostrar mensagens de erro
    private void mostrarMensagemErro() throws IOException{
        Alert msg_erro = new Alert(Alert.AlertType.ERROR);
        msg_erro.setTitle("Reportando Erro");
        msg_erro.setHeaderText("número inválido");
        msg_erro.setContentText("Tente novamente!");
        msg_erro.showAndWait();
    }
    private void mostrarMensagemErro2() throws IOException{
        Alert msg_erro = new Alert(Alert.AlertType.ERROR);
        msg_erro.setTitle("Reportando Erro");
        msg_erro.setHeaderText("Cargo não selecionado");
        msg_erro.setContentText("Selecione um cargo!");
        msg_erro.showAndWait();
    }
    private void exibirMsgErro() throws IOException{
        Alert msg_erro = new Alert(Alert.AlertType.ERROR);
        msg_erro.setTitle("Reportando Erro");
        msg_erro.setHeaderText("Entrada nula");
        msg_erro.setContentText("Tente novamente!");
        msg_erro.showAndWait();
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
    
    // Método para exibir um aviso quando o botão "Novo" não foi clicado
    private void exibirAviso() {
        Alert aviso = new Alert(Alert.AlertType.WARNING);
        aviso.setTitle("Aviso");
        aviso.setHeaderText("Operação não permitida");
        aviso.setContentText("O formulário só pode ser ativado pelo botão 'Novo'.");
        aviso.showAndWait();
    }

    /*// Método para configurar o funcionário para edição (obs: associar a uma função no botão editar ?) 
    public void setFuncionarioParaEdicao(Funcionario funcionario) {
        funcionarioEmEdicao = funcionario;
        //campos do formulário com os dados: Nome, Salário e Data de Contratação para edição 
        txtNome.setText(funcionario.getNome());
        txtSalario.setText(String.valueOf(funcionario.getSalario()));
        DataContratacao.toString();
       
    } */

    
}
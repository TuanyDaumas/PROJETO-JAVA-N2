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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {
    // Declaração de campos com anotação @FXML para injetar elementos da interface gráfica
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSalario; //campo de texto
    @FXML
    private TextField  dataContratacao; //campo de texto
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
    Button btnSalvarComo;//botão Salvar Como
    @FXML
    Button btnNovo;//botão Novo
    
    
    // Referência ao funcionário selecionado para edição
    private Funcionario funcionarioEmEdicao;
    
    @FXML
    private TableView<Funcionario> Tabela = new TableView<Funcionario>(); //tabela da classe Funcionário, para exibi-los;
    // Declaração das colunas da tabela
    @FXML
    private TableColumn<Funcionario, String> colNome; 
    @FXML
    private TableColumn<Funcionario, Double> colSalario; 
    @FXML
    private TableColumn<Funcionario, Date> colContratacao; 
    @FXML
    private TableColumn<Funcionario, ObservableList<String>> colCargo; 
    @FXML
    private TableColumn<Funcionario, String> colAreaProg; 
    @FXML
    private TableColumn<Funcionario, String> colTurno; 
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {  // Método de inicialização do controlador
        // Inicializando as colunas da tabela e vinculando a coluna ao atributo da classe Funcionario
        colNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        colSalario.setCellValueFactory(new PropertyValueFactory<Funcionario, Double>("Salario"));
        colContratacao.setCellValueFactory(new PropertyValueFactory<Funcionario, Date>("Contratação")); 
        colCargo.setCellValueFactory(new PropertyValueFactory<Funcionario, ObservableList<String>>("Cargo"));
        colAreaProg.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Habilidade")); 
        colTurno.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Turno"));
        
        // Formulário de Cadastro, inicialização dos elementos;
         txtNome.setText(""); 
         txtSalario.setText("");
        //ComboBox<String> cbbCargo = new ComboBox<>(); repetido
        // Listener para o ComboBox cbbCargo
         cbbCargo.getItems().addAll("Gerente Executivo", "Gerente Geral", "Programador", "Secretario");
         dataContratacao.toString();
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
    }
    
    
    @FXML //Método associado ao botão "Sair"
    private void sair () throws IOException { 
        if (exibirMsgSair())
            System.exit(0);
    }
    
  
    @FXML //Método associado ao botão "Editar". 
    private void switchToEditar() throws IOException {
        App.setRoot("secondary");
    // Carrega o arquivo FXML da tela secundária
        //chamada para tela secundária onde será possivel editar e excluir os funcionarios cadastrados;
        //App.setRoot("secondary"); 
      
       /*/ Obtém o funcionário selecionado na tabela
       Funcionario funcionarioSelecionado = Tabela.getSelectionModel().getSelectedItem();
       
       // Verifica se um funcionário foi realmente selecionado
        if (funcionarioSelecionado != null) {
        // Armazena a referência ao funcionário selecionado
        funcionarioEmEdicao = funcionarioSelecionado;

        // Carrega o arquivo FXML da tela secundária
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        // Carrega o componente raiz (root) da tela secundária
        Parent root = loader.load();
        // Obtém a instância do controlador da tela secundária
        SecondaryController secondaryController = loader.getController();
        // Configura o funcionário para edição na tela secundária
        secondaryController.setFuncionarioParaEdicao(funcionarioSelecionado);

        // Cria uma nova cena com o componente raiz da tela secundária
        Scene scene = new Scene(root);
        // Obtém a referência à janela principal (Stage)
        Stage stage = new Stage(); // Cria uma nova janela
        // Define a cena na nova janela
        stage.setScene(scene);
        // Define o título da nova janela 
        stage.setTitle("Editar Funcionário");

        // Mostra a nova janela (tela secundária)
        stage.show();
    }*/
    }
    
    @FXML //Método associado ao botão de "salvar";
    private void salvar_Funcionario() throws IOException{
        //salvar funcionário com validações
        String nome = txtNome.getText();
    
        if (nome.isEmpty()) {
            exibirMsgErro();
            return;
    }
        double salario = 0.0;
    try {
        salario = Double.parseDouble(txtSalario.getText());
    } catch (NumberFormatException e) {
        mostrarMensagemErro();
        return;
    }
     String cargo = (String) cbbCargo.getValue();
    if (cargo == null) {
        mostrarMensagemErro2();
        return;
    }
    
   /* String habilidade = txtAreaProg.getText();
     if (habilidade.isEmpty()) {
        exibirMsgErro();
        return;
    }
    String turno = txTurno.getText();
     if (turno.isEmpty()) {
        exibirMsgErro();
        return;
    }*/
    limparCampos();
    }
    
    /*@FXML //Método associado ao botão de "salvar Como"
    private void salvarEmArquivo(ArrayList<Funcionario> listaFunc) { 
    // Diálogo de seleção de arquivo
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Salvar Arquivo");
    File file = fileChooser.showSaveDialog(null);

    // Se o usuário escolher um arquivo, chama o método de salvamento e usa a lista atualizada de funcionários:
    if (file != null) {
        App.salvarFuncionariosEmArquivo(listaFunc, file.getParent(), file.getName());
    }
}*/
    // botão salvar Como 
    public static ArrayList<Funcionario> carregarFuncionariosDoArquivo(String caminho, String nomeArquivo) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho + "/" + nomeArquivo))) {
        // Lê o objeto do arquivo e converte para a lista de funcionários
        ArrayList<Funcionario> listaFuncionarios = (ArrayList<Funcionario>) ois.readObject();
        System.out.println("Dados carregados com sucesso do arquivo: " + caminho + "/" + nomeArquivo);
        return listaFuncionarios;
    } catch (IOException | ClassNotFoundException e) {
        // Em caso de erro, imprime uma mensagem de erro e retorna uma lista vazia
        System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
    }
}
    
    @FXML //Método associado ao botão "Novo" limpa os campos do formulário
    private void limparCampos() {
        //Tabela.getItems().clear(); // Limpa a tabela 
        txtNome.clear();
        txtSalario.clear();
        cbbCargo.setValue(null); // Limpa o ComboBox
        //txtHabilidade.clear(); sendo limpo em outra parte do código também
        //txTurno.clear(); sendo limpo em outra parte do código também
        txtNome.requestFocus(); //faz o foco de digitação no text field "txtNome"
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

    // Método para configurar o funcionário para edição (obs: associar a uma função no botão editar ?) 
    public void setFuncionarioParaEdicao(Funcionario funcionario) {
        funcionarioEmEdicao = funcionario;
        //campos do formulário com os dados: Nome, Salário e Data de Contratação para edição 
        txtNome.setText(funcionario.getNome());
        txtSalario.setText(String.valueOf(funcionario.getSalario()));
        dataContratacao.toString();
       
    } 
}

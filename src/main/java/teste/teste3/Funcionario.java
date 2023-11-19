/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.teste3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Tuany
 */
public class Funcionario {
    private String nome;
    private Double salario;
    private Date DataContratacao;
    private ObservableList<String> cargo;
    private String FuncionarioParaEdicao;
    //private final int matricula;
    
    // Lista estática para armazenar todos os funcionários
    private static List<Funcionario> ListaFunc = new ArrayList<>();
 
    public Funcionario(String nome, Double salario, Date DataContratacao, ObservableList<String> cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
       this.DataContratacao = DataContratacao;
        //this.matricula = matricula;
        
        // Adiciona o funcionário à lista quando é criado
        ListaFunc.add(this);
    }
    
    //métodos de acesso para os campos que precisam ser editados;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getFuncionarioParaEdicao() {
        return FuncionarioParaEdicao;
    }
    
    public void setFuncionarioParaEdicao(String FuncionarioParaEdicao) {
        this.FuncionarioParaEdicao = FuncionarioParaEdicao;
    }

    //public int getMatricula() {
        //return matricula;
   // }

    //public void setMatricula(int matricula) {
        //this.matricula = matricula;
    //}
    
 public Double getSalario() {
        return salario;
    }

 public void SetSalario(Double salario) {
        this.salario = salario;
    }
 
 public Date getDataContratacao() {
        return DataContratacao;
    }
 
 public void setDataContratacao(Date DataContratacao) {
        this.DataContratacao = DataContratacao;
    }

    
    
     public ObservableList getCargo() {
        return cargo;
    }

    public void setCargo(ObservableList Cargo) {
        this.cargo = Cargo;
    }
    //método para aumento salarial 
    public void aumentoSalarial(double aumento) {
       salario += aumento;
}

    // Método estático para obter a lista de funcionários
    public static List<Funcionario> getListaFunc() {
        return ListaFunc;
    }
}

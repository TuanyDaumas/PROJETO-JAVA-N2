/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.teste3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Tuany
 */
public class Funcionario {
    private String nome;
    private Double salario;
    private Date dataContratacao;
    private String cargo;
    private String FuncionarioParaEdicao;
    
    // Lista estática para armazenar todos os funcionários
    private static List<Funcionario> ListaFunc = new ArrayList<>();
 
    public Funcionario(String nome, Double salario, Date dataContratacao, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        
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
    
 public Double getSalario() {
        return salario;
    }

 public void SetSalario(Double salario) {
        this.salario = salario;
    }
 
 public Date getDataContratacao() {
        return dataContratacao;
    }
 
 public void setDataContratacao(Date DataContratacao) {
        this.dataContratacao = DataContratacao;
    }
    
     public String getCargo() {
        return cargo;
    }

    public void setCargo(String Cargo) {
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

    Object getareaProg() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getturno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.teste3;

import java.util.Date;
import javafx.collections.ObservableList;

/**
 *
 * @author Tuany
 */
public class GerenteExecutivo extends Funcionario {
    private double bonus;
    private double coparticipacao;

    public GerenteExecutivo(String nome, Double salario, Date DataContratacao, ObservableList cargo, double bonus,double coparticipacao ) {
        super(nome,salario, DataContratacao, cargo);
        this.bonus = 0.0;
        this.coparticipacao = 0.0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setcoparticipacao(double coparticipacao) {
        this.coparticipacao = coparticipacao;
    }
     //mesmos benefícios de Gerente geral e agrega um bônus de coparticipação;
    @Override
    public Double getSalario() {
        return super.getSalario() + bonus + coparticipacao;
    }
}


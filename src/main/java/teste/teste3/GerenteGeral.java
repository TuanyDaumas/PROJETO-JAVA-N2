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
public class GerenteGeral extends Funcionario {
    private double bonus;
   

    public GerenteGeral(String nome, Double salario, Date dataContratacao, String cargo, double bonus) {
        super(nome,salario, dataContratacao, cargo);
        this.bonus = 0.0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public Double getBonus() {
        return bonus;
    } 

    @Override
    public Double getSalario() {
        return super.getSalario() + bonus;
    }
}



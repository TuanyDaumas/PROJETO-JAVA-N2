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
public class Programador extends Funcionario {
    private String areaProg;

    public Programador(String nome, Double salario, Date DataContratacao, ObservableList cargo, String areaProg) {
        super(nome,salario, DataContratacao, cargo);
        this.areaProg = areaProg;
    }

     public String getareaProg() {
        return areaProg;
    }

    public void setareaProg(String  areaProg) {
        this.areaProg =  areaProg;
    }
}

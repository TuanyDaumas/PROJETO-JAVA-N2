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

    public Programador(String nome, Double salario, Date dataContratacao, String cargo, String areaProg) {
        super(nome,salario, dataContratacao, cargo);
        this.areaProg = areaProg;
    }

     public String getareaProg() {
        return areaProg;
    }

    public void setareaProg(String  areaProg) {
        this.areaProg =  areaProg;
    }
}

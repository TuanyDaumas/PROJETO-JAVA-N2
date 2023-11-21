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
public class Secretario extends Funcionario {
    private  int turno; // 1 - manhã, 2 - tarde, 3 - noite

    public Secretario(String nome, Double salario, Date dataContratacao, String cargo, int turno) {
        super(nome,salario, dataContratacao, cargo);
        this.turno = turno;
    }

    public int getTurno() {
        return turno;
    }
    
    public void setTurno(int turno) {
        this.turno = turno;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FuncionarioDAO;
import controller.SetorDAO;
import model.Endereco;
import model.Funcionario;
import model.Setor;

/**
 *
 * @author Anderson
 */
public class Teste {
    public static void main(String[] args) {
        Setor s = new Setor();
        s.setNome("b");
        s.setCodigo(1);
        
        SetorDAO sd = new SetorDAO();
        
        sd.deleteSetor(1);
        
        
    }
}

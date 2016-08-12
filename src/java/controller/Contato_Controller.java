/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Contato;
import java.util.ArrayList;
import java.util.List;
import model.Contato_DAO;

/**
 *
 * @author CARLOS
 */
public class Contato_Controller {
    Contato_DAO cd = new Contato_DAO();
    List lista = new ArrayList();
    boolean teste;
    Contato contato = new Contato();
    public boolean inserir (Contato contato){
        teste = cd.inserir(contato);
        return teste;
    }
    
    public boolean alterar (Contato contato){
        teste = cd.alterar(contato);
        return teste;
    }
    
    public boolean delete (long contato){
        teste = cd.delete(contato);
        return teste;
    }
    
    public List<Contato> listar(String nome){
        lista = cd.listar(nome);
        return lista;
    }
    
    public Contato getContato (long id){
        contato = cd.getContato(id);
        return contato;
    }
    
    
    
}

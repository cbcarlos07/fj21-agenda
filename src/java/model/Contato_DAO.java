/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import beans.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS
 */
public class Contato_DAO {
    
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public boolean inserir (Contato contato){
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO CONTATOS (id, nome, email, endereco, dataNascimento) VALUES(null, ?,?,?,?)";
        try {
            //JOptionPane.showMessageDialog(null, "Nome: "+contato.getNome()+"\nEndereco: "+contato.getEndereco()+"\nEmail: "+contato.getEmail()+"\nData Nascmento: "+new Date(contato.getDateNascimento().getTime()));
            stmt =  conn.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDateNascimento().getTime()));
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teste;
    }
    
    public boolean alterar (Contato contato){
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
        sql = "UPDATE CONTATOS SET nome = ?, email = ?, endereco = ?, datanascimento = ? WHERE id = ?";
        try {
            stmt =  conn.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setDate(3, new Date(contato.getDateNascimento().getTime()));
            stmt.setLong(4, contato.getId());
            stmt.execute();
            teste = true;
        } catch (SQLException ex) {
            Logger.getLogger(Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teste;
    }
    
    public boolean delete (long contato){
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
        sql = "DELETE FROM CONTATOS WHERE id = ?";
        try {
            stmt =  conn.prepareStatement(sql);
            stmt.setLong(1, contato);
            stmt.execute();
            teste = true;
        } catch (SQLException ex) {
            Logger.getLogger(Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teste;
    }
    
    public List<Contato> listar(String nome){
        Contato contato = null;
        conn = ConnectionFactory.getConnection();
        list = new ArrayList();
        try {
            if(nome.equals("")){
                sql = "SELECT * FROM contatos";
                stmt =  conn.prepareStatement(sql);
            }else{
                sql = "SELECT * FROM contatos WHERE nome LIKE ?";
                stmt =  conn.prepareStatement(sql);
                stmt.setString(1, "%"+nome+"%");
            }
           rs =  stmt.executeQuery();
           SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            while(rs.next()){
                contato =  new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDateNascimento(rs.getDate("dataNascimento"));
                list.add(contato);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Contato getContato (long id){
        Contato contato = null;
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM CONTATOS WHERE id = ?";
        try {
            stmt =  conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDateNascimento(rs.getDate("dataNascimento"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contato_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contato;
    }
    
}

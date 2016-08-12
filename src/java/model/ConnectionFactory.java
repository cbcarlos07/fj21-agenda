/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
//import servicos.MensagensAviso;
/**
 *
 * @author Brito
 */
public final class ConnectionFactory {
    
      static Properties confBanco = new Properties();
    public static Connection getConnection(){
		Connection connection = null;
                String url= null;
		try{
                        
                        
			
                         Class.forName("com.mysql.jdbc.Driver");
                         url ="jdbc:mysql://localhost/fj21";
                        connection = DriverManager.getConnection(url,"root","");
			//connection = DriverManager.getConnection("jdbc:h2:src/BDSistemaMusica/SistemaMusica","sa","");
                        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemamusica","root","123");
			System.out.println("Conectado com sucesso");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
                        //JOptionPane.showMessageDialog(null, "Ja existe um Sistema em execução\nerro "+e.getMessage());
			//System.out.println(e.getMessage());
                        e.printStackTrace();
                        
		}
                 
            //    System.out.println(url);
		return connection;
	}

    
    
}

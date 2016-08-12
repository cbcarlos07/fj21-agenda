/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Contato;
import controller.Contato_Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CARLOS
 */
//@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        //pegando os parametros do request
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String email = req.getParameter("email");
        String dataEmTexto = req.getParameter("dataNascimento");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
             data = (Date)formato.parse(dataEmTexto);
        } catch (ParseException ex) {
            Logger.getLogger(AdicionaContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDateNascimento(data);
        
        //salva o contato
        Contato_Controller cc = new Contato_Controller();
        boolean teste = cc.inserir(contato);
        
        if(teste){
            //imprime o nome do contato que foi adicionado
            out.println("<html>");
            out.println("<body>");
            out.println("Contato "+contato.getNome()+" adicionado com sucesso");
            out.println("</body>");
            out.println("</html>");
        }
        else{
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Erro ao adicionar contato</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
    
}

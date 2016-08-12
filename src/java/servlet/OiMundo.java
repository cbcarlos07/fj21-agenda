package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CARLOS
 */
public class OiMundo extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        PrintWriter out = res.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Primeira Servlet </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Oi mundo servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
    
}

<%-- 
    Document   : lista-contato-scriptlet
    Created on : 04/08/2016, 11:06:19
    Author     : CARLOS
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="beans.Contato"%>
<%@page import="controller.Contato_Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Endereco</th>
                <th>Data nascimento</th>
            </tr>
            <%
                Contato_Controller cc = new Contato_Controller();
                List<Contato> contatos = cc.listar("");
                
                for(Contato contato : contatos){
            %>
            <tr>
                <td><%=contato.getNome() %></td>
                <td><%=contato.getEmail() %></td>
                <td><%=contato.getEndereco() %></td>
                <% SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                   String novaData = formato.format(contato.getDateNascimento());
                %>
                <td><%= novaData %></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>

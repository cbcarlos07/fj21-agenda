<%-- 
    Document   : bemvindo
    Created on : 04/08/2016, 10:30:26
    Author     : CARLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boas vindas</title>
    </head>
    <body>
        <% 
            String mensagem = "Bem vindo!";
        %>
        <h1><% out.println(mensagem); %></h1>
        <br>
        <code>
            <% out.println("<"+"% out.println(mensagem); %"+">"); %>
        </code>
        <br>
        <h1><%= mensagem %></h1>
        <br>
        <code>
            <% out.println("<"+"= mensagem %"+">"); %>
        </code>
        <br>
        <h1>Comentarios em JSP</h1>
        <code>
            
            <% out.println("<"+"-- comentario --%"+">"); %>
        </code>
        
        <br>
        <%-- comentario em JSP aqui: nossa primeira página JSP --%>
        
        <%
        String msg = "Bem vindo ao sistema de agenda do FJ-21!";
        %>
        <% out.println(msg); %>
        <br />
        <%
        String desenvolvido = "Desenvolvido por Carlos Bruno";
        %>
        <%= desenvolvido %>
        <br />
        <%
        System.out.println("Tudo foi executado");
        %>
    </body>
</html>

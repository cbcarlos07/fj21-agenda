<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<html>
    <head>
        <title>Adiciona contato</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/jquery-ui.css" rel="stylesheet" />
        <script src="js/jquery-1.8.2.js"></script>
        <script src="js/jquery-ui.js"></script>
         
            
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <form action="adicionaContato" method="POST">
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      
      Data Nascimento: <input id="dataNascimento" type="text"/><br />
      
      <input type="submit" value="Gravar" />
    </form>
            <c:import url="rodape.jsp" />
            
 
 
    </body>
</html>

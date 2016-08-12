<%-- 
    Document   : lista-contatos
    Created on : 04/08/2016, 12:03:18
    Author     : CARLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- para adicionar as libs corretas vá na pasta webapps\examples\WEB-INF\lib do tomcat-->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Contatos</title>
    </head>
    <body>
        
        <c:import url="cabecalho.jsp" />
        <!-- cria o Controller -->
        <jsp:useBean id="controller" class="controller.Contato_Controller" />
        
        <table border="1">
            <!-- cabecalho -->
            <th>Item</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Endereco</th>
            <th>Data de Nascimento</th>
            
            
            <!-- inicio dos exemplos -->
            
            <!--<c:if test="${not empty contato.email}">
                         <a href="mailto:${contato.email}">${contato.email}</a>
             </c:if> -->
             
             <!-- <c:choose>
                            <c:when test="${not empty contato.email}">
                                <a href="mailto:$contato.email">${contato.email}</a>
                            </c:when>
                            <c:otherwise>
                                E-mail nao encontrado
                            </c:otherwise>
                        </c:choose> -->
                        
                        
             <!-- fim do exemplos -->           
                        
            <!-- percorre contatos montando as linhas da tabela -->
            <c:forEach var="contato" items="${controller.listar('')}" varStatus="status">
                <tr >
                    <td>${status.count}</td>
                    <td>${contato.nome}</td>                    
                    <td>
                        <c:if test="${not empty contato.email}">
                         <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:if> 
                        
                        <c:if test="${empty contato.email}">
                         E-mail nao informado
                        </c:if> 
                     </td>
                    <td>${contato.endereco}</td>
                    <td><fmt:formatDate value="${contato.dateNascimento}" pattern="dd/MM/yyyy" /> </td>
                    
                </tr>
            </c:forEach>    
        </table>
        
        <c:import url="rodape.jsp" ></c:import>
    </body>
</html>

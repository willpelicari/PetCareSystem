<%@page contentType="text/html"
        pageEncoding="UTF-8" 
        import="br.com.Modelo.*, java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> :: REMOVE PESSOA :: </title>
    </head>
    <body>
        <h1> :: REMOVE PESSOA :: </h1>

        <%
            DAO dao = new DAO();
            List list = dao.obtemListaPessoa();
            Iterator it = list.iterator();

        %>

        <form name="formRP" action="RP" method="POST">
            <table border="1" cellspacing="3" cellpadding="5"/>
            <thead>
                <tr>
                    <th> Escolha: </th>
                    <th> CODIGO </th>
                    <th> DESCRICAO </th>          
                </tr>
            </thead>
            <tbody>

                <%                    while (it.hasNext()) {
                        pessoa p = (pessoa) it.next();
                %>

                <tr> 
                    <td> <input type="radio" name="item" 
                                value="<%= p.getIdPessoa()%>"/></td>
                    <td> <%=p.getIdPessoa()%> </td>
                    <td> <%=p.getNome()%> </td>
                </tr>
                <% }%>

                <tr> 
                    <td> <input type="submit" value="Remover"/> </td>
                </tr>
            </tbody>
        </form>
        <a href="index.jsp"> VOLTAR </a>
    </body>
</html>

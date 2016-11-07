<%@page contentType="text/html" 
        pageEncoding="UTF-8"
        import="br.com.Modelo.*, java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> :: REMOVE TIPO ANIMAL :: </title>
    </head>
    <body>
        <h1> :: REMOVE TIPO ANIMAL :: </h1>

        <%
            DAO dao = new DAO();
            List list = dao.obtemListaTipoAnimal();
            Iterator it = list.iterator();

        %>

        <form name="formRTA" action="RTA" method="POST">
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
                        tipoanimal ta = (tipoanimal) it.next();
                %>

                <tr> 
                    <td> <input type="radio" name="item" 
                                value="<%= ta.getIdTipoAnimal()%>"/></td>
                    <td> <%=ta.getIdTipoAnimal()%> </td>
                    <td> <%=ta.getDescricao()%> </td>
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


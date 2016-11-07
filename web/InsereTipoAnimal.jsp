<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="session" class="br.com.Modelo.tipoanimal"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" width="1" cellspacing="1" cellpadding="1">
            <form name="formITA" action="ITA" method="POST">            
                <thead>
                    <tr>
                        <th> Campos </th>
                        <th> Valores </th>
                    </tr>
                </thead>
                <tbody><tr>
                        <td> Código</td>
                        <td> <input type="number" name="Cod"/></td>
                    </tr>
                    <tr>
                        <td> Descricao</td>
                        <td> <input type="text" name="Descricao" size="100" /></td>
                    </tr>               
                </tbody>
        </table>
        <input type="submit" value="ENVIAR" name="ENVIAR" />
    </form>
</html>

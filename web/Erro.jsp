<%-- 
    Document   : ERRO
    Created on : 15/02/2016, 21:29:43
    Author     : lp3
--%>
<%@page import="br.com.Modelo.pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pessoa Pessoa = (pessoa) session.getAttribute("Pessoa");
    boolean admin = false;
    if (null != session.getAttribute("Tipo")) {
        if (Integer.parseInt(session.getAttribute("Tipo").toString()) == 1) {
            admin = true;
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>PetCare System</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="sistema.jsp">Bem-vindo, ${Pessoa.getNome()}</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <% if(admin)%><li><a href="InserePessoa.jsp">Novo Usuario</a></li>
                        <% if(admin)%><li><a href="InsereEvento.jsp">Novo Evento</a></li>
                        <% if(admin)%><li><a href="InsereAnimal.jsp">Novo Pet</a></li>
                        <li><a href="sistema.jsp">Meus Eventos</a></li>
                        <li><a href="sistema.jsp">Meus Animais</a></li>
                        <li><a href="EditarPessoa.jsp">Editar Minhas Informações</a></li>
                        <li><a href="index.jsp"><b>Logout</b></a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h2>Essa operação não pôde ser concluída!</h2></div>
                        <table class="table">
                            <tbody>
                                <tr><td><a href="sistema.jsp"><input class="btn btn-default btn-danger" type="submit" value="VOLTAR À PÁGINA INICIAL" name="ENVIAR" /></a></td>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>   
</html>

<%-- 
    Document   : InserePessoa
    Created on : Jun 7, 2016, 2:58:16 AM
    Author     : WiltonPelicari
--%>
<%@page import="java.util.*"%>
<%@page import="br.com.Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pessoa Pessoa = (pessoa) session.getAttribute("Pessoa");
    DAO dao = new DAO();
    List listaTipoPessoa = dao.obtemListaTipoPessoa();
    Iterator it = listaTipoPessoa.iterator();
    
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
                        <div class="panel-heading"><h2>Cadastrar Novo Usuário</h2></div>
                        <table class="table">
                            <form name="formIP" action="IP" method="POST">            
                                <thead>
                                    <tr>
                                        <th> Campos </th>
                                        <th> Valores </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td> Código</td>
                                        <td> <input type="number" name="idpessoa" class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <td> Nome Completo</td>
                                        <td> <input type="text" name="nome" size="100" class="form-control"/></td>
                                    </tr>
                                    <tr>
                                        <td> Tipo de Usuário</td>
                                        <td>
                                            <select name="idtipo" class="form-control">
                                                <option value="">Selecione...</option>
                                                <% if(!it.hasNext()){ %>
                                                <option value="" disabled>Favor cadastrar mais tipos</option>
                                                <% }else{
                                                    while (it.hasNext()) {
                                                    tipopessoa tp = (tipopessoa)it.next();
                                                %>
                                                <option value="<%= tp.getIdTipoPessoa() %>"><%= tp.getDescricao() %></option>
                                                <% }} %>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> Login</td>
                                        <td> <input type="text" name="login" size="100" class="form-control" /></td>
                                    </tr>
                                    <tr>
                                        <td> Senha</td>
                                        <td> <input type="password" name="senha" size="100" class="form-control" /></td>
                                    </tr>
                                    <tr>
                                        <td> CEP</td>
                                        <td> <input type="text" name="cep" size="100" class="form-control" /></td>
                                    </tr> 
                                    <tr>
                                        <td> Numero</td>
                                        <td> <input type="text" name="numero" size="100" class="form-control" /></td>
                                    </tr> 
                                    <tr>
                                        <td> Telefone</td>
                                        <td> <input type="text" name="telefone" size="100" class="form-control" /></td>
                                    </tr> 
                                    <tr>
                                        <td> E-mail</td>
                                        <td> <input type="email" name="email" size="100" class="form-control" /></td>
                                    </tr>                                    
                                    <tr><td colspan="2"><input class="btn btn-default btn-success" type="submit" value="ENVIAR" name="ENVIAR" /><span>  </span><input class="btn btn-default btn-primary" onclick="history.back()" type="submit" value="VOLTAR" name="VOLTAR" /></td></tr>
                                </tbody>
                        </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>   
</html>

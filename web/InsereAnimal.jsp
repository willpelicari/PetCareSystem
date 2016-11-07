<%@page import="java.util.*"%>
<%@page import="br.com.Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pessoa Pessoa = (pessoa) session.getAttribute("Pessoa");
    DAO dao = new DAO();
    List listaPessoa = dao.obtemListaPessoa();
    List listaTipoAnimal = dao.obtemListaTipoAnimal();
    Iterator it = listaPessoa.iterator();
    Iterator it2 = listaTipoAnimal.iterator();
    
    boolean admin = false;
    if (null != session.getAttribute("Tipo")) {
        if (Integer.parseInt(session.getAttribute("Tipo").toString()) == 1) {
            admin = true;
        }
    }
    boolean editar = false;
    animal a = new animal();
    if(request.getParameter("cod") != null){
        editar = true;
        a = dao.getAnimalPeloId(Integer.parseInt(request.getParameter("cod").toString()));
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
                        <div class="panel-heading"><h2>Cadastrar Novo Pet</h2></div>
                        <table class="table">
                            <form name="formIA" action="<%= (editar) ? "EA" : "IA" %>" method="POST">            
                                <thead>
                                    <tr>
                                        <th> Campos </th>
                                        <th> Valores </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td> Código</td>
                                        <td> <input type="number" name="idanimal" class="form-control" value="<%= (editar) ? a.getIdAnimal() : "" %>" <%= (editar) ? "readonly" : "" %>/></td>
                                    </tr>
                                    <tr>
                                        <td> Dono do Pet</td>
                                        <td>
                                            <select name="idpessoa" class="form-control">
                                                <option value="">Selecione...</option>
                                                <% if(!it.hasNext()){ %>
                                                <option value="" disabled>Favor cadastrar mais tipos</option>
                                                <% }else{
                                                    while (it.hasNext()) {
                                                    pessoa p = (pessoa)it.next();
                                                %>
                                                <option value="<%= p.getIdPessoa() %>" <%= (p.getIdPessoa() == a.getIdPessoa()) ? "selected" : "" %>><%= p.getNome()%></option>
                                                <% }} %>
                                            </select>
                                        </td>
                                    </tr>                                    
                                    <tr>
                                        <td> Nome do Pet</td>
                                        <td> <input type="text" name="nome" size="100" class="form-control" value="<%= (editar) ? a.getNome() : ""%>"/></td>
                                    </tr>
                                    <tr>
                                        <td> Tipo de Pet</td>
                                        <td>
                                            <select name="idtipo" class="form-control">
                                                <option value="">Selecione...</option>
                                                <% if(!it2.hasNext()){ %>
                                                <option value="" disabled>Favor cadastrar mais tipos</option>
                                                <% }else{
                                                    while (it2.hasNext()) {
                                                    tipoanimal ta = (tipoanimal)it2.next();
                                                %>
                                                <option value="<%= ta.getIdTipoAnimal() %>" <%= (ta.getIdTipoAnimal() == a.getIdTipo()) ? "selected" : "" %>><%= ta.getDescricao()%></option>
                                                <% }} %>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> Raça</td>
                                        <td> <input type="text" name="raca" size="100" class="form-control" value="<%= (editar) ? a.getRaca() : ""%>"/></td>
                                    </tr>
                                    <tr>
                                        <td> Data de Nascimento</td>
                                        <td> <input type="date" name="dtnasc" size="100" class="form-control" value="<%= (editar) ? a.getDtNasc() : ""%>"/></td>
                                    </tr>
                                    <tr>
                                        <td> Observações</td>
                                        <td> <input type="text" name="observacoes" size="100" class="form-control" value="<%= (editar) ? a.getObservacoes() : ""%>"/></td>
                                    </tr>                                    
                                    <tr><td colspan="2"><input class="btn btn-default btn-success" type="submit" value="<%= (editar) ? "ATUALIZAR" : "ENVIAR" %>" name="ENVIAR" /><span>  </span><input class="btn btn-default btn-primary" onclick="history.back()" type="submit" value="VOLTAR" name="VOLTAR" /></td></tr>
                                </tbody>
                        </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>   
</html>
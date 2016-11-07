<%-- 
    Document   : Sistema
    Created on : Jun 6, 2016, 10:48:26 PM
    Author     : WiltonPelicari
--%>

<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="br.com.Modelo.*, java.util.*"%>
<%
    DAO dao = new DAO();
    List eventos = (List<evento>) session.getAttribute("Eventos");
    pessoa p = (pessoa) session.getAttribute("Pessoa");
    List animais = (List<animal>) session.getAttribute("Animais");
    Iterator it_eventos = eventos.iterator();
    Iterator it_animais = animais.iterator();
    
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
                        <div class="panel-heading"><h2>Eventos Futuros</h2></div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Identificação</th>
                                    <th>Data</th>
                                    <th>Descrição do Evento</th>
                                    <th>Nome do Pet</th>
                                    <th>Responsável</th></tr>
                            </thead>
                            <tbody>
                                <% if(!it_eventos.hasNext()){ %>
                                <tr><td colspan="5" class="text-center">Não há eventos futuros</td></tr>
                                <% }else{
                                    while (it_eventos.hasNext()) {
                                    evento ev = (evento)it_eventos.next();
                                %>
                                    <tr>
                                        <td><a href="InsereEvento.jsp?cod=<%= ev.getIdEvento() %>"><%= ev.getIdEvento() %></a></td>
                                        <td><a href="InsereEvento.jsp?cod=<%= ev.getIdEvento() %>"><%= ev.getData() %></a></td>
                                        <td><a href="InsereEvento.jsp?cod=<%= ev.getIdEvento() %>"><%= ev.getDescricao() %></a></td>
                                        <td><a href="InsereEvento.jsp?cod=<%= ev.getIdEvento() %>"><%= dao.getNomeAnimalPeloId(1) %></a></td>
                                        <td><a href="InsereEvento.jsp?cod=<%= ev.getIdEvento() %>"><%= p.getNome() %></a></td>
                                    </tr>
                                <% }} %>    
                            </tbody>
                        </table>
                    </div>
                            
                    <div class="panel panel-default">
                        <div class="panel-heading"><h2>Meus Pets</h2></div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Identificação</th>
                                    <th>Nome</th>
                                    <th>Tipo de Pet</th>
                                    <th>Raça</th>
                                    <th>Data de Nascimento</th>
                                    <th>Observações</th></tr>
                            </thead>
                            <tbody>
                                <% if(!it_animais.hasNext()){ %>
                                <tr><td colspan="6" class="text-center">Não há pets cadastrados</td></tr>
                                <% }else{
                                    while (it_animais.hasNext()) {
                                    animal an = (animal)it_animais.next();
                                %>
                                    <tr>
                                        <td><a href="InsereAnimal.jsp?cod=<%= an.getIdAnimal() %>"><%= an.getIdAnimal() %></a></td>
                                        <td><a href="InsereAnimal.jsp?cod=<%= an.getIdAnimal() %>"><%= an.getNome() %></a></td>
                                        <td><a href="InsereAnimal.jsp?cod=<%= an.getIdAnimal() %>"><%= dao.getNomeTipoAnimalPeloId(an.getIdTipo()) %></a></td>
                                        <td><a href="InsereAnimal.jsp?cod=<%= an.getIdAnimal() %>"><%= an.getRaca() %></a></td>
                                        <td><a href="InsereAnimal.jsp?cod=<%= an.getIdAnimal() %>"><%= an.getDtNasc() %></a></td>
                                        <td><a href="InsereAnimal.jsp?cod=<%= an.getIdAnimal() %>"><%= an.getObservacoes() %></a></td>
                                    </tr>
                                <% }} %>    
                            </tbody>
                        </table>
                    </div>                            
                </div>
            </div>
        </div>
    </body>
</html>

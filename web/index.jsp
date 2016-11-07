<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="full">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title> Página Inicial </title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12">
                    <h1>PetCare System</h1>
                    <p>PetCare System é parte de um trabalho interdisciplinar entre as matérias de <i>Engenharia de Software I, Banco de Dados II e Linguagens de Programação III</i> da <b>Universidade do Sagrado Coração.</b></p>
                    <% 
                        if(null != request.getAttribute("erro"))
                        if(Integer.parseInt(request.getAttribute("erro").toString())==1){
                            out.println("<div class='alert alert-danger' role='alert'>Usuário ou senha Incorretos!</div>");
                        }
                    %>
                    <form name="formAP" action="AP" method="POST" role="form">
                        <div class="form-group">

                            <label for="login">
                                Usuário
                            </label>
                            <input type="username" class="form-control" id="login" name="login"/>
                        </div>
                        <div class="form-group">

                            <label for="senha">
                                Senha
                            </label>
                            <input type="password" class="form-control" id="senha" name="senha"/>
                        </div>
                        <button type="submit" class="btn btn-default btn-success">
                            Entrar
                        </button>
                        <a href="InserePessoa.jsp" class="btn btn-default btn-primary">
                            Novo Usuário
                        </a>                        
                    </form>
                </div>
            </div>
        </div>      
    </body>
</html>

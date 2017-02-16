<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Disciplina: Projeto e Implementação OO </title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
              integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <link rel="stylesheet" href="http://getbootstrap.com/examples/sticky-footer/sticky-footer.css">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style type="text/css"
            #navbar .nav > li > a {
                 position: relative;
                 display: block;
                 padding: 10px 10px !important;
               }
        </style>
    </head>
    <body role="document">
        <!-- Fixed navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="">Disciplina: Projeto e Implementação OO </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
                        <li><a href="<%=request.getContextPath()%>/cadastro.jsp">Cadastro</a></li>
                        <li><a href="<%=request.getContextPath()%>/atualizar-cadastro.jsp">Atualizar Cadastro</a></li>
                        <li><a href="<%=request.getContextPath()%>/Controller?command=CadastrarOpcionais">Cadastrar Opcionais</a></li>
                        <li><a href="<%=request.getContextPath()%>/Controller?command=ListarUsuarios">Listar Usuarios</a></li>
                        <li><a href="<%=request.getContextPath()%>/Controller?command=ListarOpcionais">Listar Opcionais</a></li>
                        
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div style="clear: both; display: block; margin-bottom: 180px"></div>   
        <div class="container"  role="main">        
            Bem-vindo <c:if test="${sessionScope.login != null }" >  , ${sessionScope.login }!
                            <a href="<%=request.getContextPath()%>/Controller?command=Logout">Logout</a>
                      </c:if>  

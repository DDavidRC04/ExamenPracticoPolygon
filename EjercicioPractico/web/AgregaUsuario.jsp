<%-- 
    Document   : AgregaUsuario
    Created on : Sep 19, 2018, 12:37:55 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="container">
        <nav class="navbar navbar-inverse">
            <div class="navbar-header">
                <h3 style="color:white;"> Nuevo Usuario </h3>
            </div>
        </nav>
        <div>
            <form id="newUser" action="procesaAlta.jsp" method="post">
                <div class="form-group">
                    <label for="Nom">Nombre:</label>
                    <input type="text" class="form-control" name="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Ape">Apellidos:</label>
                    <input type="text"input class="form-control" name="Ape" required>
                </div>
                <div class="form-group">
                    <label for="Em">Email:</label>
                    <input type="email" class="form-control" name="Em" required>
                </div>
                <div class="form-group">
                    <label for="Pass">Contraseña:</label>
                    <input type="password" class="form-control" name="Pass"required>
                </div>
                <div class="form-group">
                    <label for="Per">Nombre del perfil:</label>
                    <input type="text" class="form-control" name="Per" required>
                </div>
                <div class="form-group form-group-lg">
                    <label class="radio-inline"><input type="radio" name="habil" value="1" checked>Activo</label>
                    <label class="radio-inline"><input type="radio" name="habil" value="0">Inactivo</label>
                </div>
            </form>
            <div>
                <button id="btnCancela" class="btn btn-success navbar-btn" onclick="cancelaRegistro()"> Cancelar </button>
                <button id="btnAlta" class="btn btn-danger navbar-btn" onclick="aceptarCambios()"> Guardar </button>
            </div>
            
            <script>
                function aceptarCambios() {
                    if(document.getElementsByName("Nom")[0].value!= "" && document.getElementsByName("Ape")[0].value != ""
                            && document.getElementsByName("Em")[0].value != "" && document.getElementsByName("Pass")[0].value != ""
                            && document.getElementsByName("Per")[0].value != ""){  
                        document.getElementById("newUser").submit();
                    }else{alert("Se necesita llenar todos los campos");}
                    
                }
                function cancelaRegistro(){
                    location.href='index.jsp';
                    
                }
            </script> 
        </div>
    </body>
</html>

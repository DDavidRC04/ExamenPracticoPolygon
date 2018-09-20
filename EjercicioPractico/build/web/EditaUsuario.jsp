<%-- 
    Document   : EditaUsuario
    Created on : Sep 19, 2018, 9:13:08 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objConn" class="Mysql.MySqlConn"/>
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
                <h3 style="color:white;"> Modifica Usuario </h3>
            </div>
        </nav>
        <div>
            <%
                String[] chk = null;
                String aux="";
                String consulta="";
                String cambio="";
                chk = request.getParameterValues("chkRow");
                if(chk != null){//obtengo los datos del usuario seleccionado con el checkbox y hago un vaciado de estos al form que procesara los cambios
                    //para que el usurio vea los valores previos
                        consulta = "select idUsuario,claveusuario,Nombre,Apellido,email,contrasena,fechaupdate,nombreperfil,habilitado from (SELECT "
                                + "usr.*, pf.* FROM example.usuario as usr LEFT JOIN example.usuarioperfil as up ON usr.idUsuario = up.idUsuario left "
                                + "join example.perfil as pf on up.idPerfil = pf.idPerfil) as x where x.idUsuario="+ chk[0]+";";
                        objConn.Consult(consulta);
                }
            %>
            <form id="updateUser" action="procesaCambio.jsp" method="post">
                <input type="text" class="form-control" name="id" value='<%=objConn.rs.getString(1)%>' style='visibility: hidden;'>
                <div class="form-group">
                    <label for="Nom">Nombre:</label>
                    <input type="text" class="form-control" name="Nom" value='<%=objConn.rs.getString(3)%>' required>
                </div>
                <div class="form-group">
                    <label for="Ape">Apellidos:</label>
                    <input type="text"input class="form-control" name="Ape" value='<%=objConn.rs.getString(4)%>' required>
                </div>
                <div class="form-group">
                    <label for="Em">Email:</label>
                    <input type="email" class="form-control" name="Em" value='<%=objConn.rs.getString(5)%>' required>
                </div>
                <div class="form-group">
                    <label for="Pass">Contraseña:</label>
                    <input type="password" class="form-control" name="Pass" value='<%=objConn.rs.getString(6)%>' required>
                </div>
                <div class="form-group">
                    <label for="Per">Nombre del perfil:</label>
                    <input type="text" class="form-control" name="Per" value='<%=objConn.rs.getString(8)%>' required>
                </div>
                <div class="form-group form-group-lg">
                    <%if(objConn.rs.getBoolean(9)){
                        out.print("<label class='radio-inline'><input type='radio' name='habil' value='1' checked>Activo</label> ");
                        out.print("<label class='radio-inline'><input type='radio' name='habil' value='0'>Inactivo</label> ");
                    }else{
                        out.print("<label class='radio-inline'><input type='radio' name='habil' value='1' >Activo</label> ");
                        out.print("<label class='radio-inline'><input type='radio' name='habil' value='0' checked>Inactivo</label> ");
                    }
                    %>        
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
                        document.getElementById("updateUser").submit();
                    }else{alert("Se necesita llenar todos los campos");}
                    
                }
                function cancelaRegistro(){
                    location.href='index.jsp';
                    
                }
            </script> 
        </div>
    </body>
</html>

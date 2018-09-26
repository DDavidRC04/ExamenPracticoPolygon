<%-- 
    Document   : index
    Created on : Sep 18, 2018, 6:05:09 PM
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
        <nav class="container-fluid navbar navbar-inverse">
            <div class=" navbar-right"> 
                <button id="btnAlta" class="btn btn-success navbar-btn" onclick="llamaRegistro()"> Registro Usuario </button>
                <button id="btnModifica" class="btn btn-info navbar-btn" onclick="actualizaRegistro()"> Editar Usuario </button>
                <button id="btnBaja" class="btn btn-danger navbar-btn" onclick="bajaRegistro()"> Eliminar Usuario(s) </button>
            </div>
            <script>
                function llamaRegistro(){
                    location.href='AgregaUsuario.jsp';
                }
                                
                function actualizaRegistro(){
                    var  rows = document.getElementsByName("chkRow"); 
                    var nChecked = 0;
                    
                    for (var i=0;i<rows.length;i++){
                        if (rows[i].checked){
                            nChecked++;
                        }
                    }
                    if(nChecked > 1){
                        alert("Selecciona solo un registro por favor");
                    } else if(nChecked == 0){
                        alert("Selecciona un Registro por favor");
                    }
                    if(nChecked == 1){
                        document.getElementById("selectedRows").action = "EditaUsuario.jsp";
                        document.getElementById("selectedRows").submit();
                    }
                }
                
                function bajaRegistro(){
                    var  rows = document.getElementsByName("chkRow"); 
                    var nChecked = 0;
                    
                    for (var i=0;i<rows.length;i++){
                        if (rows[i].checked){
                            nChecked++;
                        }
                    }
                    if(nChecked > 0){
                        document.getElementById("selectedRows").action = "procesaBaja.jsp";
                        document.getElementById("selectedRows").submit();  
                    }else if (nChecked == 0){
                        nChecked=0;
                        alert("Selecciona un Registro por favor");
                    }                            
                }
            </script>    
        </nav>
        <div>
            <form method="post" id="selectedRows" action="">
                <table class="table table-striped table-hover">
                    <tr>
                        <th></th>
                        <th>idUsuario</th>
                        <th>Clave Usuario</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>E-Mail</th>
                        <th>Contraseña</th>
                        <th>Fecha Actualizacion</th>
                        <th>idPerfil</th>
                        <th>Nombre de Perfil</th>
                        <th>Habilitado</th>
                    </tr>

                    <%  
                        int n = 0;//almacena la cantidad de registros en la tabla
                        //realiza la cnsulta para obtener los datos de ambas tablas
                        String consulta="SELECT usr.*, pf.idPerfil, pf.nombreperfil,if(pf.habilitado = b'1','TRUE', 'FALSE')FROM example.usuario as usr LEFT JOIN example.usuarioperfil as up ON usr.idUsuario = up.idUsuario left join example.perfil as pf on up.idPerfil = pf.idPerfil;";
                        objConn.Consult(consulta);
                        //si la consulta retorna un resultado 
                        if(objConn.rs!=null){
                            try{//obtengo la cantidad de registros en la tabla
                                objConn.rs.last();//voy al ultimo registro de la tabla
                                n=objConn.rs.getRow();//obtengo el total de registros
                                objConn.rs.first();//regreso al inicio de la tabla
                            }catch(Exception e){}
                            try{
                                for(int j=1;j<=n;j++){//despliego la tabla en pantalla, primero me desplazo por las filas%>
                                <tr>
                                    <td> 
                                        <input class="checkbox" name="chkRow" value="<%= objConn.rs.getString(1)%>" type="checkbox">
                                    </td>
                    <%                
                                    for(int i=1; i<=10; i++){ %>
                                    <td>
                    <%                    if(i != 10){%>
                                            <%=objConn.rs.getString(i)%>
                    <%                    }else{  %>
                                            <%=objConn.rs.getBoolean(i)%>
                    <%                    }%>
                                    </td>
                    <%                }
                                objConn.rs.next();// me desplazo al siguiente registro%>
                                    
                                </tr>
                    <%            }
                            }catch(Exception ex){}    
                        }
                    %>
                </table>
            </form>    
        </div>    
    </body>
</html>

<%-- 
    Document   : procesaBaja
    Created on : Sep 19, 2018, 3:46:51 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objConn" class="Mysql.MySqlConn"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] chk = null;//almacena los valores de los checkbox seleccionados
            String baja="";
            chk = request.getParameterValues("chkRow");
            if(chk != null){//doy de baja los usuarios hayan sido seleccionados en los checkbox
                for(int i=0;i<chk.length;i++){
                    baja = "delete from usuarioperfil where idUsuario="+chk[i]+";";
                    objConn.Update(baja);
                    baja = "delete from usuario where idUsuario="+chk[i]+";";
                    objConn.Update(baja);
                    baja = "delete from perfil where idPerfil="+chk[i]+";";
                    objConn.Update(baja);
                    
                }
                objConn.closeRsStmt();
            }//
        %>
        <jsp:forward page="index.jsp"/>
    </body>
</html>

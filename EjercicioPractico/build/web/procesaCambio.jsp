<%-- 
    Document   : procesaCambio
    Created on : Sep 19, 2018, 10:29:48 PM
    Author     : diego
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objConn" class="Mysql.MySqlConn"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%String idUsr,cUsr,nom,ape,em,pass,nomPerf,activo;
        String cambio = ""; //obtengo todos los valores del formulario
            idUsr =(request.getParameter("id"));
            nom= (request.getParameter("Nom")).trim();
            ape = (request.getParameter("Ape")).trim();
            em = (request.getParameter("Em")).trim();
            pass = (request.getParameter("Pass")).trim();
            nomPerf = (request.getParameter("Per")).trim();
            activo= request.getParameter("habil");
            Date fecha = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //actualizo los valores en latabla usuario
            cambio = "update usuario set Nombre='"+nom+"',Apellido='"+ape+"',email='"+em+"',contrasena='"+pass+"',fechaupdate='"+dt.format(fecha)
                    +"' where idUsuario="+idUsr+";";
            objConn.Update(cambio);
            //actualizo todos los valores en la tabla perfil
            cambio = "update perfil set nombreperfil='"+nomPerf+"',habilitado=b'"+activo+"' where idPerfil="+idUsr+";";
            objConn.Update(cambio);
            objConn.closeRsStmt();
        %>
        <jsp:forward page="index.jsp"/>
    </body>
</html>

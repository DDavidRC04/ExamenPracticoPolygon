<%-- 
    Document   : procesaAlta
    Created on : Sep 19, 2018, 8:23:04 AM
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
        <%
            int n = 0;
            //String idUsuario,idPerfil,claveusuario,Nombre,Apellido,email,contasena,nombreperfil,habilitado;
            String cUsr,nom,ape,em,pass,nomPerf,activo;
            int idUsr,idPerf;
            String consulta="SELECT usr.*, pf.* FROM example.usuario as usr LEFT JOIN example.usuarioperfil as up ON usr.idUsuario = up.idUsuario left join example.perfil as pf on up.idPerfil = pf.idPerfil;";
            objConn.Consult(consulta);//consulta que me obtiene todos los registros en ambas tablas
            if(objConn.rs!=null){
                try{
                    objConn.rs.last();//me posiciono en el ultimo reg
                    n=objConn.rs.getRow();//total de registros
                    objConn.rs.first();//vuelvo al primer registro
                }catch(Exception e){}
            }
            //ontengo todos los datos del formulario
            n++;
            idUsr = n;
            idPerf = n;
            cUsr = "usr" + n;
            nom= (request.getParameter("Nom"));
            ape = (request.getParameter("Ape")).trim();
            em = (request.getParameter("Em")).trim();
            pass = (request.getParameter("Pass")).trim();
            nomPerf = (request.getParameter("Per")).trim();
            activo= request.getParameter("habil");
            Date fecha = new Date();//obtengo la fecha del sistema 
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//le doy e formato necesario para el campo en la bd
            
            //insert en usuario
            String alta = "Insert into usuario (idUsuario,claveusuario,Nombre,Apellido,email,contrasena,fechaupdate)"
                + " values("+idUsr+",'"+cUsr+"','"+nom+"','"+ape+"','"+em+"','"+pass+"','"+dt.format(fecha)+"');";
            objConn.Update(alta);
            //inserto en perfil
            alta = "Insert into perfil (idPerfil,nombreperfil,habilitado) values("+idPerf+",'"+nomPerf+"',"+activo+");";
            objConn.Update(alta);
            
            //inserto en la relacion
            alta = "insert into usuarioperfil values("+ idUsr+","+idPerf+");";
            objConn.Update(alta);
            objConn.closeRsStmt();//
        %>
        <jsp:forward page="index.jsp"/>
        
    </body>
</html>

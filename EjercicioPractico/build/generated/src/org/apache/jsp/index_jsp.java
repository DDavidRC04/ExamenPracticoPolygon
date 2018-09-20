package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      Mysql.MySqlConn objConn = null;
      synchronized (_jspx_page_context) {
        objConn = (Mysql.MySqlConn) _jspx_page_context.getAttribute("objConn", PageContext.PAGE_SCOPE);
        if (objConn == null){
          objConn = new Mysql.MySqlConn();
          _jspx_page_context.setAttribute("objConn", objConn, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ejercicio</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <!-- jQuery library -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <!-- Latest compiled JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <nav class=\"container navbar navbar-inverse\">\n");
      out.write("            <div class=\" nav navbar-nav navbar-right\"> \n");
      out.write("                <button id=\"btnAlta\" class=\"btn btn-success navbar-btn\" onclick=\"llamaRegistro()\"> Registro Usuario </button>\n");
      out.write("                <button id=\"btnAlta\" class=\"btn btn-info navbar-btn\"> Editar Usuario </button>\n");
      out.write("                <button id=\"btnBaja\" class=\"btn btn-danger navbar-btn\"> Eliminar Usuario(s) </button>\n");
      out.write("            </div>\n");
      out.write("            <script>\n");
      out.write("                function llamaRegistro(){\n");
      out.write("                    location.href='AgregaUsuario.jsp';\n");
      out.write("                }\n");
      out.write("            </script>    \n");
      out.write("        </nav>\n");
      out.write("        <div>\n");
      out.write("            <form>\n");
      out.write("                <table class=\"table table-striped table-hover\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th></th>\n");
      out.write("                        <th>idUsuario</th>\n");
      out.write("                        <th>Clave Usuario</th>\n");
      out.write("                        <th>Nombre</th>\n");
      out.write("                        <th>Apellido</th>\n");
      out.write("                        <th>E-Mail</th>\n");
      out.write("                        <th>Contraseña</th>\n");
      out.write("                        <th>Fecha Actualizacion</th>\n");
      out.write("                        <th>idPerfil</th>\n");
      out.write("                        <th>Nombre de Perfil</th>\n");
      out.write("                        <th>Habilitado</th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    ");
  String aux ="";
                        int n = 0;
                        //String idUsuario,idPerfil,claveusuario,Nombre,Apellido,email,contasena,nombreperfil,habilitado;
                        //String idUsr,idPerf,cUsr,nom,ape,em,pass,nomPerf,activo;
                        String consulta="SELECT usr.*, pf.* FROM example.usuario as usr LEFT JOIN example.usuarioperfil as up ON usr.idUsuario = up.idUsuario left join example.perfil as pf on up.idPerfil = pf.idPerfil;";
                        objConn.Consult(consulta);
                        if(objConn.rs!=null){
                            try{
                                objConn.rs.last();
                                n=objConn.rs.getRow();//total de registros
                                objConn.rs.first();
                            }catch(Exception e){}
                            try{
                                for(int j=1;j<=n;j++){
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td> \n");
      out.write("                                        <input class=\"checkbox\" name=\"");
      out.print( objConn.rs.getString(1));
      out.write("\" type=\"checkbox\">\n");
      out.write("                                    </td>\n");
      out.write("                    ");
                
                                    for(int i=1; i<=10; i++){
      out.write("\n");
      out.write("                                    <td>\n");
      out.write("                    ");
                    if(i != 10){
      out.write("\n");
      out.write("                                            ");
      out.print(objConn.rs.getString(i));
      out.write("\n");
      out.write("                    ");
                    }else{  
      out.write("\n");
      out.write("                                            ");
      out.print(objConn.rs.getBoolean(i));
      out.write("\n");
      out.write("                    ");
                    }
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                    ");
                }
                                objConn.rs.next();
      out.write("\n");
      out.write("                                    \n");
      out.write("                                </tr>\n");
      out.write("                    ");
            }
                            }catch(Exception e){}    
                        }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </form>    \n");
      out.write("        </div>    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

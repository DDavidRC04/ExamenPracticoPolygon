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
      out.write("        <meta http-equiv=\"Cache-Control\" content=\"no-cache, mustrevalidate\">\n");
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
      out.write("        <nav class=\"container-fluid navbar navbar-inverse\">\n");
      out.write("            <div class=\" navbar-right\"> \n");
      out.write("                <button id=\"btnAlta\" class=\"btn btn-success navbar-btn\" onclick=\"llamaRegistro()\"> Registro Usuario </button>\n");
      out.write("                <button id=\"btnModifica\" class=\"btn btn-info navbar-btn\" onclick=\"actualizaRegistro()\"> Editar Usuario </button>\n");
      out.write("                <button id=\"btnBaja\" class=\"btn btn-danger navbar-btn\" onclick=\"bajaRegistro()\"> Eliminar Usuario(s) </button>\n");
      out.write("            </div>\n");
      out.write("            <script>\n");
      out.write("                function llamaRegistro(){\n");
      out.write("                    location.href='AgregaUsuario.jsp';\n");
      out.write("                }\n");
      out.write("                                \n");
      out.write("                function actualizaRegistro(){\n");
      out.write("                    var  rows = document.getElementsByName(\"chkRow\"); \n");
      out.write("                    var nChecked = 0;\n");
      out.write("                    \n");
      out.write("                    for (var i=0;i<rows.length;i++){\n");
      out.write("                        if (rows[i].checked){\n");
      out.write("                            nChecked++;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    if(nChecked > 1){\n");
      out.write("                        alert(\"Selecciona solo un registro por favor\");\n");
      out.write("                    } else if(nChecked == 0){\n");
      out.write("                        alert(\"Selecciona un Registro por favor\");\n");
      out.write("                    }\n");
      out.write("                    if(nChecked == 1){\n");
      out.write("                        document.getElementById(\"selectedRows\").action = \"EditaUsuario.jsp\";\n");
      out.write("                        document.getElementById(\"selectedRows\").submit();\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                function bajaRegistro(){\n");
      out.write("                    var  rows = document.getElementsByName(\"chkRow\"); \n");
      out.write("                    var nChecked = 0;\n");
      out.write("                    \n");
      out.write("                    for (var i=0;i<rows.length;i++){\n");
      out.write("                        if (rows[i].checked){\n");
      out.write("                            nChecked++;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    if(nChecked > 0){\n");
      out.write("                        document.getElementById(\"selectedRows\").action = \"procesaBaja.jsp\";\n");
      out.write("                        document.getElementById(\"selectedRows\").submit();  \n");
      out.write("                    }else if (nChecked == 0){\n");
      out.write("                        nChecked=0;\n");
      out.write("                        alert(\"Selecciona un Registro por favor\");\n");
      out.write("                    }                            \n");
      out.write("                }\n");
      out.write("            </script>    \n");
      out.write("        </nav>\n");
      out.write("        <div>\n");
      out.write("            <form method=\"post\" id=\"selectedRows\" action=\"\">\n");
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
                                for(int j=1;j<=n;j++){//despliego la tabla en pantalla, primero me desplazo por las filas
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td> \n");
      out.write("                                        <input class=\"checkbox\" name=\"chkRow\" value=\"");
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
                                objConn.rs.next();// me desplazo al siguiente registro
      out.write("\n");
      out.write("                                    \n");
      out.write("                                </tr>\n");
      out.write("                    ");
            }
                            }catch(Exception ex){}    
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

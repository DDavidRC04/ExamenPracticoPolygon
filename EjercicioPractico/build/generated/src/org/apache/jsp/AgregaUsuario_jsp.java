package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AgregaUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <h3> Nuevo Usuario </h3>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div>\n");
      out.write("            <form id=\"newUser\" action=\"procesaAlta.jsp\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Nom\">Nombre:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"Nom\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Ape\">Apellidos:</label>\n");
      out.write("                    <input type=\"text\"input class=\"form-control\" name=\"Ape\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Em\">Email:</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" name=\"Em\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Pass\">Contraseña:</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" name=\"Pass\"required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Per\">Nombre del perfil:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"Per\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group form-group-lg\">\n");
      out.write("                    <label class=\"radio-inline\"><input type=\"radio\" name=\"habil\" value=\"1\" checked>Activo</label>\n");
      out.write("                    <label class=\"radio-inline\"><input type=\"radio\" name=\"habil\" value=\"0 \">Inactivo</label>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <div>\n");
      out.write("                <button id=\"btnAlta\" class=\"btn btn-success navbar-btn\" onclick=\"\"> Cancelar </button>\n");
      out.write("                <button id=\"btnAlta\" class=\"btn btn-danger navbar-btn\" onclick=\"aceptarCambios()\"> Guardar </button>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <script>\n");
      out.write("                function aceptarCambios() {\n");
      out.write("                    if(document.getElementsByName(\"Nom\")[0].value!= \"\" && document.getElementsByName(\"Ape\")[0].value != \"\"\n");
      out.write("                            && document.getElementsByName(\"Em\")[0].value != \"\" && document.getElementsByName(\"Pass\")[0].value != \"\"\n");
      out.write("                            && document.getElementsByName(\"Per\")[0].value != \"\"){  \n");
      out.write("                        document.getElementById(\"newUser\").submit();\n");
      out.write("                    }else{confirm(\"Se necesita llenar todos los campos\");}\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
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

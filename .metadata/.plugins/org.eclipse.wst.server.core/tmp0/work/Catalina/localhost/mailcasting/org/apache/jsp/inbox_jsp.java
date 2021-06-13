/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.46
 * Generated at: 2021-06-13 07:44:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.api.model.*;
import com.api.service.*;
import java.util.*;
import java.text.*;

public final class inbox_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.api.service");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.api.model");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("			\r\n");
      out.write("<div>\r\n");
      out.write("								\r\n");

			if(session.getAttribute("username")!=null){
			String username=(String)session.getAttribute("username");		
			out.print("<h5>Inbox</h5>");
			if(request.getAttribute("delete")!=null){
			String delete=(String)session.getAttribute("username");		
			out.print("<font style='color:navy'>"+delete+"</font>");
			}
			try {
				List<InBoxModel> mails=InBoxService.getAllMailsByEmail(username);
				if(mails.size()>0){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				out.print("<div id='bottom'></div>");

				out.print("<table border=4 cellspacing='4' cellpadding='5'>");
				out.print("<tr><td>SENDER 	&nbsp;	&nbsp;</td><td>SUBJECT</td><th>MESSAGE	&nbsp; 	&nbsp;</td><td>DATE OF RECIEVING 	&nbsp;	&nbsp;</td><td>Delete</td></tr>");
				
				for(InBoxModel m:mails){
				int id=m.getId();
				String date=formatter.format(m.getDate());
				out.print("<tr onclick='viewMail("+id+")'>");
			if(m.getSender().length()>=5)
			out.print("<td>" + m.getSender().substring(0,5) + "....</td>");
				else
			out.print("<td>" + m.getSender() + "</td>");
				
				if(m.getSubject().length()>=5)
			out.print("<td>" + m.getSubject().substring(0,5) + "....</td>");
				else
			out.print("<td>" + m.getSubject() + "</td>");

				if(m.getMessage().length()>=5)
			out.print("<td>" + m.getMessage().substring(0,5) + "......</td>");
				else
			out.print("<td>" + m.getMessage() + "</td>");
				
				
				out.print("<td>" + date + "</td>");
				
				out.print("<td><a href='deleteInboxMail.jsp?id="+m.getId() + "'> Delete</a></td>");

						out.print("</tr>");

					}
					out.print("</table>");
					out.print("<table align='right'width='40%'>");

					out.print("</table>");
				}
				else{
					out.print("Inbox is empty");
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("Error1", "Plz Do login First");
		
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("index.jsp");
        return;
      }
      out.write("\r\n");
      out.write("		");

		
		}
	
      out.write("\r\n");
      out.write("		\r\n");
      out.write("								\r\n");
      out.write("</div>\r\n");
      out.write("									\r\n");
      out.write("				\r\n");
      out.write("			\r\n");
      out.write("		\r\n");
      out.write("	");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

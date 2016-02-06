package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Input extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3271915943920678226L;

	public Input() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletConfig config=getServletConfig();
		out.println(config.getServletName()+"<br/>");
		out.println(config.getServletContext()+"<br/>");
		out.println(config.getInitParameter("name")+"<br/>");
		out.println("<br/><br/><br/><br/>");
		
		Enumeration<String> names=config.getInitParameterNames();
		
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();
			
			out.print(config.getInitParameter(string)+"<br/>");
		}
		
		out.print("servlet  context");
		out.print("<br/>");
		
		ServletContext context=getServletContext();
		out.print(context.getInitParameter("name")+"<br/>");
		
		
		Enumeration<String> initParameterNames = context.getInitParameterNames();
		
		while (initParameterNames.hasMoreElements()) {
			String nameValue = (String) initParameterNames.nextElement();
			
			out.print(context.getInitParameter(nameValue)+"<br/>");
		}
		
//		response.sendRedirect("https://www.google.co.in/#q="+request.getParameter("name"));
		out.close();
	}
}

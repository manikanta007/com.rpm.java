package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Session2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession httpSession=request.getSession(false);
		out.print(httpSession.getAttribute("name"));
		
		
		Enumeration<String> attributeNames = httpSession.getAttributeNames();
		
		while (attributeNames.hasMoreElements()) {
			String sessionValue = (String) attributeNames.nextElement();
			out.print("<br/><br/>"+sessionValue+"\t"+httpSession.getAttribute(sessionValue));
		}
		
	}

}

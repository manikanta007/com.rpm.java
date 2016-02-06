package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicVo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BasicVo() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.print(request.getParameter("select")+"<br/>");
		writer.print(request.getParameter("sex")+"<br/>");
		
		
		String[] parameterValues = request.getParameterValues("hobbies");
		for (String value : parameterValues) {
			writer.print(value+"<br>");
		}
		
		writer.print(request.getParameter("file"));
		writer.close();
	}

}

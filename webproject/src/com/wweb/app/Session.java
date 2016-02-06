package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Session() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("name", "manikanta");
		httpSession.setAttribute("age", "24");
		httpSession.setAttribute("location", "shimoga");
		
		out.print("session ex");
		
		out.print("<a href=ss2>click here</a>");
		out.close();
		
	}
}

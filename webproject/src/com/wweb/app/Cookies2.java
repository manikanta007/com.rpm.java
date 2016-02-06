package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Cookies2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Cookies2() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	
		PrintWriter out=response.getWriter();
		
		//get the cookies data.
		
		Cookie[] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			
			out.print(cookies[i].getName()+"\t"+cookies[i].getValue());
		}
	}
	
	
}

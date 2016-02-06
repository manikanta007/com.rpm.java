package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cookies() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("welcome");
		
		Cookie coockiename = new Cookie("name", "manikanta");
		Cookie coockiename1 = new Cookie("namea", "manikantaa");
		Cookie coockiename2 = new Cookie("name1", "manikantaaa");
		Cookie coockiename3 = new Cookie("name3", "manikantaaa");
		response.addCookie(coockiename);
		response.addCookie(coockiename1);
		response.addCookie(coockiename2);
		response.addCookie(coockiename3);
		
		out.print("<a href=s2>click here</a>");
		
		out.close();
	}
}

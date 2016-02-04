package com.wweb.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MyFilter implements Filter {
	public MyFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		System.out.println("before");
		writer.print("before filter");
		if (request.getParameter("user").equalsIgnoreCase("asd") && request.getParameter("password").equalsIgnoreCase("asd")) {
			chain.doFilter(request, response);
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		System.out.println("after");
		writer.print("after filter");
		writer.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
